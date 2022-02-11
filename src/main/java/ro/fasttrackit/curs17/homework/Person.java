package ro.fasttrackit.curs17.homework;

import java.util.Objects;

public record Person(String firstName, String lastName, int age, String city) {

    public int getAge() {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Not a valid age");
        }
        return age;
    }

    public String getCity() {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("Not a valid city name");
        }
        return city;
    }

    public String getLastName() {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Not a valid last name");
        }
        return lastName;
    }

    public String getFirstName() {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("Not a valid first name");
        }
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getAge() == person.getAge() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName()) && Objects.equals(getCity(), person.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAge(), getCity());
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

