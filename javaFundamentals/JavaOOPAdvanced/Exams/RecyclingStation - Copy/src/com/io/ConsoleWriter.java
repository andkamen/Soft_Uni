package com.io;

import com.io.contracts.OutputWriter;

public class ConsoleWriter implements OutputWriter {

    public ConsoleWriter() {
    }

    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void writeLine(String format, String output) {
        System.out.println(String.format(format, output));
    }
}

