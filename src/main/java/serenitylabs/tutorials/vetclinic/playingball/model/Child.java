package serenitylabs.tutorials.vetclinic.playingball.model;

import serenitylabs.tutorials.vetclinic.playingball.exception.DontKnowGameException;

public class Child  {

    public void goPlay(Game game) {
        Player gameToPlay = PlayerForGame.called(game);
        gameToPlay.play();

    }

}
