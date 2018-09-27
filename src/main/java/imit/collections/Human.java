package imit.collections;

import java.util.Objects;

public class Human {
    private String firstName, middleName, lastName;
    private int age;

    public Human(){
        firstName = "Ivan";
        middleName = "Ivanovich";
        lastName = "Ivanov";
        age = 18;
    }

    public Human(String firstName, String middleName, String lastName, int age) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getAge() == human.getAge() &&
                Objects.equals(getFirstName(), human.getFirstName()) &&
                Objects.equals(getMiddleName(), human.getMiddleName()) &&
                Objects.equals(getLastName(), human.getLastName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getAge());
    }

    @Override
    public String toString() {
        return "Human{" +
                firstName + ' ' +
                middleName + ' ' +
                lastName + ' ' +
                ", age=" + age +
                '}';
    }
}
