package com.InterfacesAndAbstraction.MilitaryElite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        SoldierFactory soldierFactory = new SoldierFactory();
        CommandParser commandParser = new CommandParser(soldierFactory);

        while (true){
            String input = reader.readLine();
            try {
                commandParser.parseCommand(input);
            }catch (IllegalArgumentException iae){
                //print error message (probably illegal corps related)
            }
            if(input.equals("End")){
                break;
            }
        }
    }
}
