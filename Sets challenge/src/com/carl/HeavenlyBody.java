package com.carl;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dev on 12/01/2016.
 */
public abstract class HeavenlyBody {
    public final Key key;
    public enum BodyType{
        STAR,
        PLANET,
        MOON
    }
    private  double orbitalPeriod;
    private Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
        this.key = new Key(name,bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

//    public HeavenlyBody() {
//    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public static Key makeKey(String name, BodyType bodyType){
        return new Key(name,bodyType);
    }

    public boolean addSatellite(HeavenlyBody satellite) {
        return this.satellites.add(satellite);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public boolean equals(Object obj) {
        return key.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public String toString() {
        return key.getName() + ": " + key.getBodyType() + " orbital period of " + getOrbitalPeriod();
    }

    public static class Key{

        private final String name;
        private final BodyType bodyType;

        public Key(String name, BodyType bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyType getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.bodyType.hashCode() + this.name.hashCode() + 21;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            Key objKey = (Key) obj;
            if (this.name.equals(objKey.getName())){
                return this.bodyType ==objKey.getBodyType();
            }
            return false;
        }
    }
}
