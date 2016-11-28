/**
 *
 *  @author Brandon Long, Aaren Avery
 *  File: Main.java
 *  Project: Theator-Management System
 *  Date: Nov 2016
 *  Class: COMP260 Programming Languages, Dr. Yu
 *  Assignment: Project 3
 *  File Description:
 *
 *  This class is used to allow a user to simulate purchasing and returning movie tickets
 *  at a fictional theater with two movie showings. In the event that their desired seat
 *  is not available or the theater room is sold out, the "TicketSoldOutExcpetion" will be
 *  thrown and an error message will be displayed.
 *
 */


import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception{

          //  Create movie objects
        Scanner keyboard = new Scanner(System.in);
        Movie movieEight = new Movie(50, "8:00PM", "November 15, 2015");
        Movie movieTen = new Movie(50, "10:00AM", "November 15, 2015");
        String i = "1";
        System.out.println("Thank you for visiting the Greensboro Theater!\n\nBrought to you by Brandon Long and Aaren Avery" +
                "\n\nWe currently have two showings available for \"Louder Than Bombs\" on November 15th.");
        while(i.equalsIgnoreCase("1")){
                // prompt user to select movie time

            System.out.println("\nIf you would like to watch the 10:00AM show, enter '10'.\nIf you would like to watch the 8:00 PM show, enter '8'.\n\n");

            int time = keyboard.nextInt();

            while(time != 8 && time != 10){  // keeps prompting if it is not 8 or 10

                System.out.println("Please enter either '8' or '10'");
                time = keyboard.nextInt();

            }
                // Attempt to purchase a ticket if the customer's seat of choice is available or if the theater is not full

                // movie choice at 8:00
            if(time == 8){
                movieEight.SeatMap();
                System.out.println("Select a seat: \n");
                int ticket = keyboard.nextInt();

                while(ticket < 0 || ticket > movieEight.getSeats()-1) {
                    System.out.println("Please enter a seat number between 0 and "+ (movieEight.getSeats()-1)+" \n");
                    ticket = keyboard.nextInt();
                }

                try{
                    movieEight.PurchaseTicket(ticket);
                }catch(TicketSoldOutException ex) {
                    System.out.println(ex.getMessage());
                }
                // movie choice at 10:00
            } else {
                movieTen.SeatMap();
                System.out.println("Select a seat: \n");
                int ticket = keyboard.nextInt();

                while(ticket < 0 || ticket > movieTen.getSeats()-1) {
                    System.out.println("Please enter a seat number between 0 and "+ (movieTen.getSeats()-1)+"\n");
                    ticket = keyboard.nextInt();
                }

                try{
                    movieTen.PurchaseTicket(ticket);
                }catch(TicketSoldOutException ex) {
                    System.out.println(ex.getMessage());
                }

            }


            // Allow customer to return a ticket if they choose
            System.out.println("\nEnter \"R\" to return a ticket\n(Any other character will skip returns)\n\n");

            String ret = keyboard.next();

            if (ret.equalsIgnoreCase("R")) {
                System.out.println("Select movie time; enter '8' or '10'.\n\n");

                time = keyboard.nextInt();
                while(time != 8 && time != 10){  // keeps prompting if it is not 8 or 10

                    System.out.println("Please enter either '8' or '10'");
                    time = keyboard.nextInt();

                }
                if (time == 8) {
                    System.out.println("Enter seat Number: \n");
                    int ticket = keyboard.nextInt();

                    while (ticket < 0 || ticket > movieEight.getSeats() - 1) {
                        System.out.println("Please enter a seat number between 0 and " + (movieEight.getSeats() - 1) + "\n");
                        ticket = keyboard.nextInt();
                    }
                    movieEight.ReturnTicket(ticket);
                } else {
                    System.out.println("Enter seat Number: \n");
                    int ticket = keyboard.nextInt();

                    while (ticket < 0 || ticket > movieTen.getSeats() - 1) {
                        System.out.println("Please enter a seat number between 0 and " + (movieTen.getSeats() - 1) + "\n");
                        ticket = keyboard.nextInt();
                    }
                    movieTen.ReturnTicket(ticket);
                }
            }

            // Allow customer to purchase another ticket

            System.out.println("\nIf you would like to get another ticket, please enter  '1'. \n\n" +
                    "If not, enter any other character to exit\n");
            i = keyboard.next();
        }

        System.out.println("\n\n HAVE A GREAT DAY!!\n\n");

    }
}
