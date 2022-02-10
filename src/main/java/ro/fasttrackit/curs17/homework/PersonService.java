package ro.fasttrackit.curs17.homework;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PersonService {

    private final List<Person> persons;

    public PersonService(List<Person> persons) {
        this.persons = persons == null
                ? new ArrayList<>()
                : new ArrayList<>(persons);
    }

    public List<String> firstLastName() {
        return persons.stream()
                .filter(Objects::nonNull)
                .map(person -> String.format("%s %s",person.getFirstName(),person.getLastName()))
                .collect(toList());
    }

    public List<Person> majorPersons(){
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getAge()>18)
                .collect(toList());
    }

    public List<Person> fromOradea(){
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getCity().equalsIgnoreCase("Oradea"))
                .collect(toList());
    }

    public List<Person> fromOradeaOrCluj(){
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getCity().equalsIgnoreCase("Oradea") ||
                        person.getCity().equalsIgnoreCase("Cluj"))
                .collect(toList());
    }

    public List<String> namesCapitalized(){
        return persons.stream()
                .filter(Objects::nonNull)
                .map(person -> person.getFirstName().toUpperCase(Locale.ROOT))
                .collect(toList());
    }

    public List<String> namesFirstLetter(){
        return persons.stream()
                .filter(Objects::nonNull)
                .map(person -> String.format("%s %s",person.getFirstName(),person.getLastName().charAt(0)))
                .collect(toList());
    }

    public List<Person> betweenAges(){
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getAge() < 60)
                .filter(person -> person.getAge() > 18)
                .collect(toList());
    }

    public List<Person> startAName(){
        return persons.stream()
                .filter(Objects::nonNull)
                .filter(person -> person.getFirstName().startsWith("A"))
                .collect(toList());
    }

    public List<Person> sortFirstName(){
        return persons.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Person::getFirstName))
                .collect(toList());
    }

    public List<Person> sortLastName(){
        return persons.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Person::getLastName))
                .collect(toList());
    }

    public List<Person> sortNameAge(){
        return persons.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Person::getFirstName)
                        .thenComparing(Person::getLastName)
                        .thenComparing(Person::getAge))
                .collect(toList());
    }

    public List<String> uniqueName(){
        return persons.stream()
                .filter(Objects::nonNull)
                .map(Person::getFirstName)
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "persons=" + persons +
                '}';
    }
}

