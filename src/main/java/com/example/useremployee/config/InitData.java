package com.example.useremployee.config;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.Gender;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UnicodeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InitData  implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UnicodeRepository unicodeRepository;
    @Override
    public void run(String... args) throws Exception {
        User usl1 = new User();
        usl1.setUserID(0);
        usl1.setEmail("jens@aol.com");
        usl1.setPassword("pasrdjalk");
        userRepository.save(usl1);

        Employee emp1 = new Employee();
        emp1.setBorn(LocalDateTime.of(1990, 5, 10, 16, 10, 12));
        emp1.setName("Jens");
        emp1.setGender(Gender.MALE);
        emp1.setVegetarian(true);
        emp1.setUser(usl1);
        employeeRepository.save(emp1);


        // Unicode JPA Opgave Step 6

    }
}
