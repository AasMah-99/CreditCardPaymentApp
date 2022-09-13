package com.ccpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccpa.model.Payment;

@Repository          //to declare the interface that it can handle CRUD operations from database
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
