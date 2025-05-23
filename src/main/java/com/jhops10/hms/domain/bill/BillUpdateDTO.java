package com.jhops10.hms.domain.bill;

public record BillUpdateDTO(
        Long patientId,
        Double amount,
        String status
) {

    public static void updateBillFromDTO(BillUpdateDTO dto, Bill bill) {
        if (dto.patientId != null) {
            bill.setPatientId(dto.patientId);
        }

        if (dto.amount != null) {
            bill.setAmount(dto.amount);
        }

        if (dto.status != null) {
            bill.setStatus(dto.status);
        }
    }
}
