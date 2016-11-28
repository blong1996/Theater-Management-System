import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: TicketSoldOutException.java
 *  Project: Theator-Management System
 *  Date: Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 3
 *  File Description:
 *
 *  This class is used to be the exception for when a customer attempts
 *  to pruchase a ticket when the movie has already been sold out or when
 *  their desired seat has been sold.
 *
 */


public class TicketSoldOutException extends Exception {

    private String message  = "";
    private String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());

    public TicketSoldOutException(){
        super();

    }

    /**
     *
     * @param message error message
     */
    public TicketSoldOutException(String message){

        super(message);
        this.message = message+"\nTransaction request date and time: "+timeStamp+"\n";

    }

    /**
     *
     * @return message the error message to be displayed
     */
    @Override
    public String getMessage() {
        return message;
    }


}