/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Overtime;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class AddOvertime {
    Overtime overtime;
    
    public AddOvertime(Overtime overtime){
        this.overtime = overtime;
    }
    public void addOvertimeToDatabase(){
        try{
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            
            String sql = "INSERT INTO overtime(eid, date, hours, month, year) VALUES('"+overtime.eid+"', '"+overtime.date+"', '"+overtime.hours+"', '"+overtime.month+"', '"+overtime.year+"') ";
            st.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error" + e.getLocalizedMessage());
        }
    }
    
    public DefaultTableModel addOvertimeToTable(String e){
        // creating a new TableModel
        DefaultTableModel model = new DefaultTableModel(new String[]{ "Date", "Hours"}, 0);
        try {
                     
            //Load the data from the database
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            String sql="SELECT * FROM overtime WHERE eid = '"+e+"' ORDER BY date";
            ResultSet rs = st.executeQuery(sql);
            
            //Add each row of data to the table model
            while(rs.next())
            {
                String date = rs.getString(2);
                String hours = rs.getString(3);
                model.addRow(new Object[]{date, hours});
            }
            con.close();
        } 
        catch (Exception ex) {
            Logger.getLogger(AddOvertime.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return model;
        }
        
    }
}
