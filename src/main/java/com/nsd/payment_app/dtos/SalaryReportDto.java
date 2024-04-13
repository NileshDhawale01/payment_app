package com.nsd.payment_app.dtos;

import java.time.LocalDateTime;

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
public class SalaryReportDto {

	private Integer salaryId;

	private LocalDateTime salaryFromDate;

	private LocalDateTime salaryToDate;

	private Integer totalWorkingDays;

	private Double salaryAmount;

	private EmployeesDto employeesDto;
}
