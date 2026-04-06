package com.finance_dashboard_system.controller;

import com.finance_dashboard_system.entity.Transaction;
import com.finance_dashboard_system.service.TransactionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final TransactionService service;
    public DashboardController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/income")
    public Double totalIncome() {
        return service.getTotalIncome();
    }

    @GetMapping("/expense")
    public Double totalExpense() {
        return service.getTotalExpense();
    }

    @GetMapping("/balance")
    public Double netBalance() {
        return service.getNetBalance();
    }

    @GetMapping("/category")
    public List<Object[]> categoryTotals() {
        return service.getCategoryTotals();
    }

    @GetMapping("/recent")
    public List<Transaction> recent() {
        return service.getRecentTransactions();
    }
}