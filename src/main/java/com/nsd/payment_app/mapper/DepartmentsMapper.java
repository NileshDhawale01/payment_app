package com.nsd.payment_app.mapper;

import java.util.Optional;
import java.util.function.Function;

import com.nsd.payment_app.dtos.DepartmentsDto;
import com.nsd.payment_app.entities.Departments;
import com.nsd.payment_app.util.FunctionUtil;

public class DepartmentsMapper {

	private DepartmentsMapper() {
	}

	public static final Function<DepartmentsDto, Optional<Departments>> TO_DEPARTMENTS = e -> FunctionUtil.evalMapper(e,
			Departments.class);

	public static final Function<Departments, Optional<DepartmentsDto>> TO_DEPARTMENTS_DTO = e -> FunctionUtil
			.evalMapper(e, DepartmentsDto.class);
}
