package serenitylabs.tutorials.vetclinic.model;

import com.google.common.collect.Maps;
import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.HashMap;
import java.util.Map;

public class FoodDispenser {

    private static final Map<Breed,Integer> GRAMS_PER_KILO_BY_PET = new HashMap<>();
    private static final Map<Breed,PetFood> BRAND_FOR_BREED = Maps.newHashMap();
    static {
        GRAMS_PER_KILO_BY_PET.put(Breed.Dog,20);
        GRAMS_PER_KILO_BY_PET.put(Breed.Cat,10);
        BRAND_FOR_BREED.put(Breed.Cat,PetFood.KittyKat);
        BRAND_FOR_BREED.put(Breed.Dog,PetFood.FidosFood);
    }


    public Meal prepareMealFor(Pet pet) {
        return new Meal(rightAmountOfFood(pet),rightFoodFor(pet));
    }


    private PetFood rightFoodFor(Pet pet) {
        return BRAND_FOR_BREED.get(pet.getBreed());
    }

    private double rightAmountOfFood(Pet pet) {
        return pet.getWeightInKilos() * GRAMS_PER_KILO_BY_PET.get(pet.getBreed());
    }
}
