/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Designation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UpdateDesig {
    Designation desig;
        
    public UpdateDesig(Designation desig){
        this.desig = desig;
    }
    
    public void updateDesigToDatabase(){
        
        try{            
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            
            ResultSet rs = st.executeQuery("SELECT categoryID FROM desig_category WHERE category = '"+desig.category+"' "); 
            String catID = null;
            while (rs.next()) { 
            catID = rs.getString(1); 
            }
            
            String sql = "UPDATE designation SET basicSalary='"+desig.basicSalary+"', medicalAllow='"+desig.medicalAllow+"', travelAllow='"+desig.travelAllow+"',"
                    + " houseAllow='"+desig.houseAllow+"', OTrate='"+desig.OTrate+"', catID='"+catID+"' WHERE designation='"+desig.designation+"'";
            
            int rowsUpdated=st.executeUpdate(sql);
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Designation updated successfully");
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
