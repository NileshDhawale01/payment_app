package com.nsd.payment_app.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nsd.payment_app.dtos.EmployeesDto;
import com.nsd.payment_app.entities.Employees;
import com.nsd.payment_app.util.FunctionUtil;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */
public class EmployeesMapper {

	private EmployeesMapper() {
	}

	public static final Function<EmployeesDto, Optional<Employees>> TO_EMPLOYEES = e -> {
		Employees employees = FunctionUtil.evalMapperProjection(e, Employees.class).get();
		return Optional.of(employees);
	};

	public static final Function<Employees, Optional<EmployeesDto>> TO_EMPLOYEES_DTO = e -> {

		EmployeesDto employeesDto = FunctionUtil.evalMapper(e, EmployeesDto.class).get();
		if (Objects.nonNull(e.getDepartments())) {
			employeesDto.setDepartmentsDto(DepartmentsMapper.TO_DEPARTMENTS_DTO.apply(e.getDepartments()).get());
		}
		return Optional.of(employeesDto);
	};

	public static final Function<Collection<Employees>, List<EmployeesDto>> TO_EMPLOYEES_DTOS = e -> e.stream()
			.map(s -> TO_EMPLOYEES_DTO.apply(s).get()).collect(Collectors.toList());
}
