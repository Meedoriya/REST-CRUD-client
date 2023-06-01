package com.alibi.spring.rest;

import com.alibi.spring.rest.configuration.MyConfig;
import com.alibi.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args ) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean("communication", Communication.class);
        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee empById = communication.getEmployee(10);
        System.out.println(empById);

        Employee employee = new Employee("Alexander", "Makedonskiy", "IT", 1200);
        employee.setId(13);
        communication.saveEmployee(employee);
        System.out.println(employee);

        communication.deleteEmployee(13);
    }
}
