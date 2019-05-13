package fr.socrates.checkins;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class CheckIns {

    private final List<CheckIn> checkIns;

    public CheckIns(CheckIn... checkIns) {
        this.checkIns = Arrays.asList(checkIns);
    }

    public long countLateCheckinsForADay(LocalDateTime dateTime) {
        return this.checkIns.stream()
                .filter(checkIn -> checkIn.isConsideredLate(dateTime))
                .count();
    }
}
