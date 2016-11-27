
import java.util.Date;
import java.text.*;

/**
 *
 * @author Brandon Long, Aaren Avery File: Room.java Project: Hilton-Garden
 * Date: Oct-Nov 2016 Class: COMP260 Programming Languages, Dr. Yu Assignment:
 * Project 2 File Description:
 *
 * This class is used to represent a given room in the Hotel
 *
 */
class Seat {

    private boolean purchased;
    private int seatNumber, ticketNum;
    private String firstName, lastName, showing, purchaseDate;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     *
     * @param roomNumber this is a 4 digit integer that represents the room
     * number
     */
    Seat(int seatNum) {
        this.firstName = "";
        this.lastName = "";
        this.purchased = false;
        this.purchaseDate = "";
        this.seatNumber = seatNum;
        this.showing = "";
        this.ticketNum = 0;
    }

    public void setTicket(String firstName, String lastName, Boolean purchased,
            String purchaseDate, String showing) {
        this.setPurchased(purchased);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setShowing(showing);
        this.setPurchaseDate(purchaseDate);
        this.setTicketNum(ticketNum);

    }

    /**
     *
     * @return reservation String representation of the reservation.
     *
     */
    @Override
    public String toString() {
        String receipt = "Ticket #: " + getTicketNum() + "\nReserved for: " + getLastName() + ", " + getFirstName()
                + "\nSeat #: " + getSeatNumber() + "\nShow Time: " + getShowing();

        System.out.println(receipt);

        return receipt;
    }

    /**
     *
     * Getters and Setters for Seat variables
     *
     */
    boolean isReserved() {
        return isPurchased();
    }



    /**
     * @return the purchased
     */
    public boolean isPurchased() {
        return purchased;
    }

    /**
     * @param purchased the purchased to set
     */
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }

    /**
     * @return the seatNumber
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the ticketNum
     */
    public int getTicketNum() {
        return ticketNum;
    }

    /**
     * @param ticketNum the ticketNum to set
     */
    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the showing
     */
    public String getShowing() {
        return showing;
    }

    /**
     * @param showTime the showing to set
     */
    public void setShowing(String showing) {
        this.showing = showing;
    }

    /**
     * @return the purchaseDate
     */
    public String getPurchaseDate() {
        return purchaseDate;
    }

    /**
     * @param purchaseDate the purchaseDate to set
     */
    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    /**
     * @return the dateFormat
     */
    public DateFormat getDateFormat() {
        return dateFormat;
    }

    /**
     * @param dateFormat the dateFormat to set
     */
    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    /**
     * @return the ticketCost
     */
}
