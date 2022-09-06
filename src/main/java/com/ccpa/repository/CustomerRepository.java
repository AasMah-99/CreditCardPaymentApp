package com.ccpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ccpa.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("From Customer a WHERE a.custId =:aCustid")
	Customer getCustomerById(@Param("aCustid") Long custId);
}
