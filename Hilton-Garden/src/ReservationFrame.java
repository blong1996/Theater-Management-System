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

     private Hotel hotel;
    private JButton make,view,status, close;

     ReservationFrame() {
        super("The title");
         Container console = getContentPane();
         console.setLayout(new GridLayout(0, 1, 5, 5));
         console.setBackground(new Color(65, 11, 20));

         // create Hotel with 30 rooms
        hotel = new Hotel(30);
        make = new JButton("Make New Reservation");
        view = new JButton("View Current Reservation");
        status = new JButton("Hotel Current Status");
        close = new JButton("Exit");

         JLabel title = new JLabel("Hilton Garden Inn at Greensboro Reservation System", SwingConstants.CENTER);
         title.setFont((new Font("TimesRoman", Font.PLAIN, 30)));
         JLabel copyright = new JLabel("Copyright (c) 2016 Brandon " +
                 "Long & Aaren Avery | All rights reserved.", SwingConstants.CENTER);
            copyright.setFont((new Font("TimesRoman", Font.PLAIN, 15)));
         title.setForeground(Color.WHITE);
         copyright.setForeground(Color.WHITE);

         // add components to JFrame
        add(title);
        add(make);
        add(view);
        add(status);
        add(copyright);

         // add actionListeners to buttons
        make.addActionListener(this);
        view.addActionListener(this);
        status.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

            // allow usr to make new reservation
        if (e.getSource() == make) {

            ReserveFrame reserveFrame = new ReserveFrame(getHotel(), this);
            reserveFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            reserveFrame.setVisible(true);
            reserveFrame.setResizable(false);
            reserveFrame.getContentPane().setBackground(new Color(65, 11, 20));
            reserveFrame.setSize(800, 300);
            reserveFrame.setLocation(300,300);
            disableButtons();

            // allow user to view their reservation
        } else if (e.getSource() == view) {

            ViewFrame viewFrame = new ViewFrame(getHotel(), this);
            viewFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            viewFrame.setVisible(true);
            viewFrame.setResizable(false);
            viewFrame.setSize(800, 450);
            disableButtons();
            viewFrame.setLocation(200,200);

            // get current status of hotel
        } else if (e.getSource() == status) {

            JTextArea textArea = new JTextArea(hotel.toString());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            scrollPane.setPreferredSize( new Dimension( 350, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane);


            // terminate program
        } else if (e.getSource() == close) {


        }

    }

     /**
      *
      *  Getter & Setter for the Hotel object
      *
      */
     public Hotel getHotel() {
         return hotel;
     }

     public void setHotel(Hotel hotel) {
         this.hotel = hotel;
     }

     public void disableButtons() {
         make.setEnabled(false);
         view.setEnabled(false);
         status.setEnabled(false);
     }
     public void enableButtons() {
         make.setEnabled(true);
         view.setEnabled(true);
         status.setEnabled(true);
     }
 }
