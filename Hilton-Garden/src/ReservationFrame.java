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

 class ReservationFrame extends JFrame implements ActionListener {

     Hotel hotel;
     JPanel form;
    JButton make,view,status, close;
    JLabel title, copyright;

     ReservationFrame() {
        super("The title");
         Container console = getContentPane();
         setLayout(new GridLayout(0, 1, 5, 5));


        hotel = new Hotel(30); // Hotel with 30 rooms
        make = new JButton("Make New Reservation");
        view = new JButton("View Current Reservation");
        status = new JButton("Hotel Current Status");
        close = new JButton("Exit");

        title = new JLabel("Hilton Garden Inn at Greensboro Reservation System", SwingConstants.CENTER);
        copyright = new JLabel("Copyright (c) 2016 Brandon " +
                "Long & Aaren Avery | All rights reserved.", SwingConstants.CENTER);
        title.setFont((new Font("TimesRoman", Font.PLAIN, 25)));
        copyright.setFont((new Font("TimesRoman", Font.PLAIN, 10)));

        add(title);
        add(make);
        add(view);
        add(status);
        add(copyright);
        make.addActionListener(this);
        view.addActionListener(this);
        status.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == make) {

            ReserveFrame reserveFrame = new ReserveFrame(getHotel(), this);
            reserveFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            reserveFrame.setVisible(true);
            reserveFrame.setResizable(true);
            reserveFrame.setSize(800, 300);
            reserveFrame.setLocation(300,300);

        } else if (e.getSource() == view) {

            ViewFrame viewFrame = new ViewFrame(getHotel());
            viewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewFrame.setVisible(true);
            viewFrame.setResizable(true);
            viewFrame.setSize(800, 300);
            viewFrame.setLocation(300,300);

        } else if (e.getSource() == status) {


            JTextArea textArea = new JTextArea(hotel.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 300, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane);



        } else if (e.getSource() == close) {

        }

    }

     public Hotel getHotel() {
         return hotel;
     }

     public void setHotel(Hotel hotel) {
         this.hotel = hotel;
     }
 }
