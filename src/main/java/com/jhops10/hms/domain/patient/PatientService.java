package com.jhops10.hms.domain.patient;

import com.jhops10.hms.common.exceptions.PatientNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;


    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }


    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient findPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Paciente com o id " + id + " não encontrado."));
    }

    public Patient updatePatientById(Long id, PatientUpdateDTO dto) {
        Patient existingPatient = findPatientById(id);
        PatientUpdateDTO.updatePatientFromDTO(dto, existingPatient);
        return patientRepository.save(existingPatient);
    }

    public void deletePatientById(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Paciente com o id " + id + " não encontrado.");
        }

        patientRepository.deleteById(id);
    }

}
