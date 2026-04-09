package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeploymentRepository
        extends JpaRepository<Deployment, Long> {
}
