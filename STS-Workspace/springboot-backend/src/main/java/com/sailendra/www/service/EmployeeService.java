package com.sailendra.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sailendra.www.Exception.ResourceNotFoundException;
import com.sailendra.www.model.EmployeeModel;
import com.sailendra.www.repo.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeModel> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public EmployeeModel addEmployee(EmployeeModel employee) {
        return employeeRepo.save(employee);
    }

    public ResponseEntity<EmployeeModel> updateEmployee(long id, EmployeeModel employee) {
        EmployeeModel oldEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        oldEmployee.setFirstName(employee.getFirstName());
        oldEmployee.setLastName(employee.getLastName());
        oldEmployee.setEmail(employee.getEmail());

        EmployeeModel updatedEmployee = employeeRepo.save(oldEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    public String deleteEmployee(long id) {
        EmployeeModel employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepo.delete(employee);
        return "Employee deleted successfully!";
    }
}
