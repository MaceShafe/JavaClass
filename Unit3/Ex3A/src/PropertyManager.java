import buisness.Person;
import data.PersonDB;
import ui.*;

import buisness.Person;
import buisness.Tenant;
import java.io.IOException;
import java.time.LocalDateTime;


public class PropertyManager {


        public static void main(String[] args) throws IOException {

            PersonDB.loadPersonsFromFile();

            Person person = new Person(101, "Mason", "Shafer", "M.Shafer");
            Tenant tenant = new Tenant(101, "Mason", "Shafer", "M.Shafer", 500.00);

//            createFileIfNotExist();
//            PersonDB.readLines();
            HomeController.printHomeScreen();



        }

        

    }







