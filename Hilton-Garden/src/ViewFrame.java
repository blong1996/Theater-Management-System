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


public class ViewFrame extends JFrame implements ActionListener {
    
    Hotel hotel;
    JTextField fNameField,lNameField, resNumField;
    JButton search, cancel;
    JTextArea detailsArea;
    JPanel detailsPanel, prompt;

    public ViewFrame(Hotel hotel) {
        super("Reserve Room");
        this.hotel = hotel;
        Container console = getContentPane();
        setLayout(new BoxLayout(console, BoxLayout.Y_AXIS));
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(0, 1, 5, 5));
        prompt = new JPanel();
        prompt.setLayout(new GridLayout(0,1,5,5));
        JLabel fNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
        JLabel lNameLabel = new JLabel("Last Name:", SwingConstants.RIGHT);
        JLabel resNumLabel = new JLabel("Reservation Number:", SwingConstants.RIGHT);
        JLabel detailsLabel = new JLabel("Reservation Details:", SwingConstants.RIGHT);
        JLabel directions = new JLabel("Enter your First and Last Name or your \n" +
                "Reservation Number to view your reservation details.");
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
        detailsPanel.add(detailsLabel);
        detailsPanel.add(detailsArea);
        
        form.add(fNameLabel);
        form.add(fNameField);
        form.add(lNameLabel);
        form.add(lNameField);
        form.add(resNumLabel);
        form.add(resNumField);
        form.add(search);
        form.add(cancel);
        add(directions);
        add(form);
        add(detailsPanel);

        search.addActionListener(this);
        
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
            this.dispose();
        }
    }

    public static boolean isNumeric(String str)
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
