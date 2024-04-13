package com.nsd.payment_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsd.payment_app.entities.SalaryReport;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
@Repository
public interface SalaryReportRepo extends JpaRepository<SalaryReport, Integer> {

}
