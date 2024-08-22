package com.example.meven.webapp.service;

import com.example.meven.webapp.model.Employee;
import com.example.meven.webapp.repository.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeProxy employeeProxy;

    public Employee getEmployeeById(int id) {
        return employeeProxy.getEmployeeById(id);
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeProxy.getEmployees();
    }

    public Employee saveEmployee(Employee employee) {
        if(employee.getId() != null){
            return employeeProxy.updateEmployee(employee);
        }
        else return employeeProxy.createEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeProxy.deleteEmployee(id);
    }
}
