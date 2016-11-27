
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Brandon Long, Aaren Avery File: ReservationFrame.java Project:
 * Hilton-Garden Date: Oct-Nov 2016 Class: COMP260 Programming Languages, Dr. Yu
 * Assignment: Project 2 File Description:
 *
 * This JFrame is the main User Interface. The other frames are created once
 * their respective button is clicked.
 *
 */
class ReservationFrame extends JFrame implements ActionListener {

    private Theater theater, theater2;
    private JButton make, view, status, close;

    ReservationFrame() {
        super("The title");
        Container console = getContentPane();
        console.setLayout(new GridLayout(0, 1, 5, 5));
        console.setBackground(new Color(65, 11, 20));

        // create Theater with 50 seats
        theater = new Theater(50);

        for (Seat seat : theater.getTheater()) {
            seat.setShowing("Louder Than Bombs - @10:00AM, Nov 15");
        }

        theater2 = new Theater(50);

        for (Seat a : theater2.getTheater()) {
            a.setShowing("Louder Than Bombs - @08:00AM, Nov 15");
        }
        make = new JButton("View Show Times");
        view = new JButton("Return Ticket");
//        status = new JButton("Theater Current Status");
        close = new JButton("Exit");

        JLabel title = new JLabel("Theater-Managerment-System", SwingConstants.CENTER);
        title.setFont((new Font("TimesRoman", Font.PLAIN, 30)));
        JLabel copyright = new JLabel("Copyright (c) 2016 Brandon "
                + "Long & Aaren Avery | All rights reserved.", SwingConstants.CENTER);
        copyright.setFont((new Font("TimesRoman", Font.PLAIN, 15)));
        title.setForeground(Color.WHITE);
        copyright.setForeground(Color.WHITE);

        // add components to JFrame
        add(title);
        add(make);
        add(view);
        add(close);
        add(copyright);

        // add actionListeners to buttons
        make.addActionListener(this);
        view.addActionListener(this);
//        status.addActionListener(this);
        close.addActionListener(this);

    }

    /**
     *
     * This method adds the actions for each of the buttons
     *
     * @param e ActionEvent opject
     */
    public void actionPerformed(ActionEvent e) {

        // allow usr to make new reservation
        if (e.getSource() == make) {

            ReserveFrame reserveFrame = new ReserveFrame(theater, theater2, this);
            reserveFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            reserveFrame.setVisible(true);
            reserveFrame.setResizable(false);
            reserveFrame.getContentPane().setBackground(new Color(65, 11, 20));
            reserveFrame.setSize(800, 300);
            reserveFrame.setLocation(300, 300);
            disableButtons();

            // allow user to view their reservation
        } else if (e.getSource() == view) {

            ViewFrame viewFrame = new ViewFrame(theater, theater2, this);
            viewFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            viewFrame.setVisible(true);
            viewFrame.setResizable(false);
            viewFrame.setSize(800, 450);
            disableButtons();
            viewFrame.setLocation(200, 200);

            // get current status of hotel
        } //        else if (e.getSource() == status) {
        //
        //            JTextArea textArea = new JTextArea(theater.toString());
        //            JScrollPane scrollPane = new JScrollPane(textArea);
        //            textArea.setLineWrap(true);
        //            textArea.setWrapStyleWord(true);
        //            scrollPane.setPreferredSize(new Dimension(375, 500));
        //            JOptionPane.showMessageDialog(null, scrollPane, "Hotel Status", 1);
        //
        //            // terminate program
        //        } 
        else if (e.getSource() == close) {

            Object[] options = {"Yes",
                "No"};
            int n = JOptionPane.showOptionDialog(null,
                    "Are you sure you want to close this application? \n"
                    + "All theater data will be lost.",
                    "Close Application",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            if (n != 1) {
                System.exit(0);
            }
        }

    }

    /**
     *
     * Getter & Setter for the Hotel object
     *
     */
    private Theater getTheater() {
        return theater;
    }

    private Theater getTheater2() {
        return theater2;
    }

    void setTheater(Theater theater) {
        this.theater = theater;
    }

    private void disableButtons() {
        make.setEnabled(false);
        view.setEnabled(false);
    }

    void enableButtons() {
        make.setEnabled(true);
        view.setEnabled(true);
    }
}
