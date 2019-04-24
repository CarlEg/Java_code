package com.carl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Theatre Empire = new Theatre("Empire",9,12);
        List<Theatre.Seat> EmpireCopy = new ArrayList<>(Empire.seats);

        EmpireCopy.get(0).reserveSeat();

//        Empire.getSeats();
        Empire.reserveSeat("A01");
        Empire.cancelSeat("A01");
        Empire.reserveSeat("B09");
        //System.out.println( Empire.getTheatreName());
        printSeats(Empire.seats);
        Collections.shuffle(Empire.seats);
        printSeats(Empire.seats);
        sortSeats(Empire.seats);
        printSeats(Empire.seats);
    }

    public static void printSeats(List<Theatre.Seat> list){
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println(" ");
        System.out.println("=============================================");
    }

    public static void sortSeats(List<? extends Theatre.Seat> list){
        for (int i=0; i<list.size()-1; i++){
            for (int y=i+1; y<list.size(); y++){
                if (list.get(i).compareTo(list.get(y))>0){
                    Collections.swap(list,i,y);
                }
            }
        }
    }
}
