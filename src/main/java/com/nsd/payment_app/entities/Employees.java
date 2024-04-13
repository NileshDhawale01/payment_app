package com.nsd.payment_app.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
public class Employees extends Audit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Integer employeeId;

	@Column(name = "employee_name")
	private String employeeName;

	@Column(name = "employee_contact")
	private String employeeContact;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@OneToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "department_id")
	private Departments departments;

}
