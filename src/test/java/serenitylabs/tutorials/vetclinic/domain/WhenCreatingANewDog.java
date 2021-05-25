package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {


    @Test
    public void it_should_have_a_name () throws Exception{
        LocalDateTime birthday = LocalDateTime.now();
        Dog fido = DogBuilder.aLargeDog()
                      .called("Fido")
                      .ofColour("Black")
                      .withFavouriteFood("Pizza")
                      .bornOn(birthday);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Labrador",fido.getBreed());
        Assert.assertEquals(birthday,fido.getDateOfBirth());
        Assert.assertEquals("Black",fido.getColour());
        Assert.assertEquals("Pizza",fido.getFavouriteFood());

    }

    @Test
    public void it_should_have_a_favouriteFood() {
            LocalDateTime birthday = LocalDateTime.now();
            Dog jackie = DogBuilder.aSmallDog()
                    .called("Jackie")
                    .ofColour("White")
                    .withFavouriteFood("Dog Food")
                    .bornOn(birthday);

            Assert.assertEquals("Jackie",jackie.getName());
            Assert.assertEquals("Poodle",jackie.getBreed());
            Assert.assertEquals(birthday,jackie.getDateOfBirth());
            Assert.assertEquals("White",jackie.getColour());
            Assert.assertEquals("Dog Food",jackie.getFavouriteFood());

        }
}
