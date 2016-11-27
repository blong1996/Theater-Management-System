
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Brandon Long, Aaren Avery File: ReserveFrame.java Project:
 * Hilton-Garden Date: Oct-Nov 2016 Class: COMP260 Programming Languages, Dr. Yu
 * Assignment: Project 2 File Description:
 *
 * This JFrame will allow the user to make a new reservation.
 *
 */
class ReserveFrame extends JFrame implements ActionListener {

    private Theater theater, theater1, theater2;
    private ReservationFrame reservationFrame;
    private JTextField fNameField, lNameField, seating;
    private JButton submit, cancel;
    private JComboBox<String> roomTypeOption;
    private Date date = new Date();
    private int roomNumber;
    private ArrayList<Theater> cinema = new ArrayList<Theater>();

    ReserveFrame(Theater theater1, Theater theater2, ReservationFrame reservationFrame) {
        super("SHOWINGS");
        this.theater1 = theater1;
        this.theater2 = theater2;
        cinema.add(theater1);
        cinema.add(theater2);
        this.reservationFrame = reservationFrame;
        Container console = getContentPane();
        console.setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));
        form.setBackground(new Color(65, 11, 20));
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0, 2, 5, 5));
        JPanel buttons2 = new JPanel();
        buttons.setBackground(new Color(65, 11, 20));
        buttons2.setBackground(new Color(65, 11, 20));
        buttons2.setLayout(new GridLayout(0, 2, 5, 5));
        JLabel fNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        JLabel lNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        JLabel showings = new JLabel("Showings:", SwingConstants.RIGHT);
        JLabel seat = new JLabel("Indicate seat (1-50):", SwingConstants.RIGHT);

        submit = new JButton("Purchase");
        cancel = new JButton("Cancel");
        fNameField = new JTextField("");
        fNameField.setSize(50, 20);
        lNameField = new JTextField("");
        lNameField.setSize(50, 20);
        seating = new JTextField("");
        seating.setSize(50, 20);
        fNameLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);
        showings.setForeground(Color.WHITE);

        String[] options = {"Louder Than Bombs - @10:00AM, Nov 15", "Louder Than Bombs - @08:00PM, Nov 15"};
        roomTypeOption = new JComboBox<>(options);

        // add components to JFrame
        form.add(fNameLabel);
        form.add(fNameField);
        form.add(lNameLabel);
        form.add(lNameField);
        form.add(showings);
        form.add(roomTypeOption);
        form.add(seat);
        form.add(seating);
        form.add(buttons);
        buttons2.add(submit);
        buttons2.add(cancel);
        add(form);
        add(buttons2);

        // Add action listeners to buttons
        submit.addActionListener(this);
        cancel.addActionListener(this);

    }

    /**
     *
     * This method adds the actions for each of the buttons
     *
     * @param e ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String firstName = fNameField.getText(),
                    lastName = lNameField.getText(),
                    roomType = roomTypeOption.getSelectedItem().toString();
            int seat = Integer.parseInt(seating.getText());
            roomType = roomType.substring(0, roomType.length() - 13);
            switch (roomType) {
                case "Louder Than Bombs - @10:00AM, Nov 15":
                    roomNumber = cinema.get(0).purchaseTicket(firstName, lastName, seat, this.date, roomType);
                    this.theater = cinema.get(0);
                case "Louder Than Bombs - @08:00AM, Nov 15":
                    roomNumber = cinema.get(1).purchaseTicket(firstName, lastName, seat, this.date, roomType);
                    this.theater = cinema.get(1);
            }
        
            // JOptionPane.showMessageDialog(null, hotel.getRoomChoiceAlert());

            int n;
            // allow user to input a new reservation or to attempt to enter
            // a reservation again if there was an error.
            if (roomNumber != -1) {
                Object[] options = {"Purchase a new Ticket",
                    "Close"};
                n = JOptionPane.showOptionDialog(null,
                        theater.getRoomChoiceAlert(),
                        "Purchase Status",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
            } else {
                Object[] options = {"Try Again",
                    "Cancel"};
                n = JOptionPane.showOptionDialog(null,
                        theater.getRoomChoiceAlert(),
                        "Purchase Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
            }

            if (n == 1) {
                reservationFrame.setTheater(theater);
                reservationFrame.enableButtons();
                this.dispose();
            } else if (n == 0 && roomNumber != -1) {
                fNameField.setText("");
                lNameField.setText("");
                roomTypeOption.setSelectedIndex(0);

            }
        } else if (e.getSource() == cancel) {
            reservationFrame.setTheater(theater);
            reservationFrame.enableButtons();
            this.dispose();
        }
    }

    /**
     *
     * Getter and Setter for theater
     *
     */
    private Theater getTheater1() {
        return theater1;
    }

    private void setTheater(Theater theater) {
        this.theater1 = theater;
    }

    private Theater getTheater2() {
        return theater2;
    }

}
