package fr.socrates.meals;

import java.util.HashMap;
import java.util.Map;

class MealRepartition {
    private final Meal meal;
    private Map<DietType, Long> repartition;

    private MealRepartition(Meal meal, Map<DietType, Long> repartition) {
        this.meal = meal;
        this.repartition = repartition;
    }

    static MealRepartition generateRepartitionForMeal(Meal meal) {
        Map<DietType, Long> repartition = new HashMap<>();

        for (DietType type : DietType.values()) {
            repartition.put(type, meal.countForDiet(type));
        }

        return new MealRepartition(meal, repartition);
    }

    long getCoverCountForDiet(DietType dietType) {
        return repartition.get(dietType);
    }

    boolean isForMeal(MealTime mealTime) {
        return meal.isMeal(mealTime);
    }
}
