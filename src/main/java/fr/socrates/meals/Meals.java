package fr.socrates.meals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Meals {
    private final List<Meal> meals;

    public Meals(Meal... meals) {
        this.meals = Arrays.asList(meals);
    }

    public MealRepartitions generateMealsRepartitions() {
        List<MealRepartition> repartitions = new ArrayList<>();

        for (Meal meal : meals) {
            MealRepartition repartition = MealRepartition.generateRepartitionForMeal(meal);
            repartitions.add(repartition);
        }

        return new MealRepartitions(repartitions);
    }
}
