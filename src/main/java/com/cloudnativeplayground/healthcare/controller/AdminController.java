package com.cloudnativeplayground.healthcare.controller;

import com.cloudnativeplayground.healthcare.service.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/assign-role")
    public ResponseEntity<String> assignRole(@RequestParam Long userId, @RequestParam String role) {
        adminService.assignRole(userId, role);
        return ResponseEntity.ok("Role assigned successfully.");
    }
}
