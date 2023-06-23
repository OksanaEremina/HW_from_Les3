package io;

import model.PersonBase;

import java.io.IOException;

public interface BaseWriter {
    void writeBaseToDirectory(String dirName, PersonBase base) throws IOException;
}
