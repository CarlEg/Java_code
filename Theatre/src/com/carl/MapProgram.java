package com.carl;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String,String> jojos = new HashMap<>();

        jojos.put("Jonathan Joestar", "The OG Jojo");
        jojos.put("Joseph Joestar", "Tommy-gun Jojo");
        jojos.put("Jotaro Kujo", "Ora Ora Jojo");
        jojos.put("Josuke Higashikata","Best hair Jojo");
        jojos.put("Giorno Giovanna", "I have a dream Jojo");

        for (String key: jojos.keySet()) {
            System.out.println(key + " : " + jojos.get(key));
        }

        if (jojos.containsKey("DIO")){
            jojos.replace("Giorno Giovanna","Kind of a Jojo?");
        }

        System.out.println(" ");
        for (String key: jojos.keySet()) {
            System.out.println(key + " : " + jojos.get(key));
        }
    }

}
