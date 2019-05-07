package com.carl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer,Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0,"You are in the fountain"));
        locations.put(1, new Location(1,"You are at the T1 tower in mid lane"));
        locations.put(2, new Location(2,"You are at the T1 tower in bot lane"));
        locations.put(3, new Location(3,"You are at the T1 tower in top lane"));
        locations.put(4, new Location(4,"You are at the drake"));
        locations.put(5, new Location(5,"You are at the baron"));

        int locationID = 1;
        while(true){
            System.out.println(locations.get(locationID).getDescription());
            if (locationID == 0){
                break;
            }
            locationID = scanner.nextInt();
            if (!locations.containsKey(locationID)){
                System.out.println("That location does not exist");
            }
        }
    }
}
