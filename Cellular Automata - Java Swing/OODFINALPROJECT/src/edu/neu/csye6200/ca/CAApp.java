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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

public abstract class CAApp implements ActionListener, WindowListener {

    protected JFrame frame = null;

    public CAApp() {
        initGUI();
    }

    public void initGUI() {
        frame = new JFrame();
        frame.setTitle("JUIApp");
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Exists app on close
        frame.addWindowListener(this);
        frame.setLayout(new BorderLayout());
        frame.add(getNorthPanel(), BorderLayout.NORTH);

    }

    public abstract JPanel getNorthPanel();

}
