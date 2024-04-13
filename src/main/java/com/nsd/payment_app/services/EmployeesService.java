package com.nsd.payment_app.services;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.nsd.payment_app.dtos.EmployeesDto;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
public interface EmployeesService {

	public ResponseEntity<Map<String, Object>> addEmployee(EmployeesDto employeesDto);

	public ResponseEntity<Map<String, Object>> getEmployeeById(Integer employeeId);

	public ResponseEntity<Map<String, Object>> allEmployee();

	public ResponseEntity<Map<String, Object>> updateEmployee(Integer employeeId, EmployeesDto employeesDto)throws Exception;
}
