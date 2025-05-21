package com.jhops10.hms.domain.doctor;

public record DoctorUpdateDTO(
        String name,
        String speciallity
) {

    public static void updateDoctorFromDTO(DoctorUpdateDTO dto, Doctor doctor) {
        if (dto.name != null) {
            doctor.setName(dto.name);
        }

        if (dto.speciallity != null) {
            doctor.setSpeciallity(dto.speciallity);
        }
    }
}
