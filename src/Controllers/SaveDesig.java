/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Designation;
import Model.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SaveDesig {
    Designation designation;
    
    public SaveDesig(){
        
    }
    
    public SaveDesig(Designation designation){
        this.designation = designation;
    }
    
    public void saveDesigToDatabase(){
        
        try{
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("SELECT categoryID FROM desig_category WHERE category = '"+designation.category+"' "); 
            String catID = null;
            while (rs.next()) { 
            catID = rs.getString(1); 
            } 
                        
            String sql = "INSERT INTO designation(designation, basicSalary, medicalAllow, travelAllow, houseAllow, OTrate, catID) "
                    + "VALUES('"+designation.designation+"', '"+designation.basicSalary+"', '"+designation.medicalAllow+"', '"+designation.travelAllow+"', "
                    + "'"+designation.houseAllow+"', '"+designation.OTrate+"', '"+catID+"') ";
            
            int rowsUpdated=st.executeUpdate(sql);
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Designation saved successfully");
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
