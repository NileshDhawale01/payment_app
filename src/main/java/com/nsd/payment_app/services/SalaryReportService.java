package com.nsd.payment_app.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.nsd.payment_app.dtos.SalaryReportDto;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

public interface SalaryReportService {

	public ResponseEntity<Map<String, Object>> addSalary(SalaryReportDto salaryReportDto) throws Exception;

	public ResponseEntity<Map<String, Object>> updateSalaryReport(Integer salaryId, SalaryReportDto salaryReportDto)
			throws Exception;

	public ResponseEntity<Map<String, Object>> getSalaryReportById(Integer salaryId) throws Exception;
}
