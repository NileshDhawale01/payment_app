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

import com.nsd.payment_app.dtos.EmployeesDto;
import com.nsd.payment_app.services.EmployeesService;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@RestController
@RequestMapping("/employee")
public class EmployeesApis {

	@Autowired
	private EmployeesService employeesService;

	@PostMapping
	public ResponseEntity<Map<String, Object>> addEmployee(@RequestBody EmployeesDto employeesDto) {

		return employeesService.addEmployee(employeesDto);
	}

	@GetMapping("/{employeeId}")
	public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable Integer employeeId) {

		return employeesService.getEmployeeById(employeeId);
	}

	@GetMapping
	public ResponseEntity<Map<String, Object>> allEmployee() {

		return employeesService.allEmployee();
	}

	@PutMapping("/{employeeId}")
	public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable Integer employeeId,
			@RequestBody EmployeesDto employeesDto) throws Exception {

		return employeesService.updateEmployee(employeeId, employeesDto);
	}
}
