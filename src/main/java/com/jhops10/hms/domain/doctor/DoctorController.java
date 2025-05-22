package com.jhops10.hms.domain.doctor;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.createDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAll() {
        return ResponseEntity.ok().body(doctorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(doctorService.findDoctorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateById(@PathVariable("id") Long id, DoctorUpdateDTO dto) {
        return ResponseEntity.ok().body(doctorService.updateDoctorById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }


}
