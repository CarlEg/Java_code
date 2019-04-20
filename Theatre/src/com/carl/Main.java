package com.carl;

public class Main {

    public static void main(String[] args) {


        Theatre Empire = new Theatre("Empire",9,12);

        //Empire.getSeats();
        Empire.reserveSeat("A02");
        Empire.cancelSeat("A02");
        Empire.reserveSeat("A02");
        //System.out.println( Empire.getTheatreName());
    }
}
