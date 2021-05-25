package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime birthday;
    private final String favouriteFood;
    private final String colour;


    private Dog(String name, String breed, LocalDateTime birthday, String favouriteFood, String colour) {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.favouriteFood = favouriteFood;
        this.colour = colour;
    }


    public String getName(){
        return name;
    }

    public String getBreed(){
        return breed;
    }

    public LocalDateTime getDateOfBirth(){
        return birthday;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getColour() {
        return colour;
    }

    public static WithBreed called(String name) {
        return new DogBuilder(name);
    }

    interface WithBreed{
        OfColour ofBreed(String breed);
    }

    interface OfColour{
        DogBuilder ofColour(String colour);
    }


    public static class DogBuilder implements WithBreed, OfColour {

        private String name;
        private String breed;
        private LocalDateTime birthday;
        private String favouriteFood;
        private String colour;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDateTime birthday) {
            return new Dog(name,breed, birthday,favouriteFood,colour);
        }

        public DogBuilder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public DogBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }
    }
}
