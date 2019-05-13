package fr.socrates;

import fr.socrates.meals.*;

import java.util.ArrayList;
import java.util.List;

public class DemoMeals {
    public static void main(String[] args) {
        List<Cover> covers = new ArrayList<>();
        covers.add(new Cover(DietType.VEGETARIAN));
        covers.add(new Cover(DietType.VEGETARIAN));
        covers.add(new Cover(DietType.VEGETARIAN));
        covers.add(new Cover(DietType.VEGAN));
        covers.add(new Cover(DietType.VEGAN));
        covers.add(new Cover(DietType.VEGAN));
        covers.add(new Cover(DietType.VEGETARIAN));
        covers.add(new Cover(DietType.PESCATARIAN));
        covers.add(new Cover(DietType.PESCATARIAN));
        covers.add(new Cover(DietType.PESCATARIAN));
        covers.add(new Cover(DietType.OMNIVOROUS));

        Meal meal = new Meal(covers, MealTime.MEAL1);
        Meals meals = new Meals(meal);

        MealRepartitions repartitions = meals.generateMealsRepartitions();
        System.out.println(repartitions);
        System.out.println(repartitions.getTotalCoverForDiet(DietType.VEGETARIAN));
        System.out.println(repartitions.getTotalCoverForDiet(DietType.OMNIVOROUS));
        System.out.println(repartitions.getTotalCoverForDiet(DietType.PESCATARIAN));
        System.out.println(repartitions.getTotalCoverForDiet(DietType.VEGAN));
    }
}
