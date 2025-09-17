package com.sih.surakshasetu.controller;

import com.sih.surakshasetu.dto.EfirDTO;
import com.sih.surakshasetu.service.EfirService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/efir")
public class EfirController {

    private final EfirService efirService;

    public EfirController(EfirService efirService) {
        this.efirService = efirService;
    }

    @GetMapping
    public ResponseEntity<List<EfirDTO>> getAllEfirRecords() {
        return ResponseEntity.ok(efirService.getAllEfirRecords());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EfirDTO> getEfirById(@PathVariable Long id) {
        EfirDTO dto = efirService.getEfirById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EfirDTO> createEfir(@RequestBody EfirDTO efirDTO) {
        return ResponseEntity.ok(efirService.createEfir(efirDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EfirDTO> updateEfir(@PathVariable Long id, @RequestBody EfirDTO efirDTO) {
        EfirDTO updated = efirService.updateEfir(id, efirDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }
}
