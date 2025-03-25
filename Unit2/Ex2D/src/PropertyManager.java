import data.PersonDB;
import ui.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PropertyManager {

    public static String tenantsFile = "C:\\Users\\Mason\\Documents\\tenants.txt";

        public static void main(String[] args) throws IOException {

            createFileIfNotExist();

            PersonDB.readLines();
            HomeController.printHomeScreen();

        }

        public static void createFileIfNotExist() throws IOException {

//            String directoryPath = getDirectoryPath(directoryName);
//
//            File directory = new File(directoryPath);
//
//            boolean directoryCreated = directory.mkdir();
//
//            if (directoryCreated) {
//                System.out.println("Directory created at "+ directoryPath);
//            } else {
//                System.out.println("Directory already exists at "+ directoryPath);
//            }
//
//            Path filePath = Paths.get(directoryPath, fileName);
//
//            File file = new  File(filePath.toString());
//
//            boolean fileCreated = file.mkdir();
//
//            if (fileCreated) {
//                System.out.println("File has been created at "+ filePath);
//            } else { System.out.println("File already Exists  "+ filePath); }

            Path filePath = Paths.get(tenantsFile);
            if (Files.notExists(filePath)) {
                Files.createFile(filePath);
            }
            System.out.println("File path: " + filePath);
        }



    }







