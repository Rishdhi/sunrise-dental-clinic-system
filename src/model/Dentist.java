/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Dentist {
    
     private int dentistId;
    private String name;
    private String specialization;
 
    public Dentist() {
    }
 
    public Dentist(int dentistId, String name, String specialization) {
        this.dentistId = dentistId;
        this.name = name;
        this.specialization = specialization;
    }
 
    public Dentist(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
 
    public int getDentistId() {
        return dentistId;
    }
 
    public void setDentistId(int dentistId) {
        this.dentistId = dentistId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getSpecialization() {
        return specialization;
    }
 
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
 
    @Override
    public String toString() {
        return "Dentist{" + "dentistId=" + dentistId + ", name=" + name + '}';
    }
    
}
