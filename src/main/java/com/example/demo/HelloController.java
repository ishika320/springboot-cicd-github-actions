package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    private static int deploymentCount = 0;
    private static String lastDeploymentTime = "Not deployed yet";

    @GetMapping("/api/status")
    public Map<String, Object> getStatus() {

        Map<String, Object> response = new HashMap<>();

        response.put("status", "Running");
        response.put("deployments", deploymentCount);
        response.put("lastDeployment", lastDeploymentTime);

        return response;
    }

    @PostMapping("/api/deploy")
    public Map<String, Object> deploy() {

        deploymentCount++;
        lastDeploymentTime = LocalDateTime.now().toString();

        Map<String, Object> response = new HashMap<>();

        response.put("message", "Deployment successful");
        response.put("deployments", deploymentCount);
        response.put("time", lastDeploymentTime);

        return response;
    }
}
