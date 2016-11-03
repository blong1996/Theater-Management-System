/**
 *  @author Brandon Long, Aaren Avery
 *  File: ReservationFrame.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *  File Description:
 *
 *
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReservationFrame extends JFrame implements ActionListener {

    public Hotel hotel;
    JButton make,view,status, close;
    JLabel title, copyright;
    public ReservationFrame() {
       setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        hotel = new Hotel(30); // Hotel with 30 rooms
        make = new JButton("Make New Reservation");
        view = new JButton("View Current Reservation");
        status = new JButton("Hotel Current Status");
        close = new JButton("Exit");

        title = new JLabel("Hilton Garden Inn at Greensboro Reservation System", JLabel.CENTER);
        copyright = new JLabel("Copyright (c) 2016 Brandon " +
                "Long & Aaren Avery | All rights reserved.", JLabel.CENTER);
        title.setFont((new Font("TimesRoman", Font.PLAIN, 40)));
        copyright.setFont((new Font("TimesRoman", Font.PLAIN, 10)));

        add(title);
        add(make);
        add(view);
        add(status);
        add(copyright);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == make) {

        } else if (e.getSource() == view) {

        } else if (e.getSource() == status) {

        } else if (e.getSource() == close) {

        }
    }
}
