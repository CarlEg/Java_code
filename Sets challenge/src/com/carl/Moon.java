package com.carl;

public class Moon extends HeavenlyBody {

    public Moon(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyType.MOON);
    }

    @Override
    public boolean addSatellite(HeavenlyBody satellite) {
        return false;
    }
}
