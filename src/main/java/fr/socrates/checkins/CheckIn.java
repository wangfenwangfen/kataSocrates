package fr.socrates.checkins;

import java.time.LocalDateTime;
import java.util.Optional;

public class CheckIn {

    private final Optional<LocalDateTime> checkInDateTime;

    public CheckIn(LocalDateTime checkInDate) {
        this.checkInDateTime = Optional.of(checkInDate);
    }

    public CheckIn() {
        this.checkInDateTime = Optional.empty();
    }

    boolean isConsideredLate(LocalDateTime latenessDeadLine) {
        LocalDateTime actualCheckInDateTime = checkInDateTime.orElse(LocalDateTime.MIN);

        return latenessDeadLine.toLocalDate().isEqual(actualCheckInDateTime.toLocalDate())
                && actualCheckInDateTime.isAfter(latenessDeadLine);
    }

    @Override
    public String toString() {
        return "CheckIn{" +
                "checkInDateTime=" + checkInDateTime +
                '}';
    }
}