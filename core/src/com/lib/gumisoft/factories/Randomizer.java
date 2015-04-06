package com.lib.gumisoft.factories;

import java.util.Random;

public class Randomizer implements IRandomizer {
    private final Random _random;

    public Randomizer() {
        _random = new Random();
    }

    @Override
    public int getRandomNumber(int max) {
        int number = _random.nextInt(max);
        return number;
    }

    @Override
    public int getRandomNumber(int min, int max) {
        int number =  _random.nextInt((max - min) + 1) + min;
        return number;
    }
}
