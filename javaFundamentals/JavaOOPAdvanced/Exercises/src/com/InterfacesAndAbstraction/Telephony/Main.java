package com.InterfacesAndAbstraction.Telephony;

import com.InterfacesAndAbstraction.Telephony.models.Smartphone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Smartphone smartphone = new Smartphone();
        String[] phoneNumbers = reader.readLine().split("\\s+");
        for (String phoneNumber : phoneNumbers) {
            System.out.println(smartphone.call(phoneNumber));
        }

        String[] sites = reader.readLine().split("\\s+");
        for (String site : sites) {
            System.out.println(smartphone.browse(site));
        }

    }
}

