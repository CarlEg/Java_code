package com.carl;

public class Planet extends HeavenlyBody {

    public Planet(String name, double orbitalPeriod) {
        super(name,orbitalPeriod,BodyType.PLANET);
    }


    @Override
    public boolean addSatellites(HeavenlyBody satellite) {
        if (satellite.getKey().getBodyType() == BodyType.MOON){
            return super.addSatellites(satellite);
        }
        return false;
    }
}
