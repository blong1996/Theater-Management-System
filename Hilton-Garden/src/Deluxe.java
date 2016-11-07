/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Deluxe.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This class is used to represent a Deluxe Hotel Room
 *  Deluxe Rooms have a nightly rate of $140.00
 *
 */


class Deluxe extends Room {

    /**
     * @param roomNumber this is a 4 digit integer that represents the room number
     */
    Deluxe(int roomNumber) {
        super(roomNumber);
        setRoomType("Deluxe");
        setRate(140.00);
    }

}
