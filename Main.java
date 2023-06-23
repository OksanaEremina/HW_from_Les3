import io.BaseReader;
import io.BaseReaderImpl;
import io.BaseWriter;
import io.BaseWriterImpl;
import model.Person;
import model.PersonBase;
import parser.PersonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static config.Config.BASE_DIR_NAME;

public class Main {
    public static void main(String[] args) throws IOException {
        BaseReader baseReader = new BaseReaderImpl();
        BaseWriter baseWriter = new BaseWriterImpl();
        PersonBase base = baseReader.readBaseFromDirectory(BASE_DIR_NAME);
        consoleSession(base);
        baseWriter.writeBaseToDirectory(BASE_DIR_NAME, base);
    }

    private static void consoleSession(PersonBase base) throws IOException {
        PersonParser parser = new PersonParser();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        while (inputLine != null && !inputLine.equals("quit")) {
            if (inputLine.equals("")) {
                continue;
            }
            Person person = parser.parse(inputLine);
            base.addPerson(person);
            inputLine = reader.readLine();
        }
        reader.close();
    }
}