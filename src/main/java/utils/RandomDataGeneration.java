package utils;

import java.util.Random;

public class RandomDataGeneration {
    /**
     * Method is used to generate random sequence of int values, where
     * intRange - sets the max int range;
     * quantityOfRandomInt - sets quantity of int values to be added to each other in a sequence;
     *
     */
    public int randomInt(int intRange){
        Random random = new Random();
        return random.nextInt(intRange);
    }
}
