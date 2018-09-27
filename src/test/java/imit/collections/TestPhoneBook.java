package imit.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestPhoneBook {
    @Test
    public void testPhoneBookMethods(){
        PhoneBook pb = new PhoneBook();
        Human h1 = new Human();
        pb.addNumber(h1,"+1-555-333-11");
        pb.addNumber(h1,"+2-444-555-66");
        pb.addNumber(h1,"+3-555-222-99");
        pb.addNumber(h1,"+7-333-222-11");
        pb.addNumber(h1,"+2-111-555-33");
        assertEquals("+1-555-333-11",pb.getNumbersByName(h1).get(0));
        assertEquals("+2-444-555-66",pb.getNumbersByName(h1).get(1));
        pb.removeNumber(h1,"+1-555-333-11");
        assertEquals("+2-444-555-66",pb.getNumbersByName(h1).get(0));
        assertEquals(h1,pb.findHumanByNumber("+7-333-222-11"));
        assertNull(pb.findHumanByNumber("+9-333-111-77"));
    }
}
