package com.nhnacademy.springboot.minidooraytask.controller;

import com.nhnacademy.springboot.minidooraytask.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjectRestControllerTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ProjectRepository projectRepository;

    @Test
    void getProjects() {

    }

    @Test
    void getProject() {
    }

    @Test
    void createProject() {
    }

    @Test
    void deleteProject() {
    }
}