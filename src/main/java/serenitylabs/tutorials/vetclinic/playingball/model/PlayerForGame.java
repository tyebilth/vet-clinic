package serenitylabs.tutorials.vetclinic.playingball.model;


import java.io.IOException;

public class PlayerForGame {
    public static Player called(Game game)  {

        switch (game) {
            case Football:
                return new PlayFootball();
            case Hockey:
                return new PlayHockey();

            case Tennis:
                return new PlayTennis();
            case Cricket:
                return new PlayCricket();
            case Handball:
                return new PlayHandball();


        }
        return null;
    }

}
