package com.aparna.github_access_report.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AccessReportController {

    @GetMapping("/access-report")
    public Map<String, Object> getAccessReport(@RequestParam String org) {

        Map<String, Object> response = new HashMap<>();

        List<Map<String, Object>> users = new ArrayList<>();

        Map<String, Object> user1 = new HashMap<>();
        user1.put("username", "user1");
        user1.put("repositories", List.of("repo1", "repo2"));

        users.add(user1);

        response.put("organization", org);
        response.put("users", users);

        return response;
    }
}