package com.carl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<com.carl.HeavenlyBody> satellites;

    public enum BodyType{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
        }

        public HeavenlyBody(String name, double orbitalPeriod, BodyType bodyType) {
         this.key = new Key(name,bodyType);
            this.orbitalPeriod = orbitalPeriod;
            this.satellites = new LinkedHashSet<>();
        }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
            return orbitalPeriod;
        }

        public boolean addSatellites(HeavenlyBody satellite) {
            return this.satellites.add(satellite);
        }

        public Set<com.carl.HeavenlyBody> getSatellites() {
            return new HashSet<>(this.satellites);
        }

        public static Key makeKey(String name,BodyType bodyType){
        Key key = new Key(name,bodyType);
        return key;
        }

    @Override
    public int hashCode() {
        return this.key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj instanceof HeavenlyBody){
            HeavenlyBody theObject = (HeavenlyBody) obj;
            return key.equals(theObject.getKey());
        }
        return false;
    }

    //        private boolean createType(){
//            if (bodyType.equalsIgnoreCase("planet")){
//                Planet newPlanet = new Planet(n,this.bodyType,this.orbitalPeriod);
//                this.planets.add(newPlanet);
//                return true;
//            }
//            return false;
//        }

    @Override
    public String toString() {
        return this.key.getName() + " has an orbital period of: " + this.orbitalPeriod + " and is a " + this.key.getBodyType();
    }

    public static final class Key{

            private String name;
            private BodyType bodyType;

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
            return this.name.hashCode() + this.bodyType.hashCode() +57;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj.getClass()!= Key.class){
                return false;
            }
            Key key = (Key) obj;
            if (this.name.equals(key.getName())){
                return this.bodyType == (key.getBodyType());
            }
            return false;
        }
    }
}
