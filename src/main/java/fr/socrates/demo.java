package fr.socrates;

import fr.socrates.checkins.CheckIn;
import fr.socrates.checkins.CheckIns;

import java.time.LocalDateTime;
import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(2019, 2, 2, 21, 0);

        CheckIn[] participants2 = {
                new CheckIn(),
                new CheckIn(start.minusHours(1)),
                new CheckIn(start.plusHours(1)),
                new CheckIn(start.plusDays(1).plusHours(1))
        };
        CheckIns checkins = new CheckIns(participants2);

        System.out.println("Participants :");
        Arrays.stream(participants2).forEach(System.out::println);
        System.out.println("Nombre de plats froids : " + checkins.countLateCheckinsForADay(start));
    }
}
