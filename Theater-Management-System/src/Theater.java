
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/*
import java.util.*;
import java.text.*;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Theater.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This class is used to represent the actual hotel it self. It takes in the number of rooms
 *  to be in the hotel and generates the rooms for it. Junior Suites are room numbers divisible
 *  by 5 Deluxe Rooms are divisible by 3 but not by 5, and all others are Standard Rooms.
 *
 */
class Theater {

    private int totalSeats;
    Date date;
    private int purchases;

    private String roomChoiceAlert;
    private ArrayList<Seat> theater = new ArrayList<Seat>();

    /**
     *
     * @param number of seats in the theater
     */
    Theater(int seats) {

        for (int i = 0; i < seats; i++) {
            theater.add(new Seat(i + 1));
        }
        this.totalSeats = seats;

        purchases = 0;
        date = new Date();
    }

    /**
     *
     * This method is used to purchaseTicket a new hotel room
     *
     * @param firstName String for the First Name on the reservation
     * @param lastName String for the Last Name on the reservation
     * @param roomType this String value represents one of the three room types
     * @param safe true if the reservation includes a safe
     * @return an integer representing the room number. if the room type is
     * unavailable or other error occurs, return -1
     */
    public int purchaseTicket(String firstName, String lastName, int seatNum, Date date, String showing) {

        SimpleDateFormat myDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateIn = myDateFormat.format(date);
        // Attempt to add reservation only if the inserted data is valid
        try {
            boolean seatFound = false; // boolean to see if room was found

            String receipt = "";
            if (!theaterFull()) {

                // check to see if the room they desire is available. If so, purchaseTicket it
                for (Seat seat : getTheater()) {
                    if (seat.getSeatNumber() == seatNum && !seat.isPurchased()) {
                        purchases++;
                        seat.setTicket(firstName, lastName, true,
                                dateIn, showing);
                        seatFound = true;
                        receipt = seat.toString();
                        // decrement number of rooms for specified type
                        totalSeats--;
                    }
                }
                // if seat found, return days. else give memo to user
                if (seatFound) {
                    setRoomChoiceAlert("Your ticket has been purchased! \n\n" + receipt);
                    return seatNum;
                } else {
                    setRoomChoiceAlert("Seat " + seatNum + " has been sold out!");
                }

            }

        } catch (ParseException e) {
            // Catch if there is an issue parsing the users inputted dates
            for (Seat seat : getTheater()) {
                seat.toString();
            }
            System.out.println("All Tickets are sold out!");
            setRoomChoiceAlert("Invalid date was entered. \nAccepted Date format: YYYY-MM-DD");

        }

        return -1;
    }

    String getRoomChoiceAlert() {
        return roomChoiceAlert;
    }

    private void setRoomChoiceAlert(String roomChoiceAlert) {
        this.roomChoiceAlert = roomChoiceAlert;
    }

    public Boolean theaterFull() {
        Boolean full = false;
        int counter = 0;
        for (Seat seat : getTheater()) {
            if (seat.isReserved()) {
                counter++;
//            } else {
//                System.out.println(seat.toString());
//            }

            }
            if (counter == this.totalSeats) {
                System.out.println("Theater is full!");
                full = true;
            }
        }
        return full;

    }

    /**
     *
     * This message returns a queried hotel reservation
     *
     * @param firstName first name on hotel room
     * @param lastName last name on hotel room
     * @param resNum reservation number
     * @return resDetails details for the reservation being searched
     *
     */
    public String returnTicket(String firstName, String lastName, int resNum) {

        if (firstName == null) {
            firstName = " ";
        } else if (lastName == null) {
            lastName = " ";
        }

        String resDetails = "";
        try {
            for (Seat seat : getTheater()) {
                if (seat.isPurchased() && (seat.getSeatNumber() == resNum
                        || (seat.getFirstName().equalsIgnoreCase(firstName)
                        && seat.getLastName().equalsIgnoreCase(lastName)))) {

                    
                    seat.setTicket("", "", false, "", "");
                    
                    resDetails = seat.toString();
                    break;
                } else {
                    resDetails = "There were no matching seat purchases found.";
                }

            }
        } catch (NullPointerException x) {
            resDetails = "There were no matching seat purchases found.";
        }
        return resDetails;

    }

    public int getTotalSeats() {
        return totalSeats;
    }

    @Override
    public String toString() {
        String theaterStatus = "Sold Seats: " + (50 - getTotalSeats())
                + ":\n\n";

        for (Seat seat : getTheater()) {
            if (seat.isPurchased()) {
                theaterStatus += seat.toString() + "\n\n";
            }
        }

        theaterStatus += "\n Available Seats: "
                + getTotalSeats();

        return theaterStatus;
    }

    /**
     * @return the theater
     */
    public ArrayList<Seat> getTheater() {
        return theater;
    }

    /**
     * @param theater the theater to set
     */
    public void setTheater(ArrayList<Seat> theater) {
        this.theater = theater;
    }
}
