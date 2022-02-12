package ro.fasttrackit.curs17.homework;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonServiceTest {

    @Test
    void testFirstNameNotNull() {
        //SETUP
        Person person = new Person(null, "Ionel",25, "Oradea");
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setFirstName(null));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a name");
    }

    @Test
    void testFirstNameNotEmpty(){
        //SETUP
        Person person = new Person("", "Ionel",25, "Oradea");
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setFirstName(""));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a name");
    }

    @Test
    void testLastNameNotNull(){
        //SETUP
        Person person = new Person("Popescu", null,25, "Oradea");
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setLastName(null));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a name");
    }

    @Test
    void testLastNameNotEmpty(){
        //SETUP
        Person person = new Person("Popescu", "",25, "Oradea");
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setLastName(""));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a name");
    }

    @Test
    void testCityNotEmpty(){
        //SETUP
        Person person = new Person ("Popescu", "Ion",25, "");
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setCity(""));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a city name");
    }

    @Test
    void testCityNotNull() {
        //SETUP
        Person person = new Person("Popescu", "Ion", 25, null);
        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setCity(null));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a city name");
    }

    @Test
    void testValidAgePositive(){
        //SETUP
        Person person = new Person ("Popescu", "Ion",250, "Oradea");

        //RUN
        //ASSERT
        IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, ()->person.setAge(250));
        org.assertj.core.api.Assertions.assertThat(exc.getMessage()).isEqualTo("Not a valid age");
    }

    @Test
    void testValidAgeNegative() {
        //SETUP
        Person person = new Person("Popescu", "Ion", -10, "Oradea");

        //ASSERT
        IllegalArgumentException exc1 = assertThrows(IllegalArgumentException.class, () -> person.setAge(-10));
        org.assertj.core.api.Assertions.assertThat(exc1.getMessage()).isEqualTo("Not a valid age");
    }

    @Test
    void testListIsEmptyOrNull(){
        //SETUP
        PersonService personService = new PersonService(null);
        PersonService personService1 = new PersonService(List.of());
        //RUN
        List<Person> result = personService.sortFirstName();
        List<Person> actual = personService1.sortLastName();
        //ASSERT
        assertThat(result).isNullOrEmpty();
        assertThat(actual).isNullOrEmpty();
    }

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
        assertThat(result).contains("Popescu Ion")
                .isNotEmpty()
                .isNotNull();

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
        assertThat(result).isNotNull()
                          .isNotEmpty()
                          .contains(new Person("Popescu","Ion",38,"ORADEA"));
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
        assertThat(result).isNotNull()
                          .isNotEmpty()
                          .contains(new Person("Apavaloaie", "Vasile", 25, "ORADEA"));
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
        assertThat(result).isNotNull()
                          .isNotEmpty()
                          .contains(new Person("Popescu", "Dan", 16, "CLUJ"))
                          .contains(new Person("Apavaloaie", "Vasile", 25, "ORADEA"));
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
        assertThat(result).isNotNull()
                          .isNotEmpty()
                          .contains("POPESCU");
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
        assertThat(result).isNotNull()
                          .isNotEmpty()
                          .contains("Airinei C");
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
        assertThat(result).isNotNull()
                .contains(new Person("Ionescu", "George", 40, "BUCURESTI"));
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
        assertThat(result).isNotNull()
                .contains(new Person("Apavaloaie", "Vasile", 25, "ORADEA"));
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
        assertThat(result).isNotNull()
                .isSortedAccordingTo(Comparator.comparing(Person::getFirstName));
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
        assertThat(result).isNotNull()
                .isSortedAccordingTo(Comparator.comparing(Person::getLastName));
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
        assertThat(result).isNotNull()
                .isSortedAccordingTo(Comparator.comparing(Person::getFirstName)
                .thenComparing(Person::getAge));
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
        assertThat(result).isNotNull()
                .containsExactlyInAnyOrder("Popescu","Ionescu","Apavaloaie","Airinei","Moisescu");
    }
}