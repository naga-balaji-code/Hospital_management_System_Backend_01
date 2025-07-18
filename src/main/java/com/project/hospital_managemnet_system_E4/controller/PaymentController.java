package com.project.hospital_managemnet_system_E4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.hospital_managemnet_system_E4.dto.Payment;
import com.project.hospital_managemnet_system_E4.service.PaymentService;
import com.project.hospital_managemnet_system_E4.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*") 
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @PostMapping("/savePayment")
    public ResponseEntity<ResponseStructure<Payment>> savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    @PutMapping("/updatePaymentById")
    public ResponseEntity<ResponseStructure<Payment>> updatePaymentById(@RequestParam int oldPaymentId,
            @RequestBody Payment newPayment) {
        return paymentService.updatePaymentById(oldPaymentId, newPayment);
    }

    @GetMapping("/fetchPaymentById")
    public ResponseEntity<ResponseStructure<Payment>> fetchPaymentById(@RequestParam int paymentId) {
        return paymentService.fetchPaymentById(paymentId);
    }

    @DeleteMapping("/deletePaymentById")
    public ResponseEntity<ResponseStructure<Payment>> deletePaymentById(@RequestParam int paymentId) {
        return paymentService.deletePaymentById(paymentId);
    }

    @GetMapping("/fetchAllPayment")
    public List<Payment> fetchAllPayment() {
        return paymentService.fetchAllPayment();
    }
}
