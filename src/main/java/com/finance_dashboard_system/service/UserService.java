package com.finance_dashboard_system.service;

import com.finance_dashboard_system.entity.User;
import com.finance_dashboard_system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User create(User user) {
        user.setActive(true);
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }

    public User getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User update(Long id, User user) {
        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setPassword(user.getPassword());
        existing.setRole(user.getRole());
        existing.setActive(user.isActive());

        return repo.save(existing);
    }

    public void delete(Long id) {
        User existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        repo.delete(existing);
    }
}