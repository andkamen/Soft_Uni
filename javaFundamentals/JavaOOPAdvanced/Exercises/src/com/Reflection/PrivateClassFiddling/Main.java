package com.Reflection.PrivateClassFiddling;

import java.lang.reflect.Constructor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, ReflectiveOperationException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt instance = constructor.newInstance();

        while (true) {
            String[] params = reader.readLine().split("_");
            if (params[0].equals("END")) {
                break;
            }

            String methodName = params[0];
            int value = Integer.valueOf(params[1]);

            Method method = blackBoxIntClass.getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(instance, value);

            Field field = blackBoxIntClass.getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(instance));
        }
    }
}
