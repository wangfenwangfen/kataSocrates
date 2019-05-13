package fr.socrates.checkins;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ColdMealTest {
    private static final LocalDateTime COLD_MEALS_START = LocalDateTime.of(2019, 4, 18, 21, 0);

    @Test
    public void zero_participant_return_zero_cold_meal() {
        CheckIns checkIns = new CheckIns();

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void one_participant_without_checkIn_date_return_zero() {
        CheckIns checkIns = new CheckIns(new CheckIn());

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void one_participant_after_cold_meals_start_time_return_one() {
        CheckIns checkIns = new CheckIns(new CheckIn(COLD_MEALS_START.plusHours(1)));

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void two_participant_after_cold_meals_start_time_return_two() {
        CheckIns checkIns = new CheckIns(
                new CheckIn(COLD_MEALS_START.plusHours(1)),
                new CheckIn(COLD_MEALS_START.plusHours(2))
        );

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void one_participant_before_cold_meals_start_time_return_zero() {
        CheckIns checkIns = new CheckIns(new CheckIn(COLD_MEALS_START.minusHours(3)));

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void one_participant_after_the_cold_meals_end_day_return_0() {
        CheckIns checkIns = new CheckIns(new CheckIn(COLD_MEALS_START.plusDays(1).plusHours(1)));

        long result = checkIns.countLateCheckinsForADay(COLD_MEALS_START);

        assertThat(result).isEqualTo(0);
    }
}
