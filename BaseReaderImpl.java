package io;

import model.PersonBase;
import parser.PersonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public final class BaseReaderImpl implements BaseReader{
    private final static PersonParser parser = new PersonParser();

    @Override
    public PersonBase readBaseFromDirectory(String dirName) throws IOException {
        List<File> files = listOfFilesInDirectory(dirName);
        PersonBase base = new PersonBase();
        for (File file : files) {
            readFile(base, file);
        }
        return base;
    }

    private List<File> listOfFilesInDirectory(String dirName) {
        List<File> result = new ArrayList<>();
        File dir = new File(dirName);
        if (dir.exists() && dir.listFiles() != null) {
            result = new ArrayList<>(Arrays.asList(Objects.requireNonNull(dir.listFiles())));
        }
        return result;
    }

    private void readFile(PersonBase base, File file) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String inputLine = reader.readLine();
        while (inputLine != null) {
            base.addPerson(parser.parse(inputLine));
            inputLine = reader.readLine();
        }
        reader.close();
    }
}
