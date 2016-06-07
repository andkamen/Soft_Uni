package com._02_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashSet<String> usernameSet = new LinkedHashSet();

        int lines = Integer.parseInt(scan.nextLine());

        for (int i = 0; i <lines; i++) {
            String username = scan.nextLine();
            usernameSet.add(username);
        }

        for ( String username : usernameSet) {
            System.out.println(username);
        }


    }
}
