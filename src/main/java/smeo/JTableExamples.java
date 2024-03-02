package smeo;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class JTableExamples {
    // Frame
    JFrame mainFrame;

    // Components
    JLabel titleLabel;
    JTextField inputField1;
    JTextField inputField2;
    JTextField inputField3;
    JTextField inputField4;
    JTable mainTable;
    JButton button1;
    JButton button2;

    // Constructor
    JTableExamples() {
        FlatDarkLaf.install();

        // Frame initialization
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setTitle("Store Total");

        // Set layout manager to BoxLayout with Y_AXIS orientation
        mainFrame.setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));

        // Title at the top
        titleLabel = new JLabel("Store Total");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        mainFrame.add(titlePanel);

        // Inputs in the second row
        JPanel inputsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 5));
        inputField1 = new JTextField(5);
        inputField2 = new JTextField(5);
        inputField3 = new JTextField(5);
        inputField4 = new JTextField(5);
        JButton submitButton = new JButton("Submit");
        inputsPanel.add(inputField1);
        inputsPanel.add(inputField2);
        inputsPanel.add(inputField3);
        inputsPanel.add(inputField4);
        inputsPanel.add(submitButton);
        mainFrame.add(inputsPanel);

        // Initializing the JTable in the third row
        String[][] data = {
                {"1/1/2022", "100", "200", "300", "600"},
                {"1/2/2022", "200", "100", "400", "700"},
                {"1/3/2022", "150", "250", "350", "750"},
                {"1/4/2022", "180", "220", "320", "720"},
                {"1/5/2022", "120", "180", "280", "580"},
                {"1/6/2022", "250", "150", "450", "850"},
                {"1/7/2022", "300", "120", "320", "740"},
                {"1/8/2022", "170", "230", "330", "730"},
                {"1/9/2022", "220", "200", "400", "800"},
                {"1/10/2022", "130", "170", "270", "570"},
                {"1/11/2022", "240", "130", "430", "830"},
                {"1/12/2022", "160", "210", "310", "710"},
                {"1/13/2022", "190", "190", "290", "690"},
                {"1/14/2022", "270", "110", "410", "810"},
                {"1/15/2022", "140", "160", "260", "560"},
                {"1/16/2022", "200", "140", "320", "720"},
                {"1/17/2022", "230", "170", "370", "770"},
                {"1/18/2022", "280", "120", "420", "820"},
                {"1/19/2022", "150", "180", "280", "580"},
                {"1/20/2022", "190", "200", "300", "600"},
                {"1/21/2022", "210", "140", "240", "640"},
                {"1/22/2022", "220", "160", "260", "660"},
                {"1/23/2022", "180", "190", "290", "590"},
                {"1/24/2022", "200", "170", "270", "570"},
                {"1/25/2022", "250", "150", "350", "750"},
                {"1/26/2022", "160", "210", "310", "710"},
                {"1/27/2022", "190", "180", "280", "580"},
                {"1/28/2022", "220", "200", "300", "600"},
                {"1/29/2022", "250", "230", "330", "730"},
                {"1/30/2022", "180", "190", "290", "590"},
                {"1/31/2022", "200", "220", "320", "720"}


        };
        String[] columnNames = {"Date", "Card", "Online", "Cash", "Total"};
        JPanel tablePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

// Wrap the JTable in a JScrollPane
        mainTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(mainTable);

// Set preferred size to make sure the scroll bar appears when needed
        scrollPane.setPreferredSize(new Dimension(500, 500)); // Adjust dimensions as needed

        tablePanel.add(scrollPane);
        mainFrame.add(tablePanel);

        // Buttons in the fourth row
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        mainFrame.add(buttonPanel);

        // Frame Size
        mainFrame.setSize(800, 600);
        // Frame Visible = true
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

    // Driver method
    public static void main(String[] args) {
        new JTableExamples();
    }
}
