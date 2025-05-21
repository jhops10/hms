package com.jhops10.hms.domain.doctor;

import com.jhops10.hms.common.exceptions.DoctorNotFouunudException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    private List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    private Doctor findDoctorById(Long id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFouunudException("Médico com o id " + id + " não encontrado."));
    }

    private Doctor updateDoctorById(Long id, DoctorUpdateDTO dto) {
        Doctor existingDoctor = findDoctorById(id);
        DoctorUpdateDTO.updateDoctorFromDTO(dto, existingDoctor);
        return doctorRepository.save(existingDoctor);
    }

    private void deleteDoctorById(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new DoctorNotFouunudException("Médico com o id " + id + " não encontrado.");
        }

        doctorRepository.deleteById(id);
    }
}
