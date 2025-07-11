package com.employeemanagement;

import com.employeemanagement.exception.EmployeeException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.service.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeManagmentBackendApplicationTests {



	@Mock
	private EmployeeRepository employeeRepository;

	@Mock
	private EmployeeServiceImpl employeeService;



	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAllEmployees_ShouldReturnListOfEmployees() {
		// Arrange
		List<Employee> expectedEmployees = Arrays.asList(
				new Employee("1", "John", "Doe", "Engineer", "IT", "B1", "201"),
				new Employee("2", "Jane", "Smith", "Manager", "HR", "B2", "105")
		);
		when(employeeRepository.findAll()).thenReturn(expectedEmployees);

		// Act
		List<Employee> actualEmployees = employeeRepository.findAll();

		// Assert
		assertEquals(expectedEmployees.size(), actualEmployees.size());
		assertTrue(actualEmployees.containsAll(expectedEmployees));
	}



}
