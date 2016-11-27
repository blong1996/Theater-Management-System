/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.WindowConstants;

/**
 *
 * @author Aaren
 */
public class TheatreManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReservationFrame frame = new ReservationFrame();

        frame.setTitle("Theater-Management-System | Copyright (c) 2016 Brandon "
                + "Long & Aaren Avery | All rights reserved.");
        frame.setSize(800, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
