/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Payslip {
    public int eid;
    public String fname;
    public String lname;
    public String desig;
    public String dept;
    public double bs;      
    public double med;   
    public double trav;               
    public double house;
    public double gross;
    public double welfare;        
    public double exe;        
    public double tech;       
    public double acc;       
    public double totDed;     
    public double net;  
       
    public Payslip(int eid, String fname, String lname, String desig, String dept, double bs, double med, double trav, double house, double gross, double welfare, double exe, double tech, double acc, double totDed, double net ){
        
        this.eid = eid;
        this.fname = fname;
        this.lname = lname;
        this.desig = desig;
        this.dept = dept;
        this.bs = bs;
        this.med = med;
        this.trav = trav;
        this.house = house;
        this.gross = gross;
        this.welfare = welfare;
        this.exe = exe;
        this.tech = tech;
        this.acc = acc;
        this.totDed = totDed;
        this.net = net;
        
        
    }
}
