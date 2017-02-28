package com;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_CubicMessage {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



        Pattern pattern = Pattern.compile("^(\\d+)([A-Za-z]+)(\\d*)([^A-Za-z]*)$");

        while(true){
            String inputMessage = scan.nextLine();
            if (inputMessage.equals("Over!")){
                break;
            }
            int messageLength = Integer.parseInt(scan.nextLine());

            Matcher matcher = pattern.matcher(inputMessage);

            if (matcher.find()){
                String message = matcher.group(2);
                if (message.length()!=messageLength){
                    continue;
                }
                StringBuilder verifiedMessage = new StringBuilder();

                for (char c : matcher.group(1).toCharArray()) {
                    int position = Integer.parseInt(c+"");
                    if (position<message.length()){
                        verifiedMessage.append(message.charAt(position));
                    }
                    else {
                        verifiedMessage.append(" ");
                    }

                }

                String secondNums = matcher.group(3);

                for (char c : secondNums.toCharArray()) {
                    int position = Integer.parseInt(c+"");
                    if (position<message.length()){
                        verifiedMessage.append(message.charAt(position));
                    }
                    else {
                        verifiedMessage.append(" ");
                    }
                }

                System.out.println(message+" == "+verifiedMessage.toString());

            }

        }
    }
}
