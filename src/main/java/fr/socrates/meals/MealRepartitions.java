package fr.socrates.meals;

import java.util.List;

public class MealRepartitions {
    private List<MealRepartition> repartitions;

    MealRepartitions(List<MealRepartition> repartitions) {
        this.repartitions = repartitions;
    }

    public long getTotalCoverForDiet(DietType type) {
        return repartitions.stream().mapToLong(repartition -> repartition.getCoverCountForDiet(type)).sum();
    }

    long getTotalCoverForMealAndDiet(MealTime mealTime, DietType dietType) {
        return repartitions.stream()
                .filter(repartition -> repartition.isForMeal(mealTime))
                .mapToLong(repartition -> repartition.getCoverCountForDiet(dietType))
                .sum();
    }
}
