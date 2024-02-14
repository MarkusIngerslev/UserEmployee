package com.example.useremployee.repositories;

import com.example.useremployee.model.Employee;
import org.hibernate.JDBCException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void testAtLeastOneEmployee() {
        // Denne test forudsætter InitData har kørt
        // Vi har en jens user og employee i databasen
        // Vi vil her teste at vi kan finde mindst 1 employee
        List<Employee> employeesList = employeeRepository.findEmployeeByName("Jens");
        assertTrue(employeesList.size() > 0);
    }

    @Test
    void testDeleteEmployee() {
        // Denne test forudsætter InitData har kørt
        // Vi har en jens user og employee i databasen
        // Vi vil her teste at vi IKKE kan slette 1 user der har en employee
        List<Employee> employeesList = employeeRepository.findEmployeeByName("Jens");
        Employee emp1 = employeesList.get(0);
        assertEquals("Jens", emp1.getName()); // Case sensitive
        //UserRepository.delete(emp1.getUser());

        assertThrows(org.springframework.dao.DataIntegrityViolationException.class, () -> userRepository.delete(emp1.getUser()));
    }




}