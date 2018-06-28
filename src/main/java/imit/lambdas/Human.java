package imit.lambdas;

import java.util.Objects;

public class Human extends imit.collections.Human {
    private Floor floor;

    public Human(String firstName, String middleName, String lastName, int age, Floor floor){
        super(firstName, middleName, lastName, age);
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Human human = (Human) o;
        return floor == human.floor;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), floor);
    }
}
