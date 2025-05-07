

/*-----( Import needed libraries )-----*/
#include <SPI.h>
#include <Ethernet.h>
#include <SimpleDHT.h>
#include <TimeLib.h>

// #include <Wire.h>

/*-----( Declare Constants and Pin Numbers )-----*/
int pinDHT11 = 7;
SimpleDHT11 dht11;
#define SENSORID 4058


// Enter a MAC address and IP address for your controller below.
// The IP address will be dependent on your local network:
byte mac[] = {
  0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };

/*-----( Declare objects )-----*/
IPAddress arduinoIp(192,168,3,5);
IPAddress gateway(192,168,3,5);
IPAddress subnet(255,255,255,0);


IPAddress serverIp(204,77,50,53);
int serverPort = 80;
char pageName[] = "/api/sensorreadings";

// dht11 DHT11;  //The Sensor Object
/*-----( Declare Variables )-----*/

//init ethernet client
EthernetClient client;
//declare http Post request data
char json[71]; //must be large enough to hold json payload
char jsonSearchStr [] = "\"dateTime\":\"";


#define delayMillis 10000UL
byte prevTempReading = 0;
unsigned long thisMillis = 0;
unsigned long lastMillis = 0;
//Stack reading to send server
byte tempStack[50];
time_t timeStack[50];
int stackIndex = -1;

void setup()   /****** SETUP: RUNS ONCE ******/ 
{
  // Open serial communications and wait for port to open:
  Serial.begin(115200);



  // start the Ethernet connection and the server:
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
    
    Ethernet.begin(mac,arduinoIp,gateway,subnet);
  }
  delay(1000);
}//--(end setup )---


void loop()   /*----( LOOP: RUNS OVER AND OVER AGAIN )----*/
{
Ethernet.maintain();

  thisMillis = millis();
  if (thisMillis - lastMillis > delayMillis) {
    lastMillis = thisMillis;

    byte currTempReading = 0;
    byte currHumidReading = 0;
    int err = SimpleDHTErrSuccess;
    err = dht11.read(pinDHT11, &currTempReading, &currHumidReading, NULL);

    if ((currTempReading <= prevTempReading-2) || (currTempReading >= prevTempReading + 2)) {

      if (stackIndex<50) {
        stackIndex++;
        tempStack [stackIndex] = currTempReading;
        prevTempReading=currTempReading;

        if (timeStatus()==timeSet)
          timeStack[stackIndex] = now();
        else
          timeStack[stackIndex] = 0;
      }
    }

      byte postSucceeded= true;

      while (postSucceeded && stackIndex >= 0) {
        time_t t =timeStack[stackIndex];
        if (t==0) {
        sprintf(json, "{'SensorID':%d,'Value':%d}", SENSORID, (int) tempStack[stackIndex]); 
        }
        else
        sprintf(json, "{'SensorID':%d,'Value':%d,'DateTime':'%04d-%02d-%02dT%02d:%02d:%02d'}", 
          SENSORID, (int) tempStack[stackIndex], year(t), month(t), day(t),hour(t),minute(t), second(t)); 


        Serial.println(json);
        postSucceeded = postPage(json);
        if (!postSucceeded) {
          Serial.println(F("Fail "));
          }
        else {
          Serial.println(F("Pass"));
          stackIndex--;
        }
      }
    }


} // END Loop

/*-----( Declare User-written Functions )-----*/

// --------------------------------- postPage()  ---------------------------------
// ---------------------- Performs http Post of json payload ---------------------
byte postPage(char* json)
{
  int inChar;

  char timChArr[35];
  bool serverTimeFound = false;


  Serial.println("postPage() connecting...");

  if (client.connect(serverIp, serverPort)) {
    Serial.println("postPage() connected");

    // send http header
    client.println("POST /propertymonitor/api/sensorreadings HTTP/1.1");
    client.println("Host: 192.168.3.5"); // Don't change. Leave set to server address.
    client.println("User-Agent: Arduino/uno ethernet");
    client.println("Connection: close");
    client.println("Content-Type: application/json");
    client.print("Content-Length: ");
    client.println(strlen(json));// number of bytes in the payload
    client.println();// important: need an empty line here
    // send payload
    client.println(json);
  }
  else
  {
    Serial.println(F("postPage() connect failed"));
    return 0;
  }

  int connectLoop = 0;

  while(client.connected())
  {

    int jsonSearchIndex=0;
    int jsonSearchStrLen=strlen(jsonSearchStr);

    //char jsonSearchStr [] = "\"dateTime\":\"";

    int timeIndex = 0;

    while(client.available())
    {
      inChar = client.read();
      
      Serial.write(inChar);
      if(jsonSearchIndex<jsonSearchStrLen) {            //if jsonSearchStr hasnt been found
        if (inChar == jsonSearchStr[jsonSearchIndex]) //if inChar matches next char in jsonSearchStr
          jsonSearchIndex++;
        else
              jsonSearchIndex=0;
      }
      else {
          if (!serverTimeFound && inChar != '"') {
            timChArr[timeIndex] = inChar;
            timeIndex++;
          }
          else {
            timChArr[timeIndex] = '/0';
            serverTimeFound = true;
          }
      }
        connectLoop = 0;

    }

    delay(1);
    connectLoop++;
    if(connectLoop > 10000)
    {
      Serial.println();
      Serial.println(F("Timeout"));
      client.stop();
    }
  }

  Serial.println();
  Serial.println(F("disconnecting."));
  client.stop();
  String timStr(timChArr);
    Serial.println(timStr);
  // Serial.println(timStr.substring(0,4));
  // Serial.println(timStr.substring(5,7));
  // Serial.println(timStr.substring(8,10));
  //     Serial.println(timStr.substring(11,13)); // hour
  //     Serial.println(timStr.substring(14,16)); // minute
  //     Serial.println(timStr.substring(17,19)); // second

  setTime( 
    timStr.substring(11,13).toInt(),
    timStr.substring(14,16).toInt(),
    timStr.substring(17,19).toInt(),
    timStr.substring(8,10).toInt(),
    timStr.substring(5,7).toInt(),
    timStr.substring(0,4).toInt());

    delay(2000);
  Serial.println();
  Serial.println("Time function results");
  Serial.println(year());
  Serial.println(month());
  Serial.println(day());
  Serial.println(hour());
  Serial.println(minute());
  Serial.println(second());

  return 1;
}
// //
// //Celsius to Fahrenheit conversion
// double Fahrenheit(double celsius)
// {
//   return 1.8 * celsius + 32;
// }

// //Celsius to Kelvin conversion
// double Kelvin(double celsius)
// {
//   return celsius + 273.15;
// }

// // dewPoint function NOAA
// // reference: http://wahiduddin.net/calc/density_algorithms.htm 
// double dewPoint(double celsius, double humidity)
// {
//   double A0= 373.15/(273.15 + celsius);
//   double SUM = -7.90298 * (A0-1);
//   SUM += 5.02808 * log10(A0);
//   SUM += -1.3816e-7 * (pow(10, (11.344*(1-1/A0)))-1) ;
//   SUM += 8.1328e-3 * (pow(10,(-3.49149*(A0-1)))-1) ;
//   SUM += log10(1013.246);
//   double VP = pow(10, SUM-3) * humidity;
//   double T = log(VP/0.61078);   // temp var
//   return (241.88 * T) / (17.558-T);
// }

// // delta max = 0.6544 wrt dewPoint()
// // 5x faster than dewPoint()
// // reference: http://en.wikipedia.org/wiki/Dew_point
// double dewPointFast(double celsius, double humidity)
// {
//   double a = 17.271;
//   double b = 237.7;
//   double temp = (a * celsius) / (b + celsius) + log(humidity/100);
//   double Td = (b * temp) / (a - temp);
//   return Td;
// }
// /* ( THE END ) */