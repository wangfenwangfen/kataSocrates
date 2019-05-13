package fr.socrates.meals;

import java.util.List;

public class Meal {
    private List<Cover> covers;
    private MealTime mealTime;

    public Meal(List<Cover> covers, MealTime mealTime) {
        this.covers = covers;
        this.mealTime = mealTime;
    }

    long countForDiet(DietType dietType) {
        return this.covers.stream().filter(cover -> cover.hasDietType(dietType)).count();
    }

    boolean isMeal(MealTime mealTime) {
        return this.mealTime.equals(mealTime);
    }
}
