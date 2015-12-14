package com.udacity.gradle.jokes;

import java.util.Random;

public class JokeSmith {
    public String getJoke() {

        Random rand = new Random();
        int jokeNumber = rand.nextInt(7);
        String jokeText = "";
        if (jokeNumber == 0) {
            jokeText = "It's entering the teenage weird years";
        } else if (jokeNumber == 1) {
            jokeText = "Because Tyson was chasing it";
        } else if (jokeNumber == 2) {
            jokeText = "It got tired of everyone making so many bad jokes";
        } else if (jokeNumber == 3) {
            jokeText = "To get to the other side";
        } else if (jokeNumber == 4) {
            jokeText = "It was too far to walk around";
        } else if (jokeNumber == 5) {
            jokeText = "It's lunch time";
        } else if (jokeNumber == 6) {
            jokeText = "Way too many chickens on this side";
        }
        return "Why did the chicken cross the road? " +"\n\n"+ jokeText;
    }
}