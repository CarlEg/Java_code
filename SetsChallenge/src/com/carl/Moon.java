package com.carl;

public class Moon extends HeavenlyBody {

    Key key;

    public Moon(String name,  double orbitalPeriod) {
        super(name,orbitalPeriod, BodyType.MOON);

    }



    @Override
    public Key getKey() {
        return key;
    }



}
