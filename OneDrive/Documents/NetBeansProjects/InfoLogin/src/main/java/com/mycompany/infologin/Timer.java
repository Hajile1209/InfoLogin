/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infologin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Timer {
    JFrame frame;
    JPanel panel;
    JLabel lblLoad, lblFail;
    JProgressBar Load;
    
    Timer(){
         frame = new JFrame();
         //frame.setTitle("LOG IN");
         frame.setSize(600, 400);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setLocationRelativeTo(null);
         frame.setLayout(null);
         
         panel = new JPanel();
         panel.setBounds(0, 0, 600, 400);
         panel.setBackground(new Color(51, 153, 255));
         panel.setLayout(null);
         
         lblFail = new JLabel("MULTIPLE FAILED ATTEMPTS");
         lblFail.setBounds(120, 90, 600, 30);
         lblFail.setFont(new Font("Arial", Font.BOLD, 28));
         lblFail.setForeground((Color.WHITE));
         
         lblLoad = new JLabel("WAIT FOR A SECOND..");
         lblLoad.setBounds(160, 230, 600, 30);
         lblLoad.setFont(new Font("Arial", Font.BOLD, 28));
         lblLoad.setForeground((Color.WHITE));
         
         Load = new JProgressBar();
         Load.setValue(0);
         Load.setStringPainted(true);
         Load.setBounds(120,150,350,30);
         Load.setBackground(new Color(245,237,207));
         Load.setForeground((Color.GREEN));
         Load.setFont(new Font("Arial",Font.PLAIN,0));
         

         panel.add(lblFail);
         panel.add(lblLoad);
         panel.add(Load);
         frame.add(panel);
         frame.setVisible(true);
         
         new SwingWorker<Void, Void>() {
            @Override
            public Void doInBackground() throws Exception {
                fill();
                return null;
            }

            @Override
            public void done() {
                frame.dispose(); 
                JOptionPane.showMessageDialog(null, "Please be careful", "Be Careful", JOptionPane.WARNING_MESSAGE);
            }
        }.execute();
    }
    private void fill() {
        int i = 0;
        try {
            while (i < 100) {
                Load.setValue(i + 6);
                Thread.sleep(250);
                i += 1;
            }
        } 
        catch (Exception e) {
        }

    }

    
}