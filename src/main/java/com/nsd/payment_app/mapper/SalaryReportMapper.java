package com.nsd.payment_app.mapper;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.payment_app.dtos.SalaryReportDto;
import com.nsd.payment_app.entities.SalaryReport;
import com.nsd.payment_app.util.FunctionUtil;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
public class SalaryReportMapper {

	private SalaryReportMapper() {
	}

	public static final Function<SalaryReport, Optional<SalaryReportDto>> TO_SALARY_REPORT_DTO = e -> {

		SalaryReportDto salaryReportDto = FunctionUtil.evalMapper(e, SalaryReportDto.class).get();
		if (Objects.nonNull(e.getEmployees())) {
			salaryReportDto.setEmployeesDto(EmployeesMapper.TO_EMPLOYEES_DTO.apply(e.getEmployees()).get());
		}
		return Optional.of(salaryReportDto);
	};

	public static final Function<SalaryReportDto, Optional<SalaryReport>> TO_SALARY_REPORT = e -> {

		SalaryReport report = FunctionUtil.evalMapper(e, SalaryReport.class).get();
		return Optional.of(report);
	};
}
