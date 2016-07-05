package com.L02Methods.PrimeChecker;

        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        Number first = new Number(num);
        first.setPrime(first.checkIsPrime(num));
        Number second = first.findNextPrime();
        System.out.printf("%d, %s", second.getNumber(), first.isPrime());
    }
}
