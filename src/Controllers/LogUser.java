/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Login;
import View.MainWindow;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class LogUser {
     Login login;
    
    public LogUser(Login login){
        this.login = login;
    }
    public int checkLogUser(){
        int count=0;
        try{
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            
            ResultSet rs = st.executeQuery("select count(*) from log_user where username='" + login.username + "' and password=md5('" + login.password + "') ");
            
            while (rs.next()) { 
            count=rs.getInt(1);
            }
                        
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error" + e.getLocalizedMessage());
        }
        finally{
            return count;
        }
    }
    
    
}
