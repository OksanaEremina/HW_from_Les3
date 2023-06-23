package parser;

import model.Person;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class PersonParser {
    private final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public PersonParser() {
        DATE_FORMAT.setLenient(false);
    }

    public Person parse(String str) throws IllegalArgumentException {
        String[] parts = str.split(" ");
        if (parts.length != 6) {
            throw new IllegalArgumentException(
                    String.format(
                            "Information string about person must contains 6 parts, but it contains %d parts.",
                            parts.length
                    ));
        }
        return new Person(
                parts[0],
                parts[1],
                parts[2],
                parseDate(parts[3]),
                parsePhoneNumber(parts[4]),
                parseGender(parts[5])
        );
    }

    private String parseDate(String date) throws IllegalArgumentException {
        try {
            DATE_FORMAT.parse(date);
        } catch (ParseException ex) {
            throw new IllegalArgumentException(
                    String.format(
                            "Birthday date %s has invalid format. The following format is required: \"dd.mm.yyyy\".",
                            date
                    )
            );
        }
        return date;
    }

    private long parsePhoneNumber(String phoneNumberStr) throws NumberFormatException {
        long result = 0;
        try {
            result = Long.parseLong(phoneNumberStr);
        } catch (NumberFormatException ex) {
            throw new NumberFormatException(String.format("Phone number must be non-negative integer number without formatting. Entered value is invalid: %s.", phoneNumberStr));
        }
        if (result <= 0) {
            throw new NumberFormatException(String.format("Phone number must be non-negative integer number without formatting. Entered value is invalid: %s.", phoneNumberStr));
        }
        return result;
    }

    private char parseGender(String gender) throws IllegalArgumentException {
        if (gender.equals("f")) {
            return 'f';
        } else if (gender.equals("m")) {
            return 'm';
        } else {
            throw new IllegalArgumentException(String.format("Invalid gender: %s. Must be \'f\' or \'m\'.", gender));
        }
    }
}
