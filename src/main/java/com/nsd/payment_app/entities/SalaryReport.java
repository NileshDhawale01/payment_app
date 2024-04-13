package com.nsd.payment_app.entities;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nilesh Dhawale
 * @Since 13-April-2024
 * @Version 1.0
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "salary_report")
public class SalaryReport extends Audit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "salary_id")
	private Integer salaryId;

	@Column(name = "salary_from_date")
	private LocalDateTime salaryFromDate;

	@Column(name = "salary_to_date")
	private LocalDateTime salaryToDate;

	@Column(name = "total_working_days")
	private Integer totalWorkingDays;

	@Column(name = "salary_amount")
	private Double salaryAmount;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "employee_id")
	private Employees employees;
}
