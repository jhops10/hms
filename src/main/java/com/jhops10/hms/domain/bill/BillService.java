package com.jhops10.hms.domain.bill;

import com.jhops10.hms.common.exceptions.BillNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

    private final BillRepository billRepository;

    public Bill createBill(Bill bill) {
        return billRepository.save(bill);
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill findBillById(Long id) {
        return billRepository.findById(id)
                .orElseThrow(() -> new BillNotFoundException("Fatura com id " + id + " não encontrada."));

    }

    public Bill updateBillById(Long id, BillUpdateDTO dto) {
        Bill existingBill = findBillById(id);
        BillUpdateDTO.updateBillFromDTO(dto, existingBill);
        return billRepository.save(existingBill);
    }

    public void deleteBillById(Long id) {
        if (!billRepository.existsById(id)) {
            throw new BillNotFoundException("Fatura com id " + id + " não encontrada.");
        }

        billRepository.deleteById(id);
    }


}
