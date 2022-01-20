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
        people.add(new Person(++PEOPLE_COUNT, "Oleg", 25, "oleg@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Nasty", 25, "nasty@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kristina", 25, "kristina@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Roxy", 25, "roxy@mail.ru"));
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

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatePerson.getName());
        personToBeUpdate.setAge(updatePerson.getAge());
        personToBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
