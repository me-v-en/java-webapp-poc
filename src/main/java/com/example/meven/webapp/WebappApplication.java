package com.example.meven.webapp;

import com.example.meven.webapp.repository.EmployeeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebappApplication implements CommandLineRunner {

    @Autowired
    private CustomProperties props;

    @Autowired
    private EmployeeProxy employeeProxy;

    public static void main(String[] args) {
        SpringApplication.run(WebappApplication.class, args);
    }

    public void run(String... args) throws Exception {
//        System.out.println("Get Employees call: " + employeeProxy.getEmployees());
    }
}
