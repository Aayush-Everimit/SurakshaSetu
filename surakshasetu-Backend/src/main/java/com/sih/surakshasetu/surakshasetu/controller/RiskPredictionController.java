package com.sih.surakshasetu.controller;

import com.sih.surakshasetu.dto.RiskPredictionDTO;
import com.sih.surakshasetu.service.RiskPredictionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/risk-predictions")
public class RiskPredictionController {

    private final RiskPredictionService riskPredictionService;

    public RiskPredictionController(RiskPredictionService riskPredictionService) {
        this.riskPredictionService = riskPredictionService;
    }

    @GetMapping
    public ResponseEntity<List<RiskPredictionDTO>> getAll() {
        return ResponseEntity.ok(riskPredictionService.getAllRiskPredictions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskPredictionDTO> getById(@PathVariable Long id) {
        RiskPredictionDTO dto = riskPredictionService.getRiskPredictionById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<RiskPredictionDTO> create(@RequestBody RiskPredictionDTO dto) {
        return ResponseEntity.ok(riskPredictionService.createRiskPrediction(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskPredictionDTO> update(@PathVariable Long id, @RequestBody RiskPredictionDTO dto) {
        RiskPredictionDTO updated = riskPredictionService.updateRiskPrediction(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }
}
