package com.mycompany.infologin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginPage implements ActionListener {
    
    private JFrame framel = new JFrame();
    private JLabel lblWelcome, lblTo, lblLogin, lblUser, lblPass, lblDont;
    private JButton btnLogin, btnSign;
    private JTextField tfUser;
    private JPasswordField tfPass;
    private JPanel pnlRed, pnlYellow;
    
    private static final String dbURL = "jdbc:mysql://localhost:3306/login";
    private static final String dbUser = "root";
    private static final String dbPass = "sqllewol123";
    
    private int attempts = 0;
    
    LoginPage(){
        Buttons();
        Textfields();
        Labels();
        Panels();
        
        framel.setTitle("Login");
        framel.setSize(1150, 750);
        framel.setLayout(null);
        framel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framel.setLocationRelativeTo(null);
        framel.setVisible(true);
         
    }
    
    public void Labels(){
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setBounds(120, 35, 280, 80);
        lblWelcome.setForeground(new Color(255,255,255));
        lblWelcome.setFont(new Font("Aptos Display (Headings)", Font.BOLD, 40));
        framel.add(lblWelcome);
        
        lblTo = new JLabel("TO MYSQL");
        lblTo.setBounds(120, 105, 280, 90);
        lblTo.setForeground(new Color(255,255,255));
        lblTo.setFont(new Font("Aptos Display (Headings)", Font.BOLD, 40));
        framel.add(lblTo);
        
        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(560, 45, 200, 100);
        lblLogin.setForeground(Color.BLACK);
        lblLogin.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 50));
        framel.add(lblLogin);
        
        lblUser = new JLabel("USERNAME:");
        lblUser.setBounds(565, 185, 200, 60);
        lblUser.setForeground(Color.BLACK);
        lblUser.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framel.add(lblUser);
        
        lblPass = new JLabel("PASSWORD:");
        lblPass.setBounds(565, 237, 200, 60);
        lblPass.setForeground(Color.BLACK);
        lblPass.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 22));
        framel.add(lblPass);
        
        lblDont = new JLabel("You don't have an account?");
        lblDont.setBounds(50, 500, 350, 70);
        lblDont.setForeground(new Color(255,255,255));
        lblDont.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 16));
        framel.add(lblDont);
        
    }
    
    public void Buttons(){
        btnLogin = new JButton("Login");
        btnLogin.setBounds(860, 310, 80, 40);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(new Color(255,255,255));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("impact", Font.PLAIN, 14));
        btnLogin.addActionListener(this);
        framel.add(btnLogin);
        
        
        btnSign = new JButton("Sign Up");
        btnSign.setBounds(275, 520, 82, 30);
        btnSign.setBorderPainted(false);
        btnSign.setBackground(new Color(255,255,255));
        btnSign.setForeground(Color.BLACK);
        btnSign.setFont(new Font("impact", Font.PLAIN, 14));
        btnSign.addActionListener(this);
        framel.add(btnSign);
        
    }
    
    public void Textfields(){
        tfUser = new JTextField("");
        tfUser.setBounds(720, 198, 225, 35);
        tfUser.setBackground(new Color(255,255,255));
        tfUser.setBorder(null);
        tfUser.setForeground(Color.BLACK);
        tfUser.setBorder(new EmptyBorder(5, 10, 5, 10));
        
        framel.add(tfUser);
        
        tfPass = new JPasswordField("");
        tfPass.setBounds(720, 250, 225, 35);
        tfPass.setBackground(Color.WHITE);
        tfPass.setBorder(null);
        tfPass.setForeground(Color.BLACK);
        tfPass.setBorder(new EmptyBorder(5, 10, 5, 10));
        
        framel.add(tfPass);
    }
    
    public void Panels(){
        pnlRed = new JPanel();
        pnlRed.setBounds(0, 0, 450, 750);
        pnlRed.setBackground(new Color(128, 0, 0));
        framel.add(pnlRed);
        
        pnlYellow = new JPanel();
        pnlYellow.setBounds(450, 0, 750, 750);
        pnlYellow.setBackground(new Color(255, 218, 88));
        framel.add(pnlYellow);
          
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == btnSign){
            framel.dispose();
            LoadingRegister rp = new LoadingRegister();
            
        }
        else if(e.getSource() == btnLogin){
            String Username = tfUser.getText();
            String Password = tfPass.getText();
        
            try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            String sqlcommand =("SELECT * FROM users WHERE Username = ? AND Pass_word = ?");
            PreparedStatement pst = connection.prepareStatement(sqlcommand);
            pst.setString(1, Username);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                attempts = 0;
                JOptionPane.showMessageDialog(null, "Successfully Login", "Message", JOptionPane.INFORMATION_MESSAGE);
                LoadingView vp = new LoadingView();
                framel.dispose();
            }
            else{
                attempts++;
                if(attempts >=3){
                    new Timer();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Wrong Credentials", "Warning", JOptionPane.ERROR_MESSAGE);
                }
            }
            }catch(Exception c){
                c.printStackTrace();
            }
            
        }
        
    }
    
    
}
