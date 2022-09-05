package com.ccpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccpa.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
