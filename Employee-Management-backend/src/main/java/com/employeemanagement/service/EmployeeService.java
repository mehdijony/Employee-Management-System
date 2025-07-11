package com.employeemanagement.service;

import com.employeemanagement.exception.EmployeeException;
import com.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * Retrieves all employees
     * @return List of all employees
     * @throws EmployeeException if any error occurs
     */
    List<Employee> getAllEmployees() throws EmployeeException;

    /**
     * Finds an employee by their ID
     * @param employeeId the employee ID to search for
     * @return the found employee
     * @throws EmployeeException if employee not found or ID is invalid
     */
    Employee getEmployeeById(String employeeId) throws EmployeeException;

    /**
     * Creates a new employee
     * @param employee the employee data to create
     * @return the created employee
     * @throws EmployeeException if employee data is invalid or employee already exists
     */
    Employee createEmployee(Employee employee) throws EmployeeException;

    /**
     * Updates an existing employee
     * @param employeeId the ID of the employee to update
     * @param employee the updated employee data
     * @return the updated employee
     * @throws EmployeeException if employee not found or data is invalid
     */
    Employee updateEmployee(String employeeId, Employee employee) throws EmployeeException;

    /**
     * Deletes an employee
     * @param employeeId the ID of the employee to delete
     * @throws EmployeeException if employee not found
     */
    void deleteEmployee(String employeeId) throws EmployeeException;
}