package com.example.solid_demo.data.source;

import com.example.solid_demo.domain.models.Meal;

import java.util.List;

/**
 * SOLID Principle: OCP (Open/Closed Principle) & LSP (Liskov Substitution Principle)
 * A unified contract for all data sources. Whether remote or local, they must
 * return Domain Models (Meal) to ensure architectural consistency across the app.
 */
public interface IMealDataSource {
    List<Meal> getMeals(String category);
}