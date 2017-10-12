/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.ca;

/**
 *
 * @author pujitha sriramaneni
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class WolfApp extends CAApp implements Runnable {

    private static Logger logger = Logger.getLogger(WolfApp.class.getName());

    protected JPanel northPanel = null;
    protected JButton startBtn = null;
    protected JButton stopBtn = null;
    private CACanvas caPanel = null;
    int ruleNum = 90;
    int genNum = 40;//default value when user doesnt enter no of gen

    String[] Rules = {"Rule 50", "Rule 90", "Rule 94", "Rule 126"};

    protected JLabel textLabel = null;

    /**
     * constructor
     */
    public WolfApp() {
        frame.setSize(1000, 1000);
        frame.setTitle("Cellular Automation");

        frame.setVisible(true); // Displaying the built UI
    }

    public JPanel getNorthPanel() {

        northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        textLabel = new JLabel("Rule");
        northPanel.add(textLabel);
        String labels[] = {"50", "90", "94", "126"};
        final JComboBox comboBox = new JComboBox(labels);
        final JTextField textField = new JTextField(10);
        comboBox.setMaximumRowCount(5);
        //comboBox.setEditable(true);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ruleNum = Integer.parseInt((String) comboBox.getSelectedItem());
            }
        });
        northPanel.add(comboBox);
        textLabel = new JLabel("Number of Generations");
        textField.addActionListener(this);
        northPanel.add(textLabel);
        northPanel.add(textField);
        startBtn = new JButton("Start");
        startBtn.addActionListener(this); // Allow the app to know that button action is performed

        northPanel.add(startBtn);
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Start pressed");
                // System.out.println(rule_num+"rule_num");
                if (!textField.getText().isEmpty()) {
                    genNum = Integer.parseInt((String) textField.getText());
                }

                if (genNum > 54) {
                    setWarningMsg("Please enter no of rows as less than 54 to " + ruleNum + "");
                }

                System.out.println(genNum + "Num of Generations given by user");

                caPanel = new CACanvas(ruleNum, genNum);
                /*JScrollPane scrollPane = new JScrollPane(caPanel);
                scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setBounds(50, 30, 500, 350);*/
                frame.add(caPanel, BorderLayout.CENTER); // Add to the center of the frame	

                frame.setVisible(true); // Displaying the built UI
            }
        });
        stopBtn = new JButton("Stop"); // Allow the app to know that button action is performed 										// pushes
        stopBtn.addActionListener(this);
        northPanel.add(stopBtn);
        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("stop pressed");
                frame.setVisible(true);
            }
        });

        return northPanel;
    }

    public static void setWarningMsg(String text) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane optionPane = new JOptionPane(text, JOptionPane.WARNING_MESSAGE);
        JDialog dialog = optionPane.createDialog("Warning!");
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        logger.info("An ActionEvent is received" + ae);
        if (ae.getSource() == startBtn) {

        } else if (ae.getSource() == stopBtn) {

        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        logger.info("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
        logger.info("Window iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        logger.info("Window deiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        logger.info("Window activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        logger.info("Window deactivated");
    }

    /**
     * Sample Wolf application starting point
     *
     * @param args
     */
    public static void main(String[] args) {
        WolfApp wlfApp = new WolfApp();
        logger.info("WolfApp started");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

    }
}
