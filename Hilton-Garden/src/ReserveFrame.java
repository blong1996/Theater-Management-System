import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: ReservveFrame.java
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
    public Hotel hotel;
    public ReservationFrame reservationFrame;
    JPanel form, buttons, buttons2;
    JLabel fNameLabel, lNameLabel, roomTypeLabel, safeLabel, checkInLabel, checkOutLabel;
    JTextField fNameField, lNameField, checkInField, checkOutField;
    JButton submit, cancel;
    JRadioButton safeYes, safeNo;
    JComboBox<String> roomTypeOption;
    ButtonGroup  safeGroup;



    ReserveFrame (Hotel hotel, ReservationFrame reservationFrame) {
        super("Reserve Room");
        this.hotel = hotel;
        this.reservationFrame = reservationFrame;
        Container console = getContentPane();
        console.setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));
        form.setBackground(new Color(65, 11, 20));
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(0, 2, 5, 5));
        buttons2 = new JPanel();
        buttons.setBackground(new Color(65, 11, 20));
        buttons2.setBackground(new Color(65, 11, 20));
        buttons2.setLayout(new GridLayout(0, 2, 5, 5));
        fNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        lNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        roomTypeLabel = new JLabel("Room Type:", SwingConstants.RIGHT);
        safeLabel = new JLabel("Would you like to include a Safe?:",
                SwingConstants.RIGHT);
        checkInLabel = new JLabel("Check In Date (Required Format - " +
                "YYYY-MM-DD):", SwingConstants.RIGHT);
        checkOutLabel = new JLabel("Check Out Date (Required Format - " +
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

        safeGroup = new ButtonGroup();
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

        submit.addActionListener(this);
        cancel.addActionListener(this);


    }

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

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}

