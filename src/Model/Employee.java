/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Employee {
    public int eid;
    public String firstName;
    public String lastName;
    public Date dob;
    public String status;
    public String nic;
    public String address;
    public String mobile;
    public String desig;
    public String dept;
    public Date dateEmp; 
    public String image; 
       
    public Employee(int eid, String firstName, String lastName, Date dob, String status, String nic, String address, String mobile, String desig, String dept, Date dateEmp, String image){
        
        this.eid = eid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.status = status;
        this.nic = nic;
        this.address = address;
        this.mobile = mobile;
        this.desig = desig;
        this.dept = dept;
        this.dateEmp = dateEmp;
        this.image = image;
    }
}
