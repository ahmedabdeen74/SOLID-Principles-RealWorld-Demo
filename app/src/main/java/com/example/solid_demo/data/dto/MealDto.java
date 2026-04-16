package com.example.solid_demo.data.dto;

/**
 * SOLID Principle: SRP (Single Responsibility Principle)
 * This is a "Data Transfer Object" (DTO). It mirrors the schema of the external
 * data source (JSON/SQL). It is kept separate from the Domain to prevent
 * external changes from leaking into the business logic.
 */
public class MealDto {
    public String idMeal;
    public String strMeal;
    public String strMealThumb;
}
