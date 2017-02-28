package com.IO;

import com.CommandInterpreter;
import com.StaticData.SessionData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
    private static final String endCommand = "quit";

    public static void readCommands() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            OutputWriter.writeMessage(String.format("%s>", SessionData.currentPath));
            String input = reader.readLine().trim();

            if (input.equals(endCommand)) {
                break;
            }

            CommandInterpreter.interpretCommand(input);
        }
    }
}
