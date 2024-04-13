package com.nsd.payment_app.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.payment_app.dtos.EmployeesDto;
import com.nsd.payment_app.entities.Departments;
import com.nsd.payment_app.entities.Employees;
import com.nsd.payment_app.mapper.EmployeesMapper;
import com.nsd.payment_app.repo.DepartmentsRepo;
import com.nsd.payment_app.repo.EmployeesRepo;
import com.nsd.payment_app.services.EmployeesService;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesRepo employeesRepo;

	@Autowired
	private DepartmentsRepo departmentsRepo;

	@Override
	public ResponseEntity<Map<String, Object>> addEmployee(EmployeesDto employeesDto) {

		Employees employees = EmployeesMapper.TO_EMPLOYEES.apply(employeesDto).orElse(null);

		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(employees)) {
			Employees employees2 = employeesRepo.save(employees);
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", employees2.getEmployeeId());
		} else {
			response.put("message", "Error");
			response.put("status", 500);
			response.put("data", null);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> getEmployeeById(Integer employeeId) {

		Employees employees = employeesRepo.findById(employeeId).orElse(null);

		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(employees)) {
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", EmployeesMapper.TO_EMPLOYEES_DTO.apply(employees));
		} else {
			response.put("message", "Error");
			response.put("status", 500);
			response.put("data", null);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> allEmployee() {

		Map<String, Object> response = new HashMap<>();
		response.put("message", "Success");
		response.put("status", 200);
		response.put("data", EmployeesMapper.TO_EMPLOYEES_DTOS.apply(employeesRepo.findAll()));

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Map<String, Object>> updateEmployee(Integer employeeId, EmployeesDto employeesDto)
			throws Exception {

		Employees employees = EmployeesMapper.TO_EMPLOYEES.apply(employeesDto).orElse(null);
		Employees employees2 = employeesRepo.findById(employeeId).orElse(employees);
		Map<String, Object> response = new HashMap<>();
		if (Objects.nonNull(employees) && Objects.nonNull(employees2)
				&& Objects.nonNull(employeesDto.getDepartmentsDto().getDepartmentId())) {

			Departments departments = departmentsRepo.findById(employeesDto.getDepartmentsDto().getDepartmentId())
					.orElseThrow(() -> new Exception());
			employees.setEmployeeId(employeeId);
			employees.setDepartments(departments);
			employeesRepo.save(employees);
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", employeeId);
		} else {
			response.put("message", "Success");
			response.put("status", 200);
			response.put("data", employeeId);
		}
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
