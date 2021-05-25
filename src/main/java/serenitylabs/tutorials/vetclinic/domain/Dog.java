package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime birthday;
    private String favouriteFood;

    public Dog(String name, String breed, LocalDateTime birthday) {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
    }

    public Dog(String name, String breed, LocalDateTime birthday, String favouriteFood) {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
        this.favouriteFood = favouriteFood;
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

    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {

        private String name;
        private String breed;
        private LocalDateTime birthday;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOn(LocalDateTime birthday) {
            return new Dog(name,breed, birthday);
        }
    }
}
