package com.nsd.payment_app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
public class EmployeesDto {

	private Integer employeeId;

	private String employeeName;

	private String employeeContact;

	private String email;

	private String password;

	private DepartmentsDto departmentsDto;
}
