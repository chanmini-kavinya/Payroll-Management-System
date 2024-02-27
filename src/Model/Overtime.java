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
public class Overtime {
    public int eid;
    public Date date;
    public int hours;
    public int month;
    public int year;
       
    public Overtime(int eid, Date date, int hours, int month, int year){
        
        this.eid = eid;
        this.date = date;
        this.hours = hours;
        this.month=month;
        this.year=year;
    }
}
