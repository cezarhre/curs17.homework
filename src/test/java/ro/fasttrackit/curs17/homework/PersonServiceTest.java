package ro.fasttrackit.curs17.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class PersonServiceTest {

    @Test
    void testFirstLastName() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<String> result = personService.firstLastName();
        //ASSERT
        assertThat(personService.firstLastName()).isEqualTo(result);
        assertThat(personService.firstLastName()).isNotNull();
    }

    @Test
    void testMajorPersons() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.majorPersons();
        //ASSERT
        assertThat(personService.majorPersons()).isNotNull();
        assertThat(personService.majorPersons()).isEqualTo(result);
    }

    @Test
    void testFromOradea() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.fromOradea();
        //ASSERT
        assertThat(personService.fromOradea()).isNotNull();
        assertThat(personService.fromOradea()).isEqualTo(result);
    }

    @Test
    void testFromOradeaOrCluj() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.fromOradeaOrCluj();
        //ASSERT
        assertThat(personService.fromOradeaOrCluj()).isNotNull();
        assertThat(personService.fromOradeaOrCluj()).isEqualTo(result);
    }

    @Test
    void testNamesCapitalized() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<String> result = personService.namesCapitalized();
        //ASSERT
        assertThat(personService.namesCapitalized()).isNotNull();
        assertThat(personService.namesCapitalized()).isEqualTo(result);
    }

    @Test
    void testNamesFirstLetter() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<String> result = personService.namesFirstLetter();
        //ASSERT
        assertThat(personService.namesFirstLetter()).isNotNull();
        assertThat(personService.namesFirstLetter()).isEqualTo(result);
    }

    @Test
    void testBetweenAges() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.betweenAges();
        //ASSERT
        assertThat(personService.betweenAges()).isNotNull();
        assertThat(personService.betweenAges()).isEqualTo(result);
    }

    @Test
    void testStartAName() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.startAName();
        //ASSERT
        assertThat(personService.startAName()).isNotNull();
        assertThat(personService.startAName()).isEqualTo(result);
    }

    @Test
    void testSortFirstName() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.sortFirstName();
        //ASSERT
        assertThat(personService.sortFirstName()).isNotNull();
        assertThat(personService.sortFirstName()).isEqualTo(result);
    }

    @Test
    void testSortLastName() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.sortLastName();
        //ASSERT
        assertThat(personService.sortLastName()).isNotNull();
        assertThat(personService.sortLastName()).isEqualTo(result);
    }

    @Test
    void testSortNameAge() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<Person> result = personService.sortNameAge();
        //ASSERT
        assertThat(personService.sortNameAge()).isNotNull();
        assertThat(personService.sortNameAge()).isEqualTo(result);
    }

    @Test
    void testUniqueName() {
        //SETUP
        PersonService personService = new PersonService(List.of(
                new Person("Popescu", "Ion", 38, "ORADEA"),
                new Person("Ionescu", "George", 40, "BUCURESTI"),
                new Person("Apavaloaie", "Vasile", 25, "ORADEA"),
                new Person("Popescu", "Dan", 16, "CLUJ"),
                new Person("Airinei", "Calin", 17, "CRAIOVA"),
                new Person("Moisescu", "Cristi", 14, "CLUJ")
        ));
        //RUN
        List<String> result = personService.uniqueName();
        //ASSERT
        assertThat(personService.uniqueName()).isNotNull();
        assertThat(personService.uniqueName()).isEqualTo(result);
    }
}