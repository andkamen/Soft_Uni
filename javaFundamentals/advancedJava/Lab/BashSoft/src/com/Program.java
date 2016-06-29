package com;

import com.IO.InputReader;
import com.IO.OutputWriter;
import com.Judge.Tester;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {
        try{
            InputReader.readCommands();
        } catch (IOException e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}
