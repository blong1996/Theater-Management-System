import java.util.ArrayList;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Hotel.java
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


public class Hotel {

    private int numRooms;



    private String roomChoiceError;
    private ArrayList<Room> hotel = new ArrayList<Room>();

    /**
     *
     * @param rooms number of rooms in hotel
     */

    public Hotel(int rooms){
        this.numRooms = rooms;

            // Add rooms to hotel
        for (int x = 0; x < rooms; x++)  {
            if (x % 5 == 0)
                hotel.add(new Room(false,1000+x,"Junior Suite","","",false,180.00));
            else if(x % 3 == 0)
                hotel.add(new Room(false,1000+x,"Deluxe","","",false,140.00));
            else
                hotel.add(new Room(false,1000+x,"Standard","","",false,120.00));

        }

    }

    /**
     *
     * @param firstName String for the First Name on the reservation
     * @param lastName String for the Last Name on the reservation
     * @param roomType this String value represents one of the three room types
     * @param safe true if the reservation includes a safe
     * @return  an integer representing the room number. if the room type is unavailable or other
     *          error occurs, return -1
     */

    public int reserve( String firstName, String lastName, String roomType,
                        boolean safe) {




        return -1;
    }

    public String getRoomChoiceError() {
        return roomChoiceError;
    }

    public void setRoomChoiceError(String roomChoiceError) {
        this.roomChoiceError = roomChoiceError;
    }

}
