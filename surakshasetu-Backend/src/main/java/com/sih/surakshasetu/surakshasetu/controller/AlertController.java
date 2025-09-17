package com.sih.surakshasetu.surakshasetu.controller;

import com.sih.surakshasetu.surakshasetu.service.AlertService;
import com.sih.surakshasetu.surakshasetu.dto.AlertDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping
    public ResponseEntity<List<AlertDTO>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDTO> getAlertById(@PathVariable Long id) {
        AlertDTO alertDTO = alertService.getAlertById(id);
        if (alertDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(alertDTO);
    }

    @PostMapping
    public ResponseEntity<AlertDTO> createAlert(@RequestBody AlertDTO alertDTO) {
        AlertDTO createdAlert = alertService.createAlert(alertDTO);
        return ResponseEntity.ok(createdAlert);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlertDTO> updateAlert(@PathVariable Long id, @RequestBody AlertDTO alertDTO) {
        AlertDTO updatedAlert = alertService.updateAlert(id, alertDTO);
        if (updatedAlert == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedAlert);
    }
}
