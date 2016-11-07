import javax.swing.*;

/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Main.java
 *  Project: Hilton-Garden
 *  Date: Oct-Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 2
 *
 *  Objective:
 *
 *  An object-oriented programming language supports abstraction, encapsulation, inheritance
 *  and polymorphism. Inheritance is a means for incrementally building new types from an existing
 *  parent type by inheriting, modifying, or adding to both the existing components and operations of
 *  the parent type. Inheritance greatly supports reuse in the software development process. Graphical
 *  User Interfaces (GUI) is another technique that provides a friendly environment for users. Students
 *  will practice these techniques in this project.
 *
 *  Project Assignment:
 *
 *  Design and implement a Hilton Garden Inn Reservation System for the Hilton in Greensboro.
 *  Hilton Garden Inn has three types of rooms. One is stand room that has one queen bed. Another
 *  is deluxe room that has one queen bed and one twin bed. The third type is a Junior suit that
 *  has one queen bed and two sofas. A safe costs $20. The stand room price is $120 per night.
 *  The deluxe room price is $140 per night. The suit price is $180 per night. Hilton Garden Inn
 *  has 30 rooms. This system should allow an agent to input a customer name, selected room type,
 *  using the safe box or not as well as arrival and departure dates. It should also provide the
 *  capability to calculate the total charge and display it on the screen. The Hilton Garden Inn
 *  Reservation System must satisfy the following requirements:
 *
 *  1)  A Graphic User Interface should be developed to allow an agent to input required information.
 *  2)  A constructor sets the number of rooms.
 *  3)  A person reserves a room via reserve method. This method returns an integer indicating the
 *      room number. If a customer tries to reserve a room but the rooms are sold out an error message
 *      should be displayed.
 *  4)	If a customer reserved a room the person’s name, arrival date, departure date, room number and
 *      total charge should be displayed.
 *  5)	Single inheritance must be used to demonstrate the concept of inheritance.
 *
 *  Requirements:
 *
 *  a)  This is a two-person team project.
 *  b)  The team should use department programming standard.
 *  c)  The program must execute correctly.
 *  d)  Email your program to Robert Dawkins Redawkin@aggies.ncat.edu.
 *
 *
 */

public class Main {
    public static void main(String[] args) {
        ReservationFrame frame = new ReservationFrame();
        frame.setTitle("Hilton Garden Inn at GSO Reservations | Copyright (c) 2016 Brandon " +
                "Long & Aaren Avery | All rights reserved.");
        frame.setSize(800, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}

