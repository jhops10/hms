package com.jhops10.hms.domain.bill;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;

    @PostMapping
    public ResponseEntity<Bill> create(@RequestBody Bill bill) {
        return ResponseEntity.ok().body(billService.createBill(bill));
    }

    @GetMapping
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(billService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(billService.findBillById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bill> updateById(@PathVariable("id") Long id, @RequestBody BillUpdateDTO dto) {
        return ResponseEntity.ok().body(billService.updateBillById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        billService.deleteBillById(id);
        return ResponseEntity.noContent().build();
    }
}
