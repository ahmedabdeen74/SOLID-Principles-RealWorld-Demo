package com.example.solid_demo.domain.repository;




import com.example.solid_demo.domain.models.Meal;
import com.example.solid_demo.utils.Result;

import java.util.List;

/**
 * SOLID Principle: DIP (Dependency Inversion Principle)
 * This interface allows the Presentation Layer (ViewModel) to request data
 * without knowing anything about the Data Layer implementations.
 *
 * SOLID Principle: ISP (Interface Segregation Principle)
 * Clients depend only on methods they actually use (Meal operations).
 */
public interface IMealRepository {
    Result<List<Meal>> getMealsByCategory(String category);
}
