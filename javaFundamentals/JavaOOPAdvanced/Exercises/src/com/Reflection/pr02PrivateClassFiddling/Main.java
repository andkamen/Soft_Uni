package com.Reflection.pr02PrivateClassFiddling;

import com.Reflection.pr02PrivateClassFiddling.peshoslav.BlackBoxInt;

import java.lang.reflect.Constructor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Class<BlackBoxInt> boxClass = BlackBoxInt.class;

        try {
            Constructor ctor = boxClass.getDeclaredConstructor();
            BlackBoxInt blackBoxInt = boxClass.newInstance();
            while (true) {

            }
        } catch (IllegalAccessException iae) {

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
