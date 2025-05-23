package com.jhops10.hms.domain.appointment;

import com.jhops10.hms.common.exceptions.AppointmentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    public Appointment findAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Consulta com id " + id + " não encontrada."));
    }

    public Appointment updateAppointmentById(Long id, AppointmentUpdateDTO dto) {
        Appointment existingAppointment = findAppointmentById(id);
        AppointmentUpdateDTO.updateAppointmentFromDTO(dto, existingAppointment);
        return appointmentRepository.save(existingAppointment);
    }

    public void deleteAppointmentById(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new AppointmentNotFoundException("Consulta com id " + id + " não encontrada.");
        }
        appointmentRepository.deleteById(id);
    }
}
