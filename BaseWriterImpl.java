package io;

import model.PersonBase;

import java.io.*;

public final class BaseWriterImpl implements BaseWriter{
    @Override
    public void writeBaseToDirectory(String dirName, PersonBase base) throws IOException {
        for (String fileName : base.getAllLastNames()) {
            writeBaseOfLastNameToFile(dirName, fileName, base.getContentForLastName(fileName));
        }
    }

    private void writeBaseOfLastNameToFile(String dirName, String fileName, String content) throws IOException {
        File dir = new File(dirName);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = new File(dir, fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content);
        writer.close();
    }
}
