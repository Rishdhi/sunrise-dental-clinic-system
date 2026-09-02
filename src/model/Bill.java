/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Bill {
    
    private int billId;
    private int appointmentNumber;
    private BigDecimal totalAmount;
    private LocalDate billDate;
 
    public Bill() {
    }
 
    public Bill(int billId, int appointmentNumber, BigDecimal totalAmount, LocalDate billDate) {
        this.billId = billId;
        this.appointmentNumber = appointmentNumber;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }
 
    public Bill(int appointmentNumber, BigDecimal totalAmount, LocalDate billDate) {
        this.appointmentNumber = appointmentNumber;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }
 
    public int getBillId() {
        return billId;
    }
 
    public void setBillId(int billId) {
        this.billId = billId;
    }
 
    public int getAppointmentNumber() {
        return appointmentNumber;
    }
 
    public void setAppointmentNumber(int appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }
 
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
 
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
 
    public LocalDate getBillDate() {
        return billDate;
    }
 
    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }
 
    @Override
    public String toString() {
        return "Bill{" + "billId=" + billId + ", appointmentNumber=" + appointmentNumber
                + ", totalAmount=" + totalAmount + ", billDate=" + billDate + '}';
    }
    
}
