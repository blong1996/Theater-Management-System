/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Standard.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This class is used to represent a Standard Hotel Room
 *  Standard Rooms have a nightly rate of $120.00
 */


class Standard extends Room {

    /**
     * @param roomNumber this is a 4 digit integer that represents the room number
     */
    Standard(int roomNumber) {
        super(roomNumber);
        setRoomType("Standard");
        setRate(120.00);
    }
}
