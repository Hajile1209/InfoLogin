/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.infologin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class ViewPage implements ActionListener{
    private JFrame framev = new JFrame();
    private JLabel lblRecordView, lblSearch;
    private JButton btnAdd, btnLogin, btnAdmin, btnSearch, btnDelete;
    private JPanel pnlRed, pnlYellow;
    private DefaultTableModel tbl;
    private JTable tbRecord;
    private JScrollPane spRecord;
    private JTextField tfLName, tfFName;
    private JTextArea txtSearch;
    private TableColumn usernameColumn;
    private TableColumn passwordColumn;
    
    private static final String dbURL = "jdbc:mysql://localhost:3306/login";
    private static final String dbUser = "root";
    private static final String dbPass = "sqllewol123";
    
    private int attempts = 0;
    
    ViewPage(){
        Labels();
        Buttons();
        Table();
        Textfields();
        Textarea();
        Panels();
        
        framev.setSize(1280, 800);
        framev.setTitle("View Page");
        framev.setLayout(null);
        framev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framev.setLocationRelativeTo(null);
        framev.setVisible(true);
        
    }
    
    public void Labels(){      
        lblRecordView = new JLabel("RECORD VIEW");
        lblRecordView.setBounds(500, 15, 380, 70);
        lblRecordView.setForeground(Color.WHITE);
        lblRecordView.setFont(new Font("Bahnschrift Condensed", Font.BOLD, 42));
        framev.add(lblRecordView);
        
        lblSearch = new JLabel("Search User:");
        lblSearch.setBounds(40, 120, 400, 70);
        lblSearch.setForeground(Color.WHITE);
        lblSearch.setFont(new Font("Bahnschrift Condensed", Font.PLAIN, 18));
        framev.add(lblSearch);
    }
    
    public void Buttons(){
        btnLogin = new JButton("Back To Login");
        btnLogin.setBounds(45, 25, 120, 34);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(new Color(255,255,255));
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("impact", Font.PLAIN, 14));
        btnLogin.addActionListener(this);
        framev.add(btnLogin);
        
        btnAdmin = new JButton("Admin Mode");
        btnAdmin.setBounds(1100, 25, 120, 34);
        btnAdmin.setBorderPainted(false);
        btnAdmin.setBackground(new Color(255,255,255));
        btnAdmin.setForeground(Color.BLACK);
        btnAdmin.setFont(new Font("impact", Font.PLAIN, 14));
        btnAdmin.addActionListener(this);
        framev.add(btnAdmin);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(515, 140, 90, 27);
        btnSearch.setBorderPainted(false);
        btnSearch.setBackground(new Color(255,255,255));
        btnSearch.setForeground(Color.BLACK);
        btnSearch.setFont(new Font("impact", Font.PLAIN, 14));
        btnSearch.addActionListener(this);
        framev.add(btnSearch);
        
        btnDelete = new JButton("Delete");
        btnDelete.setBounds(635, 140, 90, 27);
        btnDelete.setBorderPainted(false);
        btnDelete.setBackground(new Color(255,255,255));
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setFont(new Font("impact", Font.PLAIN, 14));
        btnDelete.addActionListener(this);
        btnDelete.setVisible(false);
        framev.add(btnDelete);
        
    }
    
    public void Table(){
        String [] columnName = {"First Name", "Middle Name", "Last Name", "Email Address", "Username", "Password"};
        String[][] user = showRecord();
        tbl = new DefaultTableModel(user, columnName);
        tbl = new DefaultTableModel(user, columnName){
               @Override
               public boolean isCellEditable(int row, int column) {
                   return false;
               }
           };
        
        tbRecord = new JTable(tbl);
        tbRecord.getTableHeader().setBackground(new Color(176,54,49));
        tbRecord.getTableHeader().setForeground(new Color(255,255,255));
        tbRecord.getTableHeader().setFont(new Font("impact", Font.PLAIN, 16));
        tbRecord.setFillsViewportHeight(true);
        spRecord = new JScrollPane(tbRecord);
        spRecord.setBounds(40, 195, 710, 535);
        //tbRecord.setEnabled(false);
        tbRecord.setDefaultEditor(Object.class, null);
        
        usernameColumn = tbRecord.getColumnModel().getColumn(4);
        passwordColumn = tbRecord.getColumnModel().getColumn(5);
        tbRecord.getColumnModel().removeColumn(usernameColumn);
        tbRecord.getColumnModel().removeColumn(passwordColumn);
        
        framev.add(spRecord); 
        
    }
    
    public void Textfields(){
        tfFName = new JTextField("Enter First Name");
        tfFName.setBounds(170, 140, 130, 25);
        tfFName.addActionListener(this);
        framev.add(tfFName);
        
        tfLName = new JTextField("Enter Last Name");
        tfLName.setBounds(320,140,130,25);
        tfLName.addActionListener(this);
        framev.add(tfLName);
        
    }
    
    public void Textarea(){
        txtSearch = new JTextArea();
        txtSearch.setBounds(790, 230, 455, 435);
        txtSearch.setFont(new Font("Arial", Font.PLAIN, 20));
        txtSearch.setEditable(false);
        framev.add(txtSearch);
    }
    
    public void Panels(){
        pnlRed = new JPanel();
        pnlRed.setBounds(0, 0, 1280, 100);
        pnlRed.setBackground(new Color(128, 0, 0));
        framev.add(pnlRed);
        
        pnlYellow = new JPanel();
        pnlYellow.setBounds(0, 100, 1280, 700);
        pnlYellow.setBackground(new Color(255, 218, 88));
        framev.add(pnlYellow);
    }
    
    private String[][] showRecord() {
        ArrayList<String[]> userList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                String[] row = new String[6]; 
                row[0] = rs.getString("First_Name"); 
                row[1] = rs.getString("Middle_Name");
                row[2] = rs.getString("Last_Name"); 
                row[3] = rs.getString("Email");
                row[4] = rs.getString("Username");
                row[5] = rs.getString("Pass_word");

                userList.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        String[][] user = new String[userList.size()][6];
        for (int i = 0; i < userList.size(); i++) {
            user[i] = userList.get(i);
        }
        return user;
    }
    
    private void refreshTable() {
        while (tbRecord.getRowCount() > 0) {
            tbl.removeRow(0);
        }
    
        String[][] newUser = showRecord();
    
        for (String[] row : newUser) {
            tbl.addRow(row);
        }
    }
     private void searchUser(String fname, String lname) {
        ArrayList<String[]> userList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            String sqlcommand = ("SELECT * FROM users WHERE First_Name = ? AND Last_Name = ?");
            PreparedStatement pst = connection.prepareStatement(sqlcommand);
            pst.setString(1, fname);
            pst.setString(2, lname);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String searchResult = "\n" + "First Name: " + rs.getString("First_Name") + "\n" + "\n" +
                                      "Middle Name: " + rs.getString("Middle_Name") + "\n" +"\n" +
                                      "Last Name: " + rs.getString("Last_Name") + "\n" + "\n" +
                                      "Email: " + rs.getString("Email")+ "\n" +"\n" ;
                txtSearch.setText(searchResult);
                if (btnDelete.isVisible()) {
                txtSearch.append("Username: " + rs.getString("Username")+ "\n" + "\n");
                txtSearch.append("Password: " + rs.getString("Pass_word"));
            }
            } else {
                JOptionPane.showMessageDialog(null, "There's No Record", "No Record", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Not Connected", "Database Not Connected", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteUser(String username) {
        try (Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPass)) {
            String sql = "DELETE FROM users WHERE Username=?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                refreshTable();
                JOptionPane.showMessageDialog(null, "The Row is deleted successfully", "Deleted", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Not Connected", "Database Not Connected", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnLogin){
            framev.dispose();
            Loading lp = new Loading();
        }
        else if(e.getSource() == btnSearch){
            String fname = tfFName.getText().trim();
            String lname =tfLName.getText().trim();
            
            if(!fname.isEmpty() || !lname.isEmpty()){
                searchUser(fname, lname);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incomplete input", "Incomplete", JOptionPane.INFORMATION_MESSAGE);
            }      
        }
        else if(e.getSource() == btnAdmin){
            String code = JOptionPane.showInputDialog(null, "Input Admin Code", "Admin Code", JOptionPane.PLAIN_MESSAGE); ;
            if(code.equals("Admin123")){
                btnDelete.setVisible(true);
                tbRecord.setDefaultEditor(Object.class, null);
                tbRecord.getColumnModel().addColumn(usernameColumn);
                tbRecord.getColumnModel().addColumn(passwordColumn);
                
                
            }
            else{
                attempts++;
                if(attempts >=3){
                    new Loading();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Wrong Code", "WARNING!", JOptionPane.ERROR_MESSAGE);
                }
                    
            }
        }
        else if(e.getSource() == btnDelete){
            int selectedRow = tbRecord.getSelectedRow();
                if (selectedRow != -1) { 
                    String username = (String) tbl.getValueAt(selectedRow, 4); // Get the username to delete the row
                    deleteUser(username);
                    tbl.removeRow(selectedRow);
                    selectedRow = -1;
                }
                else{
                    JOptionPane.showMessageDialog(null, "Something went wrong", "WARNING!", JOptionPane.ERROR_MESSAGE);
                }
        
    }
}
}
