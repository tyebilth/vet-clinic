package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {

    private final String name;
    private final String breed;
    private final LocalDateTime birthday;
    private final String favouriteFood;
    private final String colour;


    public Dog(String name, String breed, LocalDateTime birthday, String favouriteFood, String colour) {
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


}
