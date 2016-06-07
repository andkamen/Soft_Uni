package com._02_SetsAndMaps;

import java.util.*;

public class _09_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> logData = new TreeMap<>();

        String[] inputData = scan.nextLine().split(" ");

        while (!inputData[0].equals("end")) {
            String user = inputData[2].substring(inputData[2].indexOf('=') + 1);
            String ip = inputData[0].substring(inputData[0].indexOf('=') + 1);

            if (!logData.containsKey(user)) {
                logData.put(user, new LinkedHashMap<>());
            }
            if (!logData.get(user).containsKey(ip)) {
                logData.get(user).put(ip, 1);
            } else {
                int val = logData.get(user).get(ip) + 1;
                logData.get(user).put(ip, val);
            }

            inputData = scan.nextLine().split(" ");
        }

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : logData.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            StringBuilder ipOutput = new StringBuilder();
            for (Map.Entry<String, Integer> ip : entry.getValue().entrySet()) {
                ipOutput.append(String.format("%s => %d, ", ip.getKey(), ip.getValue()));
            }
            ipOutput.replace(ipOutput.lastIndexOf(","), ipOutput.lastIndexOf(",") + 1, ".");

            System.out.printf("%s%n", ipOutput);

        }
    }
}
