package com.L03StaticMembers.BeerCounter;

public class BeerCounter {

    private static int beersInStock = 0;
    private static int beersDrankCount = 0;

    public static int getBeersInStock() {
        return beersInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }


    public static void BuyBeer(int beersBought) {
        beersInStock += beersBought;
    }

    public static void DrinkBeer(int beersDrunk) {
        beersInStock -= beersDrunk;
        beersDrankCount += beersDrunk;
    }

}
