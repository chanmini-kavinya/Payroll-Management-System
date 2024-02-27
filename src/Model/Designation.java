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
public class Designation {
    
        public String designation;
        public String category;
        public double basicSalary;
        public double medicalAllow;
        public double travelAllow;
        public double houseAllow;
        public double OTrate;

        public Designation(String designation, String category, double basiSalary, double medicalAllow, double travelAllow, double houseAllow, double OTrate){

            this.designation = designation;
            this.category = category;
            this.basicSalary = basiSalary;
            this.medicalAllow = medicalAllow;
            this.travelAllow = travelAllow;
            this.houseAllow = houseAllow;
            this.OTrate = OTrate;
        }
    
}
