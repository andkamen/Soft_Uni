package com._02_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07_FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();

        String user = scan.nextLine();
        String email;

        while (!user.equals("stop")) {
            email = scan.nextLine();
            String[] testMail = email.split("\\.");
            if (!testMail[testMail.length-1].equalsIgnoreCase("uk") && !testMail[testMail.length-1].equalsIgnoreCase("us")) {
                emails.put(user, email);
            }
            user = scan.nextLine();
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
