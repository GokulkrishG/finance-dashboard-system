package com.finance_dashboard_system.service;

import com.finance_dashboard_system.entity.Transaction;
import com.finance_dashboard_system.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repo;
    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public Transaction save(Transaction t) {
        return repo.save(t);
    }

    public List<Transaction> getAll() {
        return repo.findAll();
    }

    public Transaction update(Long id, Transaction t) {
        Transaction existing = repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Transaction not found"));

        existing.setAmount(t.getAmount());
        existing.setType(t.getType());
        existing.setCategory(t.getCategory());
        existing.setDate(t.getDate());
        existing.setDescription(t.getDescription());

        return repo.save(existing);
    }

    public void delete(Long id) {
        Transaction existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        repo.delete(existing);
    }


    public Double getTotalIncome() {
        return repo.getTotalIncome();
    }

    public Double getTotalExpense() {
        return repo.getTotalExpense();
    }

    public Double getNetBalance() {
        Double income = repo.getTotalIncome();
        Double expense = repo.getTotalExpense();

        if (income == null) income = 0.0;
        if (expense == null) expense = 0.0;

        return income - expense;
    }

    public List<Object[]> getCategoryTotals() {
        return repo.getCategoryTotals();
    }

    public List<Transaction> getRecentTransactions() {
        return repo.findTop5ByOrderByDateDesc();
    }
}