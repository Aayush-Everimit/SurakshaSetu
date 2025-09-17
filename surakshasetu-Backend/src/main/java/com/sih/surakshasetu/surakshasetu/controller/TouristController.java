package com.sih.surakshasetu.surakshasetu.controller;

import com.sih.surakshasetu.surakshasetu.dto.TouristDTO;
import com.sih.surakshasetu.surakshasetu.service.TouristService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tourists")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<TouristDTO>> getAllTourists() {
        return ResponseEntity.ok(touristService.getAllTourists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TouristDTO> getTouristById(@PathVariable Long id) {
        Optional<TouristDTO> touristOpt = touristService.getTouristById(id);
        return touristOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<TouristDTO> registerTourist(@RequestBody TouristDTO touristDTO) {
        TouristDTO created = touristService.registerTourist(touristDTO);
        return ResponseEntity.ok(created);
    }
}
