import java.util.Date;
import java.text.*;

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


class Room {

    private double rate;
    private boolean reserved;
    private int roomNumber, reservationNum;
    private String roomType, firstName, lastName;
    private boolean safe;
    private double total;
    private Date checkIn, checkOut;
    private int days;

    /**
     *
     * @param roomNumber this is a 4 digit integer that represents the room number
     */

    Room(int roomNumber) {
        this.firstName = "";
        this.lastName = "";
        this.reserved = false;
        this.roomNumber = roomNumber;
        this.safe = false;
        this.checkIn = null;
        this.checkOut = null;
        this.reservationNum = -1;
        this.days = 0;
        this.total = 0;

    }

    /**
     *
     * Getters and Setters for Room variables
     *
     */

    boolean isReserved() {
        return reserved;
    }


    void setRervation(boolean reserved, String firstName, boolean safe, String lastName, Date checkIn,
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

    int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    String getRoomType() {
        return roomType;
    }

    void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getLastName() {
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
    private String safeString() {
        if (safe)
            return "Yes";
        return "No";
    }

    private double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    int getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(int reservationNum) {
        this.reservationNum = reservationNum;
    }

    private Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    private Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    private int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    double getRate() {
        return rate;
    }

    void setRate(double rate) {
        this.rate = rate;
    }

    /**
     *
     * @return reservation String representation of the reservation.
     *
     */

    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String reservation = "Reservation #: "+getReservationNum()+"\nReserved for: "+getLastName()+", "+getFirstName()
                +"\nRoom #: "+getRoomNumber()+"\nRoom Type: "+getRoomType()+"\nNightly Rate: "+formatter.format(getRate())+
                "\nSafe Included : "+safeString() +"\nReservation Total: "+formatter.format(getTotal())+
                "\nCheck In Date and Time: "+getCheckIn().toString() +"\nCheck Out Date and Time: "+
                getCheckOut().toString()+"\nNumber of days: "+getDays();

        System.out.println(reservation);

        return reservation;
    }
}
