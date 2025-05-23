package com.jhops10.hms.domain.appointment;

public record AppointmentUpdateDTO(
        Long patientId,
        Long doctorId,
        String date
) {

    public static void updateAppointmentFromDTO(AppointmentUpdateDTO dto, Appointment appointment) {
        if (dto.patientId != null) {
            appointment.setPatientId(dto.patientId);
        }

        if (dto.doctorId != null) {
            appointment.setDoctorId(dto.doctorId);
        }

        if (dto.date != null) {
            appointment.setDate(dto.date);
        }
    }
}
