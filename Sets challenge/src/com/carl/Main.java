package com.carl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {
        Planet temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

//        System.out.println("Planets");
//        for(HeavenlyBody planet : planets) {
//            System.out.println("\t" + planet.getKey());
//        }

//        HeavenlyBody body = solarSystem.get("Jupiter");
//        System.out.println("Moons of " + body.getKey());
//        for(HeavenlyBody marsMoon: body.getSatellites()) {
//            System.out.println("\t" + marsMoon.getKey());
//        }

//        Set<HeavenlyBody> moons = new HashSet<>();
//        for(HeavenlyBody planet : planets) {
//            moons.addAll(planet.getSatellites());
//        }

//        System.out.println("All Moons");
//        for(HeavenlyBody moon : moons) {
//            System.out.println("\t" + moon.getKey());
//        }

//        HeavenlyBody pluto = new Moon("Pluto", 248);
//        planets.add(pluto);

        HeavenlyBody testPlanet = new Moon("Venus", 72.0);
        solarSystem.put(testPlanet.getKey(),testPlanet);

        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Venus", HeavenlyBody.BodyType.MOON)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Venus", HeavenlyBody.BodyType.PLANET)));
//        for(HeavenlyBody planet : planets) {
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
//        }



//        System.out.println(solarSystem.get("Earth").getKey());
//        System.out.println(solarSystem.get("Earth").getOrbitalPeriod());
//        HeavenlyBody planet = new Planet("Earth2",2);
//        solarSystem.put("Earth", planet);
//        System.out.println(solarSystem.get("Earth").getKey());
//        System.out.println(solarSystem.get("Earth").getOrbitalPeriod());

//        HeavenlyBody Titan = new Planet("Titan",2);
//        HeavenlyBody Titan2 = new Moon("Titan" , 2);
//
//        System.out.println(Titan.equals(Titan2));
//        System.out.println(Titan2.equals(Titan));

    }
}
