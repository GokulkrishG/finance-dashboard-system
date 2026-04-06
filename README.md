# 💰 Finance Dashboard System

## 📌 Overview

This project is a backend system built using Spring Boot for managing financial transactions with role-based access control and dashboard analytics.

It allows different users (ADMIN, ANALYST, VIEWER) to interact with financial data based on permissions.

---

## ⚙️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

---

## 🔐 User Roles

* **ADMIN**
  * Create, update, delete transactions
  * Manage users

* **ANALYST**

  * View transactions
  * Access dashboard insights

* **VIEWER**

  * View only

---

## 💸 Transaction Features

* Create transactions
* View all transactions
* Update transactions
* Delete transactions
* Filter-ready structure

---

## 📊 Dashboard APIs

* Total Income
* Total Expense
* Net Balance
* Category-wise totals
* Recent transactions

---

## ⚠️ Validation & Error Handling

* Input validation using annotations
* Proper HTTP status codes (403, 404)
* Clean error messages

---

## 🗄️ Data Persistence

* Uses PostgreSQL as relational database
* Spring Data JPA for ORM
* Data persists across application restarts

---

## 🚀 API Endpoints

### Transactions

* `POST /transactions?role=ADMIN`
* `GET /transactions`
* `PUT /transactions/{id}?role=ADMIN`
* `DELETE /transactions/{id}?role=ADMIN`

### Dashboard

* `GET /dashboard/income`
* `GET /dashboard/expense`
* `GET /dashboard/balance`
* `GET /dashboard/category`
* `GET /dashboard/recent`

---

## ▶️ How to Run

1. Configure PostgreSQL in `application.xml`
2. Run the Spring Boot application
3. Use Postman to test APIs

---

## ⚠️ Assumptions

* Role is passed as request parameter (simplified authentication)
* Focus is on backend logic and design

