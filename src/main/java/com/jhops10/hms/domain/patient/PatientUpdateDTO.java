package com.jhops10.hms.domain.patient;

public record PatientUpdateDTO(
        String name,
        String gender,
        Integer age
) {

    public static void updatePatientFromDTO(PatientUpdateDTO dto, Patient patient) {
        if (dto.name != null) {
            patient.setName(dto.name);
        }

        if (dto.gender != null) {
            patient.setGender(dto.gender);
        }

        if (dto.age != null) {
            patient.setAge(dto.age);
        }
    }
}
