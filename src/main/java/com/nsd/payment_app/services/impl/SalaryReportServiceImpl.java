package com.nsd.payment_app.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.payment_app.dtos.SalaryReportDto;
import com.nsd.payment_app.entities.Employees;
import com.nsd.payment_app.entities.SalaryReport;
import com.nsd.payment_app.mapper.SalaryReportMapper;
import com.nsd.payment_app.repo.EmployeesRepo;
import com.nsd.payment_app.repo.SalaryReportRepo;
import com.nsd.payment_app.services.SalaryReportService;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
@Service
public class SalaryReportServiceImpl implements SalaryReportService {

	@Autowired
	private SalaryReportRepo salaryReportRepo;

	@Autowired
	private EmployeesRepo employeesRepo;

	@Override
	public ResponseEntity<Map<String, Object>> addSalary(SalaryReportDto salaryReportDto) throws Exception {

		SalaryReport salaryReport = SalaryReportMapper.TO_SALARY_REPORT.apply(salaryReportDto).orElse(null);
		Employees employees = employeesRepo.findById(salaryReportDto.getEmployeesDto().getEmployeeId())
				.orElseThrow(() -> new Exception());

		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(salaryReport)) {

			salaryReport.setEmployees(employees);
			SalaryReport report = salaryReportRepo.save(salaryReport);

			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", report.getSalaryId());
		} else {
			response.put("message", "Error");
			response.put("status", 500);
			response.put("data", null);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> updateSalaryReport(Integer salaryId, SalaryReportDto salaryReportDto)
			throws Exception {

		SalaryReport salaryReport = SalaryReportMapper.TO_SALARY_REPORT.apply(salaryReportDto)
				.orElseThrow(() -> new Exception());
		SalaryReport salaryReport2 = salaryReportRepo.findById(salaryId).orElseThrow(() -> new Exception());

		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(salaryReport) && Objects.nonNull(salaryReport2)) {

			salaryReport.setSalaryId(salaryId);
			salaryReport.setEmployees(salaryReport2.getEmployees());
			salaryReportRepo.save(salaryReport);
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", salaryId);
		} else {
			response.put("message", "Error");
			response.put("status", 500);
			response.put("data", null);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> getSalaryReportById(Integer salaryId) throws Exception {

		SalaryReport report = salaryReportRepo.findById(salaryId).orElseThrow(() -> new Exception());
		Map<String, Object> response = new HashMap<>();
		response.put("message", "Success");
		response.put("status", 200);
		response.put("data", SalaryReportMapper.TO_SALARY_REPORT_DTO.apply(report));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
