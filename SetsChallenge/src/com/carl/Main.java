package com.carl;

import java.util.*;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new LinkedHashSet<>();


    public static void main(String[] args) {


        //Mercury
        HeavenlyBody temp = new Planet("Mercury",88);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        //Venus
        temp = new Planet("Venus",225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);

        //Earth
        temp = new Planet("Earth",365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        //System.out.println(solarSystem.get("Earth"));
        HeavenlyBody tempMoon = new Moon("Moon",27);
        System.out.println(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellites(tempMoon);


        //Mars
        temp = new Planet("Mars",687);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempMoon = new Moon("Phobos",0.8);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Deimos",1.6);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);

        //Jupiter
        temp = new Planet("Jupiter",4380);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempMoon = new Moon("Europa",4.3);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Io",1.6);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Ganymede",7.167);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);

        //Saturn
        temp = new Planet("Saturn", 10585);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempMoon = new Moon("Enceladus", 1.375);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Titan",16);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Mimas",0.958);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);

        //Uranus
        temp = new Planet("Uranus",30660);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempMoon = new Moon("Umbriel", 4.125);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Titania",8.708);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Oberon",13);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);

        //Neptune
        temp = new Planet("Neptune",60225);
        solarSystem.put(temp.getKey(),temp);
        planets.add(temp);
        tempMoon = new Moon("Triton", 5.875);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Neso",9855);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempMoon = new Moon("Proteus",1.125);
        temp.addSatellites(tempMoon);
        solarSystem.put(tempMoon.getKey(), tempMoon);


//        tempMoon = new Moon("Neptune",62222,temp);
//        solarSystem.put(tempMoon.key,tempMoon);
//        planets.add(tempMoon);


        HeavenlyBody planet = solarSystem.get(HeavenlyBody.makeKey("Earth", HeavenlyBody.BodyType.PLANET));
        for (HeavenlyBody moonList : planet.getSatellites()){
            System.out.println(moonList);
        }

//        for (HeavenlyBody planets : planets){
//            System.out.println(planets);
//            System.out.println(" ");
//        }


//        Moon moonNew = new Moon("Yo","moon",3,temp);
//        System.out.println(moon.equals(moonNew));
//        System.out.println(moonNew.equals(moon));
    }
}
