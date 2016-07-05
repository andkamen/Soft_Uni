package com.L02Methods.PrimeChecker;

public class Number {
    private int number;
    private boolean prime;

    public Number(int number) {
        this.number = number;
        setPrime(checkIsPrime(number));
    }

    public int getNumber() {
        return number;
    }

    public void setPrime(boolean isPrime) {
        this.prime = isPrime;
    }

    public boolean isPrime() {
        return prime;
    }

    public boolean checkIsPrime(int number){
        if(number == 0 || number == 1 || number == 2){
            return  true;
        }
        if( number%2 == 0){
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public Number findNextPrime(){
        Number nextPrime;
        int nextNum = getNumber()+1;

        while(!checkIsPrime(nextNum)){
            nextNum++;
        }
        nextPrime = new Number(nextNum);
        nextPrime.setPrime(true);
        return nextPrime;
    }
}
