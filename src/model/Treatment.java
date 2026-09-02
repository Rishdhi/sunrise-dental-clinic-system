/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author Admin
 */
public class Treatment {
    
    private int treatmentId;
    private String treatmentName;
    private BigDecimal fee;
 
    public Treatment() {
    }
 
    public Treatment(int treatmentId, String treatmentName, BigDecimal fee) {
        this.treatmentId = treatmentId;
        this.treatmentName = treatmentName;
        this.fee = fee;
    }
 
    public Treatment(String treatmentName, BigDecimal fee) {
        this.treatmentName = treatmentName;
        this.fee = fee;
    }
 
    public int getTreatmentId() {
        return treatmentId;
    }
 
    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }
 
    public String getTreatmentName() {
        return treatmentName;
    }
 
    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
    }
 
    public BigDecimal getFee() {
        return fee;
    }
 
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
 
    @Override
    public String toString() {
        return "Treatment{" + "treatmentId=" + treatmentId + ", treatmentName=" + treatmentName + ", fee=" + fee + '}';
    }
    
}
