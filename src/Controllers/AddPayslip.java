/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.DB;
import Model.Deduction;
import Model.Payslip;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class AddPayslip {
    Payslip payslip;
    
    /*public AddPayslip(Payslip payslip){
        this.payslip = payslip;
    }*/
    public AddPayslip(String eid, String month, String year){
        try{
            Connection con = DB.createConnection();
            Statement st=con.createStatement();
            
            ResultSet rs1 = st.executeQuery("SELECT * FROM employee WHERE eid = '"+eid+"' "); 
            
            String fname=null;
            String lname=null;
            String desig=null;
            String dept=null;
            double bs=0;;       
            double med=0;   
            double trav=0;               
            double house=0;
            double gross=0;
            double welfare=0;        
            double exe=0;        
            double tech=0;       
            double acc=0;       
            double totDed=0;     
            double net=0; 
            
            int desigID=0, deptID=0;
            
            while (rs1.next()) { 
            fname=rs1.getString(2);
            lname=rs1.getString(3);
            desigID=rs1.getInt(11);
            deptID=rs1.getInt(12);
             
            } 
            
            ResultSet rs2 = st.executeQuery("SELECT * FROM designation WHERE desigID = '"+desigID+"' ");
            
            while (rs2.next()) { 
            desig=rs2.getString(2);
            bs=rs2.getDouble(3);       
            med=rs2.getDouble(4);   
            trav=rs2.getDouble(5);               
            house=rs2.getDouble(6);
            
            }
            
            ResultSet rs3 = st.executeQuery("SELECT department FROM department WHERE deptID = '"+deptID+"' ");
            
            while (rs3.next()) { 
            dept=rs3.getString(1);
            }
            
            ResultSet rs4 = st.executeQuery("SELECT count(*) FROM deduction WHERE eid = '"+eid+"' AND deductCode=1 ");
            int c1=0;
            while (rs4.next()) { 
            c1=rs4.getInt(1);
            }
            
            if (c1>0){
                welfare=500;
            }
            
            ResultSet rs5 = st.executeQuery("SELECT count(*) FROM deduction WHERE eid = '"+eid+"' AND deductCode=2 ");
            int c2=0;
            while (rs5.next()) { 
            c2=rs5.getInt(1);
            }
            
            if (c2>0){
                exe=300;
            }
            
            ResultSet rs6 = st.executeQuery("SELECT count(*) FROM deduction WHERE eid = '"+eid+"' AND deductCode=3 ");
            int c3=0;
            while (rs6.next()) { 
            c3=rs6.getInt(1);
            }
            
            if (c3>0){
                tech=200;
            }
            
            ResultSet rs7 = st.executeQuery("SELECT count(*) FROM deduction WHERE eid = '"+eid+"' AND deductCode=4 ");
            int c4=0;
            while (rs7.next()) { 
            c4=rs7.getInt(1);
            }
            
            if (c4>0){
                acc=5000;
            }
            
            gross=bs+med+trav+house;
            totDed=welfare+exe+tech+acc;
            net=gross-totDed;
            
            Payslip ps= new Payslip(Integer.parseInt(eid),fname,lname,desig,dept,bs,med,trav,house,gross,welfare,exe,tech,acc,totDed,net);
            
            String name=fname+" "+lname;
            
            st.executeUpdate("truncate table payslip");
            String sql = "INSERT INTO payslip VALUES('"+eid+"', '"+name+"', '"+desig+"', '"+dept+"', '"+bs+"', '"+med+"', '"+trav+"', '"+house+"', '"+gross+"', '"+welfare+"', '"+exe+"', '"+tech+"', '"+acc+"', '"+totDed+"', '"+net+"') ";
            st.executeUpdate(sql);
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error" + e.getLocalizedMessage());
        }
    }
}
