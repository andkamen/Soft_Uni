package bg.softuni.interfaces;

public interface OutputWriter {
    void write(String output);

    void write(String format, String output);

    void writeLine(String output);

    void writeLine(String format, String output);
}
