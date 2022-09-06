package com.ccpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ccpa.model.Statement;

@Repository
public interface StatementRepository extends JpaRepository<Statement, Long> {
	@Query("From Statement a WHERE a.statementId =:aStatementid")
	Statement getStatementById(@Param("aStatementid") Long statementId);
}
