package com.jhops10.hms.domain.patient;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(patient));
    }

    @GetMapping
    public ResponseEntity<List<Patient>> getAll() {
        return ResponseEntity.ok().body(patientService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(patientService.findPatientById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updateById(@PathVariable("id") Long id, @RequestBody PatientUpdateDTO dto) {
        return ResponseEntity.ok().body(patientService.updatePatientById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }
}
