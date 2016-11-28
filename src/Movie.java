/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Movie.java
 *  Project: Theator-Management System
 *  Date: Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 3
 *  File Description:
 *
 *  This class is used to hold a given movie. Each movie has an array of ints
 *  which represent each seat, as well as a date and time for when the movie
 *  will be played.
 *
 */

import java.util.*;
import java.text.*;

public class Movie{

    private int seats;
    private int [] theater;
    private String date;
    private String time;
    private int tickets;


    /**
     *
     * @param seats number of seats in movie room
     * @param time time the movie will play
     * @param date date the movie will play
     */

    public Movie(int seats, String time, String date){

        this.date = date;
        this.seats = seats;
        this.time = time;
        this.tickets = seats;
        theater = new int[seats];
        for(int i = 1; i < seats; i++){

            theater[i] = 0;
        }

    }

    /**
     *
     * @return boolean value to depict if the theater room is full or not
     */
    public boolean theaterFull(){

        for(int i = 1; i < seats; i++) {
            if (this.theater[i] != 1)
            return false;

        }

        return true;

    }

    /**
     *
     * @param seat to be purchased by the customer upon it being available
     * @throws TicketSoldOutException
     */

    public void PurchaseTicket(int seat) throws TicketSoldOutException {

        if(!theaterFull()){ //this is the condition for if their ticket is available
            if (getSeat(seat) == 0) {
                System.out.println("\nYou have booked Seat #" + seat + " for the " + this.getTime() +
                        " showing of \"Louder Than Bombs\" on " + this.getDate()+"\n");
                this.bookSeat(seat);
            } else
                throw  new TicketSoldOutException("\nSeat # "+seat+" for the " + this.getTime() +
                        " showing of \"Louder Than Bombs\" on " + this.getDate()+" is not available.\n");

        } else {  //this is where the exception will be thrown because the seat is not available for their given time, uses all of the set variables

            throw new TicketSoldOutException("\nThere are currently no seats available for the " +
                    this.getTime() +" showing of \"Louder Than Bombs\" on "+ this.getDate()+"\n");

        }

    }

    /**
     *
     * This method allows a customer to return a ticket
     *
     * @param seat seat to be returned
     *
     */

    public void ReturnTicket(int seat) {
        if (getSeat(seat) == 1) {
            this.theater[seat] = 0;
            this.tickets++;
            System.out.println("Your  Seat #" + seat + " for the " + this.getTime() +
                    " showing of \"Louder Than Bombs\" on " + this.getDate()+ " has been returned.");
        } else
            System.out.println("Seat # " + seat + " has not yet been booked.");
    }

    /**
     * This method displays the theater room seating map
     */

    public void SeatMap() {

        System.out.println("\nBelow is the seat map for your selected movie. \n" +
                "The number to the left of the colon is the Seat # and the \n" +
                "number to the right depicts if the seat is available or not. \n" +
                "(0 = open, 1 = taken)\n\n");
        for(int i = 0; i < this.seats; i++) {
            if (i%10 == 0)
                System.out.println();
            System.out.print(i + ": "+this.theater[i]+ "\t");
        }

        System.out.println("\n\nThere are currently " + this.tickets+" seats available.\n\n");
    }

    /**
     * @param seat the seat to set
     */
    public void bookSeat(int seat) {
        this.theater[seat] = 1;
        this.tickets--;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @return the number of seats
     */
    public int getSeats() {
        return this.seats;
    }

    /**
     * @return whether or not the seat is available.
     */
    public int getSeat(int seat) {
        return theater[seat];
    }

}
