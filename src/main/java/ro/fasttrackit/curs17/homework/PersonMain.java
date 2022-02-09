package ro.fasttrackit.curs17.homework;

import java.util.List;

public class PersonMain {
    public static void main(String[] args) {

        PersonService people = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        System.out.println(people);
        System.out.println(people.firstLastName());
        System.out.println(people.majorPersons());
        System.out.println(people.fromOradea());
        System.out.println(people.fromOradeaOrCluj());
        System.out.println(people.namesCapitalized());
        System.out.println(people.namesFirstLetter());
        System.out.println(people.betweenAges());
        System.out.println(people.startAName());
        System.out.println(people.sortFirstName());
        System.out.println(people.sortLastName());
        System.out.println(people.sortNameAge());
        System.out.println(people.uniqueName());
    }
}
