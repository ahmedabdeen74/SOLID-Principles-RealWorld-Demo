# SOLID Principles & Clean Architecture: Real-World Meal App Demo 🍽️

[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com/)
[![Architecture](https://img.shields.io/badge/Architecture-Clean%20Architecture-blue.svg)]()
[![Principles](https://img.shields.io/badge/Principles-SOLID-green.svg)]()

## 📌 Overview

Most SOLID principle tutorials use abstract and oversimplified examples like `Animal` or `Shape`. While these are good for beginners, they often fail to demonstrate how these principles apply to professional, scalable Android/Java applications.

This repository provides a **Real-World Demo** of a Meal Discovery App. It demonstrates how to structure a project using **Clean Architecture** while strictly adhering to **SOLID Principles** to achieve maximum decoupling, testability, and maintainability.

---

## 🛠️ Key Architectural Concepts

This demo focuses on the interaction between layers and how SOLID principles solve common development bottlenecks:

### 1. Single Responsibility Principle (SRP)
* **Mappers:** Dedicated classes (`MealMapper`) handle data transformation, keeping repositories and data sources focused on their primary tasks.
* **DTOs vs. Entities:** Separation between `MealDto` (data layer) and `Meal` (domain entity) ensures that API changes don't leak into business logic.

### 2. Open/Closed Principle (OCP)
* The system is open for extension but closed for modification. New data sources (e.g., adding a Firebase source) can be integrated by implementing existing interfaces without changing the Repository logic.

### 3. Liskov Substitution Principle (LSP)
* The Repository treats all `IMealDataSource` implementations uniformly. Whether data comes from a Remote API or Local Database, the behavior remains consistent and predictable.

### 4. Interface Segregation Principle (ISP)
* Interfaces are kept lean and specific. Components only depend on the methods they actually use, preventing "Fat Interfaces."

### 5. Dependency Inversion Principle (DIP)
* High-level modules (ViewModel/Repository) depend on abstractions (Interfaces), not on low-level details (Retrofit/Room). This makes the code **100% Testable** with Mocks.

---

## 🏗️ Project Structure

```text
com.example.solid_demo
├── data
│   ├── dto            # Data Transfer Objects (Schema)
│   ├── mapper         # Data Transformation Logic (SRP)
│   ├── repository     # Implementation of Domain Repository
│   └── source         # Remote & Local Data Sources (OCP/LSP)
├── domain
│   ├── models         # Pure Business Entities
│   └── repository     # Abstractions/Contracts (DIP)
├── presentation       # UI Logic / ViewModels (DIP)
└── utils              # Reusable Wrappers (Result State)
