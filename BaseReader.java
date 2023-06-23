package io;

import model.PersonBase;

import java.io.IOException;

public interface BaseReader {
    PersonBase readBaseFromDirectory(String dirName) throws IOException;
}
