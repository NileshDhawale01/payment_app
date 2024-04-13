package com.nsd.payment_app.apis;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.payment_app.dtos.SalaryReportDto;
import com.nsd.payment_app.services.SalaryReportService;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@RestController
@RequestMapping("/salary")
public class SalaryReportApi {

	@Autowired
	private SalaryReportService salaryReportService;

	@PostMapping
	public ResponseEntity<Map<String, Object>> addSalary(@RequestBody SalaryReportDto salaryReportDto)
			throws Exception {

		return salaryReportService.addSalary(salaryReportDto);
	}

	@PutMapping("/{salaryId}")
	public ResponseEntity<Map<String, Object>> updateSalaryReport(@PathVariable Integer salaryId,
			@RequestBody SalaryReportDto salaryReportDto) throws Exception {

		return salaryReportService.updateSalaryReport(salaryId, salaryReportDto);
	}

	@GetMapping("/{salaryId}")
	public ResponseEntity<Map<String, Object>> getSalaryReportById(@PathVariable Integer salaryId) throws Exception {

		return salaryReportService.getSalaryReportById(salaryId);
	}
}
