package fr.socrates.meals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CountDietTest {

    private Cover pescatarian = new Cover(DietType.PESCATARIAN);
    private Cover vegan = new Cover(DietType.VEGAN);
    private Cover vegetarian = new Cover(DietType.VEGETARIAN);
    private Cover omnivorous = new Cover(DietType.OMNIVOROUS);

    @Test
    public void one_vegetarian_in_one_meal_should_return_one_vegetarian() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegetarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long vegetarianCoverCount = meal.countForDiet(DietType.VEGETARIAN);

        long vegetarianMealExpectedCount = 1;
        assertThat(vegetarianCoverCount).isEqualTo(vegetarianMealExpectedCount);
    }

    @Test
    public void one_vegetarian_and_one_no_vegetarian_in_one_meal_should_return_one_vegetarian() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegetarian);
        covers.add(pescatarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long vegetarianCoverCount = meal.countForDiet(DietType.VEGETARIAN);

        long vegetarianMealExpectedCount = 1;
        assertThat(vegetarianCoverCount).isEqualTo(vegetarianMealExpectedCount);
    }

    @Test
    public void two_vegetarian_and_one_no_vegetarian_in_one_meal_should_return_2() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegetarian);
        covers.add(vegetarian);
        covers.add(pescatarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long vegetarianCoverCount = meal.countForDiet(DietType.VEGETARIAN);

        long vegetarianMealExpectedCount = 2;
        assertThat(vegetarianCoverCount).isEqualTo(vegetarianMealExpectedCount);
    }

    @Test
    public void one_pescatarian_in_one_meal_should_return_one() {
        List<Cover> covers = new ArrayList<>();
        covers.add(pescatarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long pescatarianCoverCount = meal.countForDiet(DietType.PESCATARIAN);

        long pescatarianCoverCountExpected = 1;
        assertThat(pescatarianCoverCount).isEqualTo(pescatarianCoverCountExpected);
    }

    @Test
    public void two_pescatarian_and_one_vegetarian_in_one_meal_should_return_2() {
        List<Cover> covers = new ArrayList<>();
        covers.add(pescatarian);
        covers.add(pescatarian);
        covers.add(vegetarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long pescatarianCoverCount = meal.countForDiet(DietType.PESCATARIAN);

        long pescatarianCoverCountExpected = 2;
        assertThat(pescatarianCoverCount).isEqualTo(pescatarianCoverCountExpected);
    }

    @Test
    public void one_vegan_in_one_meal_should_return_one() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegan);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long veganCoverCount = meal.countForDiet(DietType.VEGAN);

        long veganCoverCountExpected = 1;
        assertThat(veganCoverCount).isEqualTo(veganCoverCountExpected);
    }

    @Test
    public void two_vegan_and_2_pescatarian_in_one_meal_should_return_2() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegan);
        covers.add(vegan);
        covers.add(pescatarian);
        covers.add(pescatarian);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long veganCoverCount = meal.countForDiet(DietType.VEGAN);

        long veganCoverCountExpected = 2;
        assertThat(veganCoverCount).isEqualTo(veganCoverCountExpected);
    }

    @Test
    public void one_omnivorous_in_one_meal_should_return_1() {
        List<Cover> covers = new ArrayList<>();
        covers.add(omnivorous);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long omnivorousCoverCount = meal.countForDiet(DietType.OMNIVOROUS);

        long omnivorousCoverCountExpected = 1;
        assertThat(omnivorousCoverCount).isEqualTo(omnivorousCoverCountExpected);
    }

    @Test
    public void three_omnivorous_and_one_vegan_in_one_meal_should_return_three() {
        List<Cover> covers = new ArrayList<>();
        covers.add(omnivorous);
        covers.add(omnivorous);
        covers.add(omnivorous);
        covers.add(vegan);
        Meal meal = new Meal(covers, MealTime.MEAL1);

        long omnivorousCoverCount = meal.countForDiet(DietType.OMNIVOROUS);

        long omnivorousCoverCountExpected = 3;
        assertThat(omnivorousCoverCount).isEqualTo(omnivorousCoverCountExpected);
    }

    @Test
    public void two_meals_with_one_vegetarian_in_each_should_return_two_vegetarian_meals_for_the_event() {
        List<Cover> covers = new ArrayList<>();
        covers.add(vegetarian);
        Meal meal1 = new Meal(covers, MealTime.MEAL1);
        Meal meal2 = new Meal(covers, MealTime.MEAL2);
        Meals meals = new Meals(meal1, meal2);

        MealRepartitions repartitions = meals.generateMealsRepartitions();
        long vegetarianCoverCountInMeal = repartitions.getTotalCoverForDiet(DietType.VEGETARIAN);

        long vegetarianMealCountExpected = 2;
        assertThat(vegetarianCoverCountInMeal).isEqualTo(vegetarianMealCountExpected);
    }

    @Test
    public void one_meal_with_one_vegetarian_and_one_meal_with_no_vegetarian_cover_should_return_one_vegetarian_meal_for_the_event() {
        List<Cover> covers1 = new ArrayList<>();
        List<Cover> covers2 = new ArrayList<>();
        covers1.add(vegetarian);
        covers1.add(omnivorous);
        covers2.add(vegan);
        covers2.add(pescatarian);

        Meal meal1 = new Meal(covers1, MealTime.MEAL1);
        Meal meal2 = new Meal(covers2, MealTime.MEAL2);
        Meals meals = new Meals(meal1, meal2);
        MealRepartitions repartitions = meals.generateMealsRepartitions();
        long vegetarianCoversCountInMeals = repartitions.getTotalCoverForDiet(DietType.VEGETARIAN);

        long vegetarianCoversCountInMealsExpected = 1;
        assertThat(vegetarianCoversCountInMeals).isEqualTo(vegetarianCoversCountInMealsExpected);
    }

    @Test
    public void it_should_return_the_cover_count_for_a_chosen_diet_and_a_chosen_meal() {
        List<Cover> covers1 = new ArrayList<>();
        covers1.add(vegan);
        covers1.add(vegan);
        covers1.add(vegetarian);
        covers1.add(omnivorous);

        Meal meal1 = new Meal(covers1, MealTime.MEAL1);
        Meals meals = new Meals(meal1);

        MealRepartitions repartitions = meals.generateMealsRepartitions();

        long vegetarianCoverCountForMealOne = repartitions.getTotalCoverForMealAndDiet(MealTime.MEAL1, DietType.VEGETARIAN);
        long vegetarianCoverCountForMealOneExpected = 1;
        assertThat(vegetarianCoverCountForMealOne).isEqualTo(vegetarianCoverCountForMealOneExpected);
    }
}
