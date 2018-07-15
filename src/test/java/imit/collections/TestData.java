package imit.collections;

import static imit.collections.DataDemo.getAll;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestData {

    @Test
    public void testGettersAndSetters(){
        Data d = new Data();
        Data d2 = new Data("copy", d.getGroups());
        assertEquals("default title",d.getTitle());

        d.setTitle(d2.getTitle());
        assertEquals("copy",d.getTitle());

        Group[] poops = new Group[12];
        d2.setGroups(poops);
        assertEquals(12,d2.getLength());
    }

    @Test
    public void testDataIterator(){
        Group[] groups = new Group[2];
        groups[0] = new Group(1,1,6,1,0);
        groups[1] = new Group(2, 1,9,9,8);
        Data d = new Data("two groups", groups);
        DataIterator iter = d.iterator();
        assertEquals("1",iter.next().toString());
        assertEquals("6",iter.next().toString());
        assertEquals("1",iter.next().toString());
        assertEquals("0",iter.next().toString());
        assertEquals("1",iter.next().toString());
        assertEquals("9",iter.next().toString());
        assertEquals("9",iter.next().toString());
        assertEquals("8",iter.next().toString());
    }

    @Test(expected = NullPointerException.class)
    public void testIteratorException(){
        Group[] group = new Group[1];
        group[0] = new Group(1,1,6);
        Data d = new Data("sample", group);
        DataIterator iter = d.iterator();
        assertEquals("1",iter.next().toString());
        assertEquals("6",iter.next().toString());
        assertEquals("exception starts here",iter.next().toString());
    }


    @Test
    public void testDataDemo(){
        Group[] groups = new Group[2];
        groups[0] = new Group(1,3,4,5,6);
        groups[1] = new Group(2, 6,5,4,3);
        Data d = new Data("two groups", groups);
        assertEquals("[3, 4, 5, 6, 6, 5, 4, 3]",getAll(d).toString());
    }
}
