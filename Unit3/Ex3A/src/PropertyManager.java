import buisness.Person;
import data.TenantDB;
import ui.*;

import buisness.Tenant;
import java.io.IOException;


public class PropertyManager {


        public static void main(String[] args) throws IOException {

            TenantDB.loadTenantsFromFile();


//            createFileIfNotExist();
//            PersonDB.readLines();
            HomeController.printHomeScreen();



        }

        

    }







