package ro.fasttrackit.curs17.homework;

import java.util.Objects;

public final class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String city;

    public Person(String firstName, String lastName, int age, String city) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;

    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Not a name");
        }else {
            this.lastName = lastName;
        }
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("Not a name");
        }else {
            this.firstName = firstName;
        }
    }

    public void setCity(String city) {
        if(city == null || city.isEmpty()){
            throw new IllegalArgumentException("Not a city name");
        }else {
            this.city = city;
        }
    }

    public void setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Not a valid age");
        }else {
            this.age = age;
        }
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