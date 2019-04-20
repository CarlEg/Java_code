package com.carl;

import java.util.ArrayList;
import java.util.List;

 public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row<=lastRow; row++ ){
            for (int i =1; i<=seatsPerRow; i++){
                Seat seat = new Seat(row + String.format("%02d",i));
                seats.add(seat);
            }
        }
    }

    public boolean reserveSeat(String seatNumber){
        Seat seatRequested = null;  //creates a Seat with the value of null

        for (Seat seat : seats) { //foreach checks the full length of an array
            if (seat.getSeatNumber().equals(seatNumber)){
                seatRequested = seat;   //fills in the null value for the Seat created earlier
                seatRequested.reserveSeat();    //calls the reserveSeat method from the Seat class
                return true;
            }
        }

        if (seatRequested == null){
            System.out.println("Seat number: " + seatNumber + " does not exist");
            return false;
        }

        return false;
    }

    public boolean cancelSeat(String seatNumber){
        Seat seatRequested = null;

        for (Seat seat: seats) {
            if (seat.getSeatNumber().equals(seatNumber)){
                seatRequested = seat;
                return seatRequested.cancel();
            }
        }

        System.out.println("Seat number: " + seatNumber + " does not exist");
        return false;
    }

    public void getSeats() {
        for (Seat seat: seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public String getTheatreName() {
        return theatreName;
    }



    private class Seat{
        private final String seatNumber;
        private boolean reserved;

        private Seat(String seatNumber) {
            this.seatNumber = seatNumber;
            this.reserved = false;
        }

        public boolean reserveSeat(){
            if (!this.reserved){
                this.reserved = true;
                System.out.println("Seat number: " + this.seatNumber + " has been reserved");
                return true;
            }else{
                System.out.println("Seat number: " + this.seatNumber + " is already reserved soz");
                return false;
            }
        }

        public boolean cancel(){
            if (this.reserved) {
                this.reserved = false;
                System.out.println(this.seatNumber + " seat reservation has been cancelled");
                return true;
            }else{
                System.out.println("Seat has not been booked");
                return false;
            }
        }

        private String getSeatNumber() {
            return seatNumber;
        }
    }
}
