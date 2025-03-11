package data;

import buisness.Address;
import buisness.Building;

public class BuildingDB {

    private static int nextId = 2;

    public static Building getBuildingById(int id) {
        Building building = null;

        if (id==1) {
            Address address = new Address (
                    1,
                    "123 St Name", "",
                    "Red Wing",
                    "MN",
                    "55066");

            building = new Building(1, "Southeast Villas", address, 100);
        }

        return building;
    }
//public static int getNextId() {
//    return nextId++;
//}

}
