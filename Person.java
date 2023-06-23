package model;

import java.util.Date;
import java.util.Objects;

public final class Person {
    private String lastName;
    private String firstName;
    private String patronymic;
    // Valid value: date in format 'dd.mm.yyyy'
    private String birthDate;
    // Valid value: unsigned integer number
    private long phoneNumber;
    // Valid values: 'f' - for female, 'm' - for male.
    private char gender;

    public Person() {
    }

    public Person(String lastName, String firstName, String patronymic, String birthDate, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String  getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int[] fieldHashes = new int[]{
                lastName == null ? 0 : lastName.hashCode(),
                firstName == null ? 0 : firstName.hashCode(),
                patronymic == null ? 0 : patronymic.hashCode(),
                birthDate == null ? 0 : birthDate.hashCode(),
                Long.valueOf(phoneNumber).hashCode(),
                new Character(gender).hashCode()
        };
        int result = 1;
        final int prime = 31;
        for (int i = 0; i < fieldHashes.length; i++) {
            result = result * prime + fieldHashes[i];
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person)obj;
        return Objects.equals(lastName, person.getLastName()) &&
               Objects.equals(firstName, person.getFirstName()) &&
               Objects.equals(patronymic, person.getPatronymic()) &&
               Objects.equals(birthDate, person.getBirthDate()) &&
               phoneNumber == person.getPhoneNumber() &&
               gender == person.getGender();

    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;
    }
}
