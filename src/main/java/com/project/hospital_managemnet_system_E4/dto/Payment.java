package com.project.hospital_managemnet_system_E4.dto;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;

    private String paymentType;
    private double paymentAmount;
    private String paymentStatus;

    // ✅ Keep Date & Time
    private Date paymentDate;
    private Time paymentTime;

    // ✅ Add relationship to Patient (optional)
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // ✅ Getters/Setters
    public int getPaymentId() {
        return paymentId;
    }
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
    public double getPaymentAmount() {
        return paymentAmount;
    }
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    public Date getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Time getPaymentTime() {
        return paymentTime;
    }
    
    public void setPaymentTime(Time paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
