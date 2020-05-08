package com.example.petclinicweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.petclinicdata", "com.example.petclinicweb"})
public class PetClinicWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetClinicWebApplication.class, args);
    }

}
