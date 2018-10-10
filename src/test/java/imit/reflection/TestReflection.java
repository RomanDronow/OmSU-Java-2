package imit.reflection;

import imit.collections.Group;
import imit.collections.Human;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static imit.reflection.ReflectionDemo.countHumans;
import static imit.reflection.ReflectionDemo.getPublicMethods;
import static imit.reflection.ReflectionDemo.getSupeclasses;
import static org.junit.Assert.assertEquals;

public class TestReflection {

    @Test
    public void testHumansInList(){
        List lst = new ArrayList();
        lst.add(new Human("D","E","F",5));
        lst.add(new Human("K","H","X",6));
        lst.add(new Group(1,2,3,3,4,45));
        lst.add(5);
        lst.add("Hello");
        lst.add(new Human("A","B","C",2));
        assertEquals(3,countHumans(lst));
    }

    @Test
    public void testGetPublicMethods(){
        Group g = new Group(1,2,2,2,25);
        List lst = getPublicMethods(g);
        assertEquals(14,lst.size());
    }


    @Test
    public void testGetSuperclasses(){
        Group g = new Group(3,3,3,3,32);
        assertEquals(1,getSupeclasses(g).size());
    }
}
