import java.util.Date;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Room.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This class is used to represent a given room in the Hotel
 *
 */


public class Room {

    private double rate;
    private boolean reserved;
    private int roomNumber, reservationNum;
    private String roomType, firstName, lastName;
    private boolean safe;
    private double total;
    private Date checkIn, checkOut;
    private int days;
    // need to add variables for the checkin and checkout dates
    /**
     *
     * @param roomNumber this is a 4 digit integer that represents the room number
     */

    public Room(  int roomNumber) {
        this.firstName = "";
        this.lastName = "";
        this.reserved = false;
        this.roomNumber = roomNumber;
        this.safe = false;
        this.checkIn = null;
        this.checkOut = null;
        this.reservationNum = 0;
        this.days = 0;
        this.total = 0;

    }

    /**
     *
     * Getters and Setters for Room variables
     *
     */

    public boolean isReserved() {
        return reserved;
    }


    public void setRervation(boolean reserved, String firstName, boolean safe, String lastName, Date checkIn,
                             Date checkOut, double total, int reservationNum, int days) {
        this.reserved = reserved;
        this.firstName = firstName;
        this.lastName = lastName;
        this.safe = safe;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.total = total;
        this.reservationNum = reservationNum;
        this.days = days;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean hasSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }
    public String safeString() {
        if (safe)
            return "Yes";
        return "No";
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        String reservation = "Reservation #: "+getReservationNum()+"\nReserved for: "+getLastName()+", "+getLastName()
                +"\nRoom #: "+getRoomNumber()+"\nRoom Type: "+getRoomType()+"\n Safe Included :"+safeString()
                +"\nReservation Total: "+getTotal()+"\nCheck In Date and Time: "+getCheckIn().toString()
                +"\nCheck Out Date and Time: "+getCheckOut().toString();

        System.out.println(reservation);

        return reservation;
    }
}
