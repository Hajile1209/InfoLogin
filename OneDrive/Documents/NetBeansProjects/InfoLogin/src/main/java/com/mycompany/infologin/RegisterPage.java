/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infologin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.border.EmptyBorder;

public class RegisterPage implements ActionListener {
    private JFrame framer = new JFrame();
    private JLabel lblWelcome, lblTo, lblRegis, lblFN, lblMN, lblLN, lblEmail, lblCreateUser, lblCreatePass, lblDone;
    private JButton btnLogin, btnRegister;
    private JTextField tfFN, tfMN, tfLN, tfEmail, tfCreateUser, tfCreatePass;
    private JPanel pnlRed, pnlYellow;
    
    private static final String dbURL = "jdbc:mysql://localhost:3306/login";
    private static final String dbUser = "root";
    private static final String dbPass = "sqllewol123";
    
    RegisterPage(){
        Buttons();
        Labels();
        Textfields();
        Panels();
        
        
        framer.setTitle("Register Page");
        framer.setSize(1150, 750);
        framer.setLayout(null);
        framer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framer.setLocationRelativeTo(null);
        framer.setVisible(true);
                
        
    }
    
    public void Labels(){
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setBounds(120, 35, 280, 80);
        lblWelcome.setForeground(new Color(255,255,255));
        lblWelcome.setFont(new Font("Aptos Display (Headings)", Font.BOLD, 40));
        framer.add(lblWelcome);
        
        lblTo = new JLabel("TO MYSQL");
        lblTo.setBounds(120, 105, 280, 90);
        lblTo.setForeground(new Color(255,255,255));
        lblTo.setFont(new Font("Aptos Display (Headings)", Font.BOLD, 40));
        framer.add(lblTo);
        
        lblRegis = new JLabel("REGISTER");
        lblRegis.setBounds(580, 45, 300, 100);
        lblRegis.setForeground(Color.BLACK);
        lblRegis.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 45));
        framer.add(lblRegis);
        
        lblFN = new JLabel("FIRST NAME:");
        lblFN.setBounds(530, 155, 200, 60);
        lblFN.setForeground(Color.BLACK);
        lblFN.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblFN);
        
        lblMN = new JLabel("MIDDLE NAME:");
        lblMN.setBounds(530, 200, 200, 60);
        lblMN.setForeground(Color.BLACK);
        lblMN.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblMN);
        
        lblLN = new JLabel("LAST NAME:");
        lblLN.setBounds(530, 245, 200, 60);
        lblLN.setForeground(Color.BLACK);
        lblLN.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblLN);
        
        lblEmail = new JLabel("EMAIL ADDRESS:");
        lblEmail.setBounds(530, 290, 200, 60);
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblEmail);
        
        lblCreateUser = new JLabel("CREATE USERNAME:");
        lblCreateUser.setBounds(530, 335, 310, 60);
        lblCreateUser.setForeground(Color.BLACK);
        lblCreateUser.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblCreateUser);
        
        lblCreatePass = new JLabel("CREATE PASSWORD:");
        lblCreatePass.setBounds(530, 380, 240, 60);
        lblCreatePass.setForeground(Color.BLACK);
        lblCreatePass.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framer.add(lblCreatePass);
        
        lblDone = new JLabel("Done? Go to Login");
        lblDone.setBounds(100, 500, 320, 70);
        lblDone.setForeground(new Color(255,255,255));
        lblDone.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 16));
        framer.add(lblDone);
        
    }
    
    public void Textfields(){
        tfFN = new JTextField("");
        tfFN.setBounds(780, 173, 250, 32);
        tfFN.setBackground(Color.WHITE);
        tfFN.setBorder(null);
        tfFN.setForeground(Color.BLACK);
        tfFN.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfFN);
        
        tfMN = new JTextField("");
        tfMN.setBounds(780, 217, 250, 32);
        tfMN.setBackground(Color.WHITE);
        tfMN.setBorder(null);
        tfMN.setForeground(Color.BLACK);
        tfMN.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfMN);
        
        tfLN = new JTextField("");
        tfLN.setBounds(780, 262, 250, 32);
        tfLN.setBackground(Color.WHITE);
        tfLN.setBorder(null);
        tfLN.setForeground(Color.BLACK);
        tfLN.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfLN);
        
        tfEmail = new JTextField("");
        tfEmail.setBounds(780, 307, 250, 32);
        tfEmail.setBackground(Color.WHITE);
        tfEmail.setBorder(null);
        tfEmail.setForeground(Color.BLACK);
        tfEmail.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfEmail);
        
        tfCreateUser = new JTextField("");
        tfCreateUser.setBounds(780, 351, 250, 32);
        tfCreateUser.setBackground(Color.WHITE);
        tfCreateUser.setBorder(null);
        tfCreateUser.setForeground(Color.BLACK);
        tfCreateUser.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfCreateUser);
        
        tfCreatePass = new JTextField("");
        tfCreatePass.setBounds(780, 396, 250, 32);
        tfCreatePass.setBackground(Color.WHITE);
        tfCreatePass.setBorder(null);
        tfCreatePass.setForeground(Color.BLACK);
        tfCreatePass.setBorder(new EmptyBorder(5, 10, 5, 10));
        framer.add(tfCreatePass);
        
    }
    
    public void Buttons(){
        btnLogin = new JButton("Login");
        btnLogin.setBounds(255, 525, 92, 28);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(new Color(255,255,255));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("impact", Font.PLAIN, 14));
        btnLogin.addActionListener(this);
        framer.add(btnLogin);
        
        btnRegister = new JButton("Register");
        btnRegister.setBounds(930, 446, 92, 35);
        btnRegister.setBorderPainted(false);
        btnRegister.setBackground(new Color(255,255,255));
        btnRegister.setForeground(Color.BLACK);
        btnRegister.setFont(new Font("impact", Font.PLAIN, 14));
        btnRegister.addActionListener(this);
        framer.add(btnRegister);
    }
    
    
    public void Panels(){
        pnlRed = new JPanel();
        pnlRed.setBounds(0, 0, 450, 750);
        pnlRed.setBackground(new Color(128, 0, 0));
        framer.add(pnlRed);
        
        pnlYellow = new JPanel();
        pnlYellow.setBounds(450, 0, 750, 750);
        pnlYellow.setBackground(new Color(255, 218, 88));
        framer.add(pnlYellow);
        
    } 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String fname = tfFN.getText();
        String mname = tfMN.getText();
        String lname = tfLN.getText();
        String email = tfEmail.getText();
        String user = tfCreateUser.getText();
        String pass = tfCreatePass.getText();
        
        
        if(e.getSource() == btnLogin){
            framer.dispose();
            Loading lp = new Loading();
        }
        
        else if(e.getSource() == btnRegister){
        if(fname.isEmpty() || lname.isEmpty() || email.isEmpty() || user.isEmpty() || pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "You didn't fill up everything", "ERROR", JOptionPane.WARNING_MESSAGE);
                return;
            }
        try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            String sqlcommand ="INSERT INTO users VALUES('" +fname+"', '" +mname+"', '" +lname+"', '" +email+"', '" +user+"', '" +pass+"' )";
            Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            int x = st.executeUpdate(sqlcommand);

            if(x>0){
                new Load();
            }
            else{
                JOptionPane.showMessageDialog(null, "Something's Wrong", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }catch(Exception c){
        c.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Not Connected", "Database Not Connected", JOptionPane.ERROR_MESSAGE);
    }
        }
    }
}
