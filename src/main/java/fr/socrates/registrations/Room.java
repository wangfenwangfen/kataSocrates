package fr.socrates.registrations;

public enum Room {
    SINGLE(610),
    DOUBLE(510),
    TRIPLE(410),
    NONE(240);

    final int price;

    Room(int price) {
        this.price = price;
    }
}
