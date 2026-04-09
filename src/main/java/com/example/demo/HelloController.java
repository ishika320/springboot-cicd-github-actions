package com.example.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DeploymentRepository repository;

    /* Get current status */

    @GetMapping("/api/status")
    public Map<String, Object> getStatus() {

        Map<String, Object> response = new HashMap<>();

        List<Deployment> deployments = repository.findAll();

        int count = deployments.size();

        String lastTime = "Not deployed yet";

        if (count > 0) {
            lastTime =
                deployments
                .get(count - 1)
                .getTime()
                .toString();
        }

        response.put("status", "Running");
        response.put("deployments", count);
        response.put("lastDeployment", lastTime);

        return response;
    }

    /* Save deployment */

    @PostMapping("/api/deploy")
    public Map<String, Object> deploy() {

        Deployment deployment =
                new Deployment(
                        "Success",
                        LocalDateTime.now()
                );

        repository.save(deployment);

        List<Deployment> deployments =
                repository.findAll();

        Map<String, Object> response =
                new HashMap<>();

        response.put(
                "message",
                "Deployment saved to database"
        );

        response.put(
                "deployments",
                deployments.size()
        );

        response.put(
                "time",
                deployment.getTime()
        );

        return response;
    }

}
