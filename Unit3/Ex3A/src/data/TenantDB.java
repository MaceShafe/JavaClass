package data;

import buisness.Tenant;

import java.io.*;
import java.time.LocalDateTime;

import java.util.ArrayList;

public class TenantDB {

private static final ArrayList<Tenant> tenantList = new ArrayList<>();

    public static final String FILE_NAME = "tenants.txt";


    public static int nextId = 1;

    public static void addTenant(Tenant tenant) throws IOException {
        tenantList.add(tenant);
        nextId++;
        saveTenantsToFile();

    }

    public static ArrayList<Tenant> getAllTenants() {
        return tenantList;
    }

    public static Tenant getTenantByID(int id) {

        // create null tenant that will be modified later

        for (Tenant tenant :tenantList) {
            if (tenant.getPersonId() == id) {
                return tenant;
            }
        }

        return null;
    }

    public static void removeTenant(Tenant tenant)  {
        tenantList.remove(tenant);
        saveTenantsToFile();

    }

    public static void removeTenantByID(int id)  {

        Tenant tenantToRemove = getTenantByID(id);
        removeTenant(tenantToRemove);
    }

    public static int getNextId() {
        return nextId;
    }

    public static void loadTenantsFromFile()  {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0].trim());
                    String firstName = parts[1].trim();
                    String lastName = parts[2].trim();
                    String userName = parts[3].trim();
                    double  currentBalance = Double.parseDouble(parts[4].trim());
                    LocalDateTime CreationDate = LocalDateTime.parse(parts[5].trim());

                    TenantDB.addTenant(new Tenant(id, CreationDate, firstName,lastName,userName, currentBalance));

                    //When loaded in, it turns all IDs to 0, I'm unsure on how to fix this.
                }
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + FILE_NAME + ", empty tenant file will be created");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage() + ", empty tenant file will be created");
        }
    }

    private static void saveTenantsToFile()  {
        try (PrintWriter writer = new PrintWriter( new FileWriter(FILE_NAME))) {
            for (Tenant tenant : tenantList) {
                writer.println(tenant.getPersonId() + "," + tenant.getFirstName() + "," + tenant.getLastName() + "," + tenant.getUserName() + "," + tenant.getCurrentBalance() + "," + tenant.getCreationDate());
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error saving Tenants");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

}
