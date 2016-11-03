/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: JuniorSuite.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This class is used to represent a Junior Suite.
 *  Junior Suites have a nightly rate of $180.00
 *
 */


public class JuniorSuite extends Room {

    /**
     * @param roomNumber this is a 4 digit integer that represents the room number
     */
    public JuniorSuite(int roomNumber) {
        super(roomNumber);
        setRoomType("Junior Suite");
        setRate(180.00);

    }



}
