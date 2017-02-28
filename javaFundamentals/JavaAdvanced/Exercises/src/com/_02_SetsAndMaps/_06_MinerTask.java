package com._02_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_MinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, Long> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();
        long quantity;

        while (!resource.equals("stop")) {
            quantity = Long.parseLong(scan.nextLine());

            if (!resources.containsKey(resource)) {
                resources.put(resource, quantity);
            } else {
                long val = resources.get(resource)+quantity;
                resources.put(resource,val);
            }
            resource = scan.nextLine();
        }
        for (Map.Entry<String,Long> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
