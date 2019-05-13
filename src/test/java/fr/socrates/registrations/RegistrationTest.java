package fr.socrates.registrations;

import fr.socrates.SocratesEvent;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest {

    private static final LocalDateTime dateTimeLimitFirstMealService = LocalDateTime.of(2019, 4, 18, 21, 0);
    private static final LocalDateTime dateTimeStartLastMealService = LocalDateTime.of(2019, 4, 21, 12, 0);
    private SocratesEvent socratesEvent = new SocratesEvent(dateTimeLimitFirstMealService, dateTimeStartLastMealService, 40, 6);

    @Test
    public void single_room_with_all_meals() {
        Registration registration = new Registration(Room.SINGLE, dateTimeLimitFirstMealService.minusHours(3), socratesEvent);
        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.SINGLE.price + socratesEvent.getMealPrice() * socratesEvent.getMealNumber());
    }

    @Test
    public void double_room_with_all_meals() {
        Registration registration = new Registration(Room.DOUBLE, dateTimeLimitFirstMealService.minusHours(2), socratesEvent);

        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.DOUBLE.price + socratesEvent.getMealPrice() * socratesEvent.getMealNumber());
    }

    @Test
    public void triple_room_with_all_meals() {
        Registration registration = new Registration(Room.TRIPLE, dateTimeLimitFirstMealService.minusHours(1), socratesEvent);

        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.TRIPLE.price + socratesEvent.getMealPrice() * socratesEvent.getMealNumber());
    }

    @Test
    public void no_room_with_all_meals() {
        Registration registration = new Registration(Room.NONE, dateTimeLimitFirstMealService.minusHours(1), socratesEvent);

        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.NONE.price + socratesEvent.getMealPrice() * socratesEvent.getMealNumber());
    }

    @Test
    public void arrive_first_day_after_date_limit_first_meal_service_remove_first_meal() {
        Registration registration = new Registration(Room.SINGLE, dateTimeLimitFirstMealService.plusHours(1), socratesEvent);

        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.SINGLE.price + (240 - socratesEvent.getMealPrice() * 1));
    }

    @Test
    public void checkout_before_last_meal_start_time_remove_last_meal() {

        Registration registration = new Registration(Room.SINGLE, dateTimeLimitFirstMealService.minusHours(2), dateTimeStartLastMealService.minusHours(1), socratesEvent);

        int totalPrice = registration.calculateRegistrationPrice();

        assertThat(totalPrice).isEqualTo(Room.SINGLE.price + (240 - socratesEvent.getMealPrice() * 1));
    }
}
