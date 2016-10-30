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

    private boolean reserved;
    private int roomNumber;
    private String roomType, firstName, lastName;
    private boolean safe;
    private double total;
    // need to add variables for the checkin and checkout dates
    /**
     *
     * @param reserved this boolean variable is true if the room has been reserved
     * @param roomNumber this is a 4 digit integer that represents the room number
     * @param roomType this String value represents one of the three room types
     * @param firstName String for the First Name on the reservation
     * @param lastName String for the Last Name on the reservation
     * @param safe true if the reservation includes a safe
     */

    public Room( boolean reserved, int roomNumber, String roomType,
                 String firstName, String lastName, boolean safe, double total) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.reserved = reserved;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.safe = safe;
        this.total = total;

    }

    /**
     *
     * Getters and Setters for Room variables
     *
     */

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }



}
