package fr.socrates.registrations;

import fr.socrates.SocratesEvent;

import java.time.LocalDateTime;

class Registration {
    private SocratesEvent socratesEvent;
    private Room room;
    private LocalDateTime checkInDateTime;
    private LocalDateTime checkOutDateTime;

    Registration(Room room, LocalDateTime checkInDateTime, SocratesEvent socratesEvent) {
        this.room = room;
        this.socratesEvent = socratesEvent;
        this.checkInDateTime = checkInDateTime;
    }

    Registration(Room room, LocalDateTime checkInDateTime, LocalDateTime checkOutDateTime, SocratesEvent socratesEvent) {
        this.socratesEvent = socratesEvent;
        this.room = room;
        this.checkInDateTime = checkInDateTime;
        this.checkOutDateTime = checkOutDateTime;
    }

    int calculateRegistrationPrice() {
        return room.price + calculateTotalMealsPrice();
    }

    private int calculateTotalMealsPrice() {
        int mealsNumber = socratesEvent.getMealNumber();

        if (checkOutDateTime != null && checkOutDateTime.isBefore(socratesEvent.getDateTimeStartLastMealService())) {
            mealsNumber--;
        }

        if (checkInDateTime.isEqual(socratesEvent.getDateTimeLimitFirstMealService())) {
            mealsNumber--;
        }

        if (checkInDateTime.isAfter(socratesEvent.getDateTimeLimitFirstMealService())) {
            mealsNumber--;
        }
        return this.socratesEvent.calculateTotalPrice(mealsNumber);
    }
}
