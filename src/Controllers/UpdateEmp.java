/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class UpdateEmp {
    Employee employee;
        
    public UpdateEmp(Employee employee){
        this.employee = employee;
    }
    
    public void updateEmpToDatabase(){
        
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
            
            String sql = "UPDATE employee SET firstName='"+employee.firstName+"', lastName='"+employee.lastName+"', dob='"+employee.dob+"', status='"+employee.status+"', nic='"+employee.nic+"', address='"+employee.address+"', mobileNo='"+employee.mobile+"',  dateEmp='"+employee.dateEmp+"', desigID='"+desID+"', deptID='"+depID+"', image='"+employee.image+"' WHERE eid = '"+employee.eid+"'";
            int rowsUpdated=st.executeUpdate(sql);
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Employee updated successfully");
             }
            con.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
