package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;

public class WhenVisitingTheClinic {

    @Test
    public void cats_and_dogs_complain_to_the_assistant() {

        Cat felix = Cat.called("Felix").ofBreed("Siamese").andOfColour("White");
        Dog fido = Dog.called("Fido").ofBreed("Labrador").andOfColour("Black");

        ComplaintRegister complaintRegister = new ComplaintRegister();
        VetAssistant assistant = new VetAssistant(complaintRegister);

        assistant.recordComplaintFrom(fido);
        assistant.recordComplaintFrom(felix);

        assertThat(complaintRegister.getCompaints(),hasItems("Growl","Meow"));
    }
}
