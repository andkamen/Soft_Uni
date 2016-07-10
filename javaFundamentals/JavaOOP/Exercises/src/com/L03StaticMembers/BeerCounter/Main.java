package com.L03StaticMembers.BeerCounter;

import java.util.Scanner;

import static com.L03StaticMembers.BeerCounter.BeerCounter.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       while(true){
            String[] input = scan.nextLine().split("\\s+");
            if (input[0].equals("End")){
                break;
            }

            BuyBeer(Integer.valueOf(input[0]));
            DrinkBeer(Integer.valueOf(input[1]));
        }
        System.out.printf("%d %d",getBeersInStock(),getBeersDrankCount());

    }


}
