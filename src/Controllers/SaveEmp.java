/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SaveEmp {
    Employee employee;
        
    public SaveEmp(Employee employee){
        this.employee = employee;
    }
    
    public void saveEmpToDatabase(){
        
        try{            
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            ResultSet rs = st.executeQuery("SELECT desigID FROM designation WHERE designation = '"+employee.desig+"' "); 
            String desID = null;
            while (rs.next()) { 
            desID = rs.getString(1); 
            } 
            
            ResultSet rs2 = st.executeQuery("SELECT deptID FROM department WHERE department = '"+employee.dept+"' "); 
            String depID = null;
            while (rs2.next()) { 
            depID = rs2.getString(1); 
            } 
            
            String sql = "INSERT INTO employee(eid, firstName, lastName, dob, status, nic, address, mobileNo,  dateEmp, desigID, deptID, image) VALUES('"+employee.eid+"', '"+employee.firstName+"', '"+employee.lastName+"', '"+employee.dob+"', '"+employee.status+"', '"+employee.nic+"', '"+employee.address+"', '"+employee.mobile+"', '"+employee.dateEmp+"', '"+desID+"', '"+depID+"', '"+employee.image+"') ";
            
            int rowsUpdated=st.executeUpdate(sql);
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Employee saved successfully");
             }
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
}
