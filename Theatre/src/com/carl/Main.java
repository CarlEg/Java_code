package com.carl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Theatre Empire = new Theatre("Empire",9,12);

//        Empire.getSeats();
        Empire.reserveSeat("A01");
        Empire.cancelSeat("A01");
        Empire.reserveSeat("B09");
        //System.out.println( Empire.getTheatreName());
    }

}
