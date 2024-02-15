package com.example.useremployee.config;

import com.example.useremployee.model.*;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UnicodeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
        Set<Character> charSet = new HashSet<>();
        for (char ch = 32; ch <= 126; ch++) {
            charSet.add(ch);
        }
        saveMissingUnicodeCharacters(charSet);
    }

    private void saveMissingUnicodeCharacters(Set<Character> characterSet) {

        for (Character ch : characterSet) {
            Unicode unicodeChar = new Unicode();
            unicodeChar.setBogstav(ch);
            unicodeChar.setUnicode((int) ch);
            unicodeChar.setDescription("Description | " + ch + " | " + (int) ch);
            unicodeRepository.save(unicodeChar);
        }
    }


}
