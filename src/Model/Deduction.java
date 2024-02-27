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
public class Deduction {
    public int eid;
    public String type;
    public Date date;
       
    public Deduction(int eid, String type, Date date){
        
        this.eid = eid;
        this.type = type;
        this.date = date;
    }
}
