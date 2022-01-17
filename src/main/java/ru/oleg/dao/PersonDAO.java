package ru.oleg.dao;

import org.springframework.stereotype.Component;
import ru.oleg.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Oleg"));
        people.add(new Person(++PEOPLE_COUNT, "Nasty"));
        people.add(new Person(++PEOPLE_COUNT, "Kristina"));
        people.add(new Person(++PEOPLE_COUNT, "Roxy"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(final int id) {
        return people.stream()
                .filter(person -> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
