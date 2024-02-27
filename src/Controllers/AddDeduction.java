/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Deduction;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class AddDeduction {
    Deduction deduction;
    
    public AddDeduction(Deduction deduction){
        this.deduction = deduction;
    }
    public void addDeductionToDatabase(){
        try{
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT deductCode FROM deduct_type WHERE deductType = '"+deduction.type+"' "); 
            String code = null;
            while (rs.next()) { 
            code = rs.getString(1); 
            } 
            
            String sql = "INSERT INTO deduction(eid, deductCode, dateJoin) VALUES('"+deduction.eid+"', '"+code+"', '"+deduction.date+"') ";
            int rowsUpdated=st.executeUpdate(sql);
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Record added successfully");
             }
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error" + e.getLocalizedMessage());
        }
    }
}
