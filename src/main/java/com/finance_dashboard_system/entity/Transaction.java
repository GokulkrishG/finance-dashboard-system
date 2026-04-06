package com.finance_dashboard_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Amount is required")
    @Positive(message = "Given value is greater than 0")
    private Double amount;

    @NotNull(message = "Type is required")
    private String type;

    @NotBlank(message = "Category must not be empty")
    private String category;
    private LocalDate date;

    @NotBlank(message = "Description cannot be empty")
    private String description;
}
