package fr.socrates;

import java.time.LocalDateTime;

public class SocratesEvent {
    private LocalDateTime dateTimeLimitFirstMealService;
    private LocalDateTime dateTimeStartLastMealService;
    private int mealPrice;
    private int defaultMealsNumber;

    public SocratesEvent(LocalDateTime dateTimeLimitFirstMealService, LocalDateTime dateTimeStartLastMealService, int mealPrice, int defaultMealsNumber) {
        this.dateTimeStartLastMealService = dateTimeStartLastMealService;
        this.dateTimeLimitFirstMealService = dateTimeLimitFirstMealService;
        this.mealPrice = mealPrice;
        this.defaultMealsNumber = defaultMealsNumber;
    }

    public LocalDateTime getDateTimeLimitFirstMealService() {
        return dateTimeLimitFirstMealService;
    }

    public int getMealNumber() {
        return defaultMealsNumber;
    }

    public int getMealPrice() {
        return mealPrice;
    }

    public int calculateTotalPrice(int mealsNumber) {
        return mealsNumber * mealPrice;
    }

    public LocalDateTime getDateTimeStartLastMealService() {
        return dateTimeStartLastMealService;
    }
}
