package model;

import java.util.*;

public final class PersonBase {
    private final Map<String, Set<Person>> base = new HashMap<>();
    public void addPerson(Person person) {
        Set<Person> set = base.get(person.getLastName());
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(person);
        base.put(person.getLastName(), set);
    }

    public Set<String> getAllLastNames() {
        return base.keySet();
    }

    public String getContentForLastName(String lastName) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for(Person person : base.get(lastName)) {
            joiner.add(person.toString());
        }
        return joiner.toString();
    }
}
