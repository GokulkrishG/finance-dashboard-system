package com.finance_dashboard_system.repository;

import com.finance_dashboard_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}