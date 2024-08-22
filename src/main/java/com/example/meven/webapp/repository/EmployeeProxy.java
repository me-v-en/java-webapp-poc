package com.example.meven.webapp.repository;

import com.example.meven.webapp.CustomProperties;
import com.example.meven.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// Slf4j : provide a logger instance called log, to create custom logging messages (Lombok annotation)
@Slf4j
@Component
public class EmployeeProxy {

    @Autowired
    private CustomProperties customProperties;

    /**
     * Create an employee
     *
     * @param employee Employee to create
     * @return the employee created
     */
    public Employee createEmployee(Employee employee) {
        final String createEmployeeAPIUrl = customProperties.getApiUrl() + "/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(createEmployeeAPIUrl,
                HttpMethod.POST,
                request,
                Employee.class
        );
        log.debug("Create Employee call " + response.getStatusCode());
        return response.getBody();
    }


    /**
     * Update an employee
     *
     * @param employee Employee to create
     * @return the employee created
     */
    public Employee updateEmployee(int employeeId, Employee employee) {
        final String createEmployeeAPIUrl = customProperties.getApiUrl() + "/employee/" + employeeId;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request = new HttpEntity<Employee>(employee);
        ResponseEntity<Employee> response = restTemplate.exchange(createEmployeeAPIUrl,
                HttpMethod.PUT,
                request,
                Employee.class
        );
        log.debug("Update Employee call " + response.getStatusCode());
        return response.getBody();
    }

    /**
     * Delete an employee
     *
     * @param employeeId The employee id to delete
     */
    public void deleteEmployee(int employeeId) {
        final String deleteEmployeeAPIUrl = customProperties.getApiUrl() + "/employee/" + employeeId;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(deleteEmployeeAPIUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );

        log.debug("Delete Employee call " + response.getStatusCode());
    }

    /**
     * Get the employee data
     *
     * @return An iterable of all employees
     * @ param employeeId The id of the employee of which we want the properties
     */
    public Employee getEmployeeById(int employeeId) {
        final String getEmployeeAPIUrl = customProperties.getApiUrl() + "/employee/" + employeeId;

        //Instantiate the restTemplate
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Employee> response = restTemplate.exchange(getEmployeeAPIUrl,
                HttpMethod.GET,
                null,
                Employee.class
        );

        log.debug("Get Employee call " + response.getStatusCode());
        return response.getBody();
    }


    /**
     * Get all employees
     *
     * @return An iterable of all employees
     */
    public Iterable<Employee> getEmployees() {
        final String getEmployeesAPIUrl = customProperties.getApiUrl() + "/employees";

        //Instantiate the restTemplate
        RestTemplate restTemplate = new RestTemplate();
        // Call the exchange method : Synchronically execute the HTTP method to the given URI template
        // URL
        // Method
        // Custom requestEntity object if needed
        // The type to convert the response to
        ResponseEntity<Iterable<Employee>> response = restTemplate.exchange(getEmployeesAPIUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Employee>>() {
                });

        log.debug("Get all Employees call " + response.getStatusCode());
        return response.getBody();
    }

    ;
}
