package com.example.demo;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaHelloApplication { // Correct application class name

    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaHelloApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaHelloApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        return (args) -> {

            Person john = new Person("John");
            repository.save(john);  // Save the person

            // Find by ID
            Optional<Person> person = repository.findById(john.getId());
            person.ifPresent(p -> {
                log.info("Found person by ID: " + p);
            });


            // Find by name (custom query)
            Optional<Person> foundByName = repository.findByName("John");
            foundByName.ifPresent(p -> {
                log.info("Found Person by Name: " + p);
            });

            // Fetch all persons
            log.info("All persons found with findAll():");
            log.info("-------------------------------");
            repository.findAll().forEach(p -> log.info(p.toString()));

        };
    }
}