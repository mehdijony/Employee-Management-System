package com.employeemanagement.service;

import com.employeemanagement.exception.EmployeeException;
import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(String employeeId) throws EmployeeException {
        if (!StringUtils.hasText(employeeId)) {
            throw new EmployeeException("Employee ID cannot be empty");
        }
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException("Employee not found with ID: " + employeeId));
    }

    @Override
    public Employee createEmployee(Employee employee) throws EmployeeException {
        if (employee == null) {
            throw new EmployeeException("Employee data cannot be null");
        }

//        if (employee.getEmployeeId() == null || employee.getEmployeeId().trim().isEmpty()) {
        if (employee.getEmployeeId() == null ) {
            throw new EmployeeException("Employee ID is required");
        }

        if (employeeRepository.existsById(employee.getEmployeeId())) {
            throw new EmployeeException("Employee with ID " + employee.getEmployeeId() + " already exists");
        }

        setDefaultValues(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(String employeeId, Employee updatedEmployee) throws EmployeeException {
        validateEmployeeForUpdate(updatedEmployee);

        Employee existingEmployee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeException("Employee not found with ID: " + employeeId));

        updateEmployeeFields(existingEmployee, updatedEmployee);
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(String employeeId) throws EmployeeException {
        if (!employeeRepository.existsById(employeeId)) {
            throw new EmployeeException("Employee not found with ID: " + employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }

    // Helper methods
    private void validateEmployeeForCreation(Employee employee) throws EmployeeException {
        if (employee == null) {
            throw new EmployeeException("Employee data cannot be null");
        }

        if (!StringUtils.hasText(employee.getEmployeeId())) {
            throw new EmployeeException("Employee ID is required");
        }

        if (!StringUtils.hasText(employee.getFirstName())) {
            throw new EmployeeException("First name is required");
        }

        if (!StringUtils.hasText(employee.getLastName())) {
            throw new EmployeeException("Last name is required");
        }
    }

    private void validateEmployeeForUpdate(Employee employee) throws EmployeeException {
        if (employee == null) {
            throw new EmployeeException("Employee data cannot be null");
        }

        if (!StringUtils.hasText(employee.getFirstName())) {
            throw new EmployeeException("First name is required");
        }

        if (!StringUtils.hasText(employee.getLastName())) {
            throw new EmployeeException("Last name is required");
        }
    }

    private void setDefaultValues(Employee employee) {
        if (employee.getTitle() == null) {
            employee.setTitle("Not Specified");
        }

        if (employee.getDivision() == null) {
            employee.setDivision("Unassigned");
        }

        if (employee.getBuilding() == null) {
            employee.setBuilding("Not Assigned");
        }

        if (employee.getRoom() == null) {
            employee.setRoom("Not Assigned");
        }
    }

    private void updateEmployeeFields(Employee existing, Employee updated) {
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());

        if (updated.getTitle() != null) {
            existing.setTitle(updated.getTitle());
        }

        if (updated.getDivision() != null) {
            existing.setDivision(updated.getDivision());
        }

        if (updated.getBuilding() != null) {
            existing.setBuilding(updated.getBuilding());
        }

        if (updated.getRoom() != null) {
            existing.setRoom(updated.getRoom());
        }
    }
}