package imit.lambdas;

import java.util.Objects;

public class Human extends imit.collections.Human {
    private Sex sex;

    public Human(String firstName, String middleName, String lastName, int age, Sex sex){
        super(firstName, middleName, lastName, age);
        this.sex = sex;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Human human = (Human) o;
        return sex == human.sex;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), sex);
    }
}
