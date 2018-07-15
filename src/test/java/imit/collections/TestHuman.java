package imit.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestHuman {

    @Test
    public void testHuman(){
        Human human = new Human();
        human.setFirstName("A");
        human.setMiddleName("B");
        human.setLastName("C");
        human.setAge(25);
        Human h = new Human("A", "B", "C", 25);
        assertEquals(h, human);
    }

    @Test
    public void testStudent(){
        Student st = new Student("IMIT");
        Student st2 = new Student("A","B","C",25,"FKN");
        assertEquals("FKN", st2.getFaculty());
        st2.setFaculty("IMIT");
        assertEquals("IMIT", st2.getFaculty());
        assertEquals("Student{Human{Ivan Ivanovich Ivanov , age=18} faculty='IMIT}",st.toString());
    }
}
