/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infologin;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoadingView {
    JFrame frame;
    JPanel panel;
    JLabel lblLoad;
    JProgressBar Load;
    
    LoadingView(){
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
         
         lblLoad = new JLabel("LOADING ...");
         lblLoad.setBounds(220, 230, 350, 30);
         lblLoad.setFont(new Font("Arial", Font.BOLD, 28));
         lblLoad.setForeground((Color.WHITE));
         
         Load = new JProgressBar();
         Load.setValue(0);
         Load.setStringPainted(true);
         Load.setBounds(110,150,350,30);
         Load.setBackground(new Color(245,237,207));
         Load.setForeground((Color.GREEN));
         Load.setFont(new Font("Arial",Font.PLAIN,0));
         

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
                ViewPage hp = new ViewPage();
                
            }
        }.execute();
    }
    private void fill() {
        int i = 0;
        try {while (i < 100) {
            
            Load.setValue(i + 3);
            
            Thread.sleep(70);
            
            i += 1;
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
     }
}

    
}
