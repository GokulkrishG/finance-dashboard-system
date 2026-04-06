package com.finance_dashboard_system.controller;

import com.finance_dashboard_system.entity.Transaction;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.finance_dashboard_system.service.TransactionService;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping
    public Transaction create(@Valid @RequestBody Transaction t,
                              @RequestParam String role) {

        if (!role.equals("ADMIN")) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Only ADMIN can create transactions"
            );
        }

        return service.save(t);
    }

    @GetMapping
    public List<Transaction> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Transaction update(@PathVariable Long id,
                              @RequestBody Transaction t,
                              @RequestParam String role) {

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Only ADMIN can update");
        }
        return service.update(id, t);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id,
                         @RequestParam String role) {

        if (!role.equals("ADMIN")) {
            throw new RuntimeException("Only ADMIN can delete");
        }
        service.delete(id);
        return "Deleted successfully";
    }
}