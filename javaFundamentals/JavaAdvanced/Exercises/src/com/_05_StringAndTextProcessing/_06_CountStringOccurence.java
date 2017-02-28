package com._05_StringAndTextProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _06_CountStringOccurence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine().toLowerCase();
        String findStr = reader.readLine().toLowerCase();
        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += 1;
            }
        }
        System.out.println(count);

    }
}
