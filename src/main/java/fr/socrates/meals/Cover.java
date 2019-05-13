package fr.socrates.meals;

public class Cover {
    private DietType dietType;

    public Cover(DietType dietType) {
        this.dietType = dietType;
    }

    boolean hasDietType(DietType dietType) {
        return this.dietType.equals(dietType);
    }
}
