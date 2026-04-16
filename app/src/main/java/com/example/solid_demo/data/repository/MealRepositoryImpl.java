package com.example.solid_demo.data.repository;

import com.example.solid_demo.data.source.IMealDataSource;
import com.example.solid_demo.data.source.local.LocalMealDataSource;
import com.example.solid_demo.domain.models.Meal;
import com.example.solid_demo.domain.repository.IMealRepository;
import com.example.solid_demo.utils.Result;

import java.util.List;

/**
 * SOLID Principle: DIP (Dependency Inversion Principle)
 * This Repository is a "Pure Orchestrator". It does not depend on Mappers or DTOs.
 * It strictly depends on Abstractions (IMealDataSource) and Domain Models (Meal).
 *
 * SOLID Principle: SRP (Single Responsibility Principle)
 * Its only responsibility is to manage the Caching Strategy (Offline-first approach).
 */
public class MealRepositoryImpl implements IMealRepository {
    private final IMealDataSource remoteDataSource;
    private final LocalMealDataSource localDataSource;

    public MealRepositoryImpl(IMealDataSource remote, LocalMealDataSource local) {
        this.remoteDataSource = remote;
        this.localDataSource = local;
    }

    @Override
    public Result<List<Meal>> getMealsByCategory(String category) {
        try {
            // Check Local Cache first (Returns Domain Model)
            List<Meal> cache = localDataSource.getMeals(category);
            if (!cache.isEmpty()) {
                return Result.success(cache);
            }

            // Fetch from Remote (Returns Domain Model)
            List<Meal> remoteData = remoteDataSource.getMeals(category);

            // Persist to Cache
            localDataSource.saveToCache(remoteData);

            return Result.success(remoteData);
        } catch (Exception e) {
            return Result.failure("Architecture consistent error: " + e.getMessage());
        }
    }
}