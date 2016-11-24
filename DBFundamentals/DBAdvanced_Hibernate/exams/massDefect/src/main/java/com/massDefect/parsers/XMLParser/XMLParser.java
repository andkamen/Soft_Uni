package com.massDefect.parsers.XMLParser;

public interface XMLParser {
    public <T> T readFromXml(Class<T> classes, String fileName);
}
