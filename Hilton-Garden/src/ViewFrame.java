import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: ViewFrame.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *  This JFrame allows the user to search there reservation and view
 *  the details on it.
 *
 */


class ViewFrame extends JFrame implements ActionListener {
    
    private Hotel hotel;
    private JTextField fNameField,lNameField, resNumField;
    private JButton search, cancel;
    private JTextArea detailsArea;
    private ReservationFrame reservationFrame;

    ViewFrame(Hotel hotel, ReservationFrame reservationFrame) {
        super("View Reservation");
        this.hotel = hotel;
        this.reservationFrame = reservationFrame;
        Container console = getContentPane();
        setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(0, 2, 5, 5));

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));
        form.setBackground(new Color(65, 11, 20));
        JPanel prompt = new JPanel();
        prompt.setLayout(new GridLayout(0,1,5,5));
        prompt.setBackground(new Color(65, 11, 20));
        buttons.setBackground(new Color(65, 11, 20));
        JLabel fNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        JLabel lNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        JLabel resNumLabel = new JLabel("Reservation Number:", SwingConstants.RIGHT);
        JLabel directions = new JLabel("Enter your First and Last Name or your \n" +
                "Reservation Number to view your reservation details.", SwingConstants.CENTER);
        directions.setBackground(new Color(65, 11, 20));
        fNameLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);
        resNumLabel.setForeground(Color.WHITE);
        directions.setForeground(Color.WHITE);
        prompt.add(directions);
        search = new JButton("Search");
        cancel = new JButton("Cancel");
        fNameField = new JTextField("");
        fNameField.setSize(50,20);
        lNameField = new JTextField("");
        lNameField.setSize(50,20);
        resNumField = new JTextField("");
        resNumField.setSize(50, 20);
        detailsArea = new JTextArea("");
        detailsArea.setRows(5);
        buttons.add(search);
        buttons.add(cancel);

        form.setPreferredSize(new Dimension(800, 120));
        buttons.setPreferredSize(new Dimension(800,75));

            // add components to JFrame
        form.add(fNameLabel);
        form.add(fNameField);
        form.add(lNameLabel);
        form.add(lNameField);
        form.add(resNumLabel);
        form.add(resNumField);
        add(prompt);
        add(form);
        add(buttons);
        add(detailsArea);

            // add action listeners to buttons
        search.addActionListener(this);
        cancel.addActionListener(this);
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search) {

            int resNum = 0;

            if (isNumeric(resNumField.getText()))
                resNum = Integer.parseInt(resNumField.getText());

            String detailsString = hotel.findReservation(fNameField.getText(),
                    lNameField.getText(), resNum);
            detailsArea.setText(detailsString);

            cancel.setText("Close");
        }  else if (e.getSource() == cancel) {
            reservationFrame.enableButtons();
            this.dispose();
        }
    }

    private static boolean isNumeric(String str)
    {
        try
        {
            int d = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
