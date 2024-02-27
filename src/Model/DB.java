/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DB {
    public static Connection createConnection() throws Exception{
        
        Class.forName("com.mysql.cj.jdbc.Driver"); //Driver class
        String path = "jdbc:mysql://localhost/payroll";  //Connection URL
        Connection con = DriverManager.getConnection(path,"root", ""); //username and password for the mysql database
        return con;
    }
    
}
