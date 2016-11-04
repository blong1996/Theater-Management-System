import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Brandon Long
 *         File: ReserveWindow.java
 *         Project: Hilton-Garden
 *         Date: Nov
 *         Class:
 *         Assignment:
 *         File Description:
 */


public class ReserveWindow {
    private JLabel title;
    private JTextField fNameField;
    private JTextField lNameField;
    private JRadioButton safeYes;
    private JRadioButton safeNo;
    private JTextField checkInField;
    private JTextField checkOutField;
    private JButton reserveButton;
    private JButton cancelButton;
    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JLabel safeLabel;
    private JLabel checkInLabel;
    private JLabel checkOutLabel;
    private JPanel titlePanel;
    private JComboBox roomTypeCombo;
    private JLabel roomTypeLabel;

    public ReserveWindow() {
        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}
