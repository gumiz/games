package com.lib.gumisoft.factories;

public interface IRandomizer {
    int getRandomNumber(int max);
    int getRandomNumber(int min, int max);
    boolean rollDice(int number);
}
