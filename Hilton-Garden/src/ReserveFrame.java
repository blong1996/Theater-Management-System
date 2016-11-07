import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: ReserveFrame.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This JFrame will allow the user to make a new reservation.
 *
 */


class ReserveFrame extends JFrame  implements ActionListener {
    private Hotel hotel;
    private ReservationFrame reservationFrame;
    private JTextField fNameField, lNameField, checkInField, checkOutField;
    private JButton submit, cancel;
    private JRadioButton safeYes, safeNo;
    private JComboBox<String> roomTypeOption;


    ReserveFrame (Hotel hotel, ReservationFrame reservationFrame) {
        super("Reserve Room");
        this.hotel = hotel;
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
        JLabel roomTypeLabel = new JLabel("Room Type:", SwingConstants.RIGHT);
        JLabel safeLabel = new JLabel("Would you like to include a Safe?:",
                SwingConstants.RIGHT);
        JLabel checkInLabel = new JLabel("Check In Date (Required Format - " +
                "YYYY-MM-DD):", SwingConstants.RIGHT);
        JLabel checkOutLabel = new JLabel("Check Out Date (Required Format - " +
                "YYYY-MM-DD):", SwingConstants.RIGHT);

        submit = new JButton("Reserve");
        cancel = new JButton("Cancel");
        fNameField = new JTextField("");
        fNameField.setSize(50,20);
        lNameField = new JTextField("");
        lNameField.setSize(50,20);
        checkInField = new JTextField("");
        checkInField.setSize(50,20);
        checkOutField = new JTextField("");
        checkOutField.setSize(50,20);
        fNameLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);
        roomTypeLabel.setForeground(Color.WHITE);
        safeLabel.setForeground(Color.WHITE);
        checkInLabel.setForeground(Color.WHITE);
        checkOutLabel.setForeground(Color.WHITE);

        ButtonGroup safeGroup = new ButtonGroup();
        safeYes = new JRadioButton("Yes");
        safeNo = new JRadioButton("No");
        safeYes.setForeground(Color.WHITE);
        safeNo.setForeground(Color.WHITE);
        buttons.add(safeYes);
        buttons.add(safeNo);

        String [] options = {"Standard - $120/night", "Deluxe - $140/night", "Junior Suite - $180/night"};
        roomTypeOption = new JComboBox<>(options);

        safeNo.setSelected(true);
        safeGroup.add(safeYes);
        safeGroup.add(safeNo);
            // add components to JFrame
        form.add(fNameLabel);
        form.add(fNameField);
        form.add(lNameLabel);
        form.add(lNameField);
        form.add(roomTypeLabel);
        form.add(roomTypeOption);
        form.add(safeLabel);
        form.add(buttons);
        form.add(checkInLabel);
        form.add(checkInField);
        form.add(checkOutLabel);
        form.add(checkOutField);
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
     *  This method adds the actions for each of the buttons
     *
     * @param e ActionEvent opject
     */


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String firstName = fNameField.getText(),
                    lastName = lNameField.getText(),
                    roomType = roomTypeOption.getSelectedItem().toString(),
                    checkIn = checkInField.getText(),
                    checkOut = checkOutField.getText();

            boolean safe = safeYes.isSelected();

            roomType = roomType.substring(0, roomType.length()-13);
            int roomNumber = hotel.reserve(firstName, lastName, roomType, safe, checkIn, checkOut);
           // JOptionPane.showMessageDialog(null, hotel.getRoomChoiceAlert());


            int n;
                // allow user to input a new reservation or to attempt to enter
                // a reservation again if there was an error.
            if (roomNumber != -1) {
                Object[] options = {"Make a new reservation",
                    "Close"};
                n = JOptionPane.showOptionDialog(null,
                        hotel.getRoomChoiceAlert(),
                        "Reservation Status",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
            } else {
                Object[] options = {"Try Again",
                        "Cancel"};
                n = JOptionPane.showOptionDialog(null,
                        hotel.getRoomChoiceAlert(),
                        "Reservation Error",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, options, options[0]);
            }

            if (n == 1) {
                reservationFrame.setHotel(getHotel());
                reservationFrame.enableButtons();
                this.dispose();
            } else if (n == 0 && roomNumber !=-1) {
                fNameField.setText("");
                lNameField.setText("");
                roomTypeOption.setSelectedIndex(0);
                checkInField.setText("");
                checkOutField.setText("");
                safeNo.setSelected(true);

            }
        }
        else if (e.getSource() == cancel) {
            reservationFrame.setHotel(getHotel());
            reservationFrame.enableButtons();
            this.dispose();
        }
    }

    /**
     *
     * Getter and Setter for hotel
     *
     */
    private Hotel getHotel() {
        return hotel;
    }

    private void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}

