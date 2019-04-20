package com.company;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private Set<HeavenlyBody> satellites = new HashSet<>();

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set getSatellites() {
        return satellites;
    }

    private Boolean addMoon(HeavenlyBody moon){
        satellites.add(moon);
        return true;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj==this){
            return true;
        }

        if (obj == null ||(obj.getClass() != this.getClass())){
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj){
//            return true;
//        }
//        System.out.println("obj.getClass()" + obj.getClass());
//        System.out.println("this.getClass()" + this.getClass());
//
//        if (obj == null || (obj.getClass() != this.getClass())){
//            return false;
//        }
//
//        String objName = ((HeavenlyBody) obj).getName();
//        return this.name.equals(objName);
//    }
}
