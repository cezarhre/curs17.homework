package ro.fasttrackit.curs17.homework;

import java.util.Objects;

public final class Person {
    private final String firstName;
    private final String lastName;
    private int age;
    private final String city;

    public Person(String firstName, String lastName, int age, String city) {
        this.age = age;
        this.firstName = firstName == null || firstName.isEmpty()
                ? "Not a valid first name"
                : firstName;
        this.lastName = lastName == null || lastName.isEmpty()
                ? "Not a valid last name"
                : lastName;
        this.city = city == null || city.isEmpty()
                ? "Not a valid city name"
                : city;
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

    public void setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Not a valid age");
        }else {
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Person) obj;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                this.age == that.age &&
                Objects.equals(this.city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, city);
    }

    @Override
    public String toString() {
        return "Person[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "age=" + age + ", " +
                "city=" + city + ']';
    }
}