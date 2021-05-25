package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {


    @Test
    public void it_should_have_a_name () throws Exception{
        LocalDateTime birthday = LocalDateTime.now();
        Dog fido = Dog.called("Fido")
                      .ofBreed("Poodle")
                      .ofColour("Black")
                      .withFavouriteFood("Pizza")
                      .bornOn(birthday);

        Assert.assertEquals("Fido",fido.getName());
        Assert.assertEquals("Poodle",fido.getBreed());
        Assert.assertEquals(birthday,fido.getDateOfBirth());
        Assert.assertEquals("Black",fido.getColour());
        Assert.assertEquals("Pizza",fido.getFavouriteFood());

    }


}
