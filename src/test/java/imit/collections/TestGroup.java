package imit.collections;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestGroup {
    @Test

    public void testGroup() {
        int[] pop = new int[2];
        pop[0] = 1;
        pop[1] = 2;
        Group test = new Group(3,1,2,3,4);
        assertEquals(3, test.getId());
        assertEquals(4, test.getLength());
        test.setId(5);
        test.setData(pop);
        assertEquals(5, test.getId());
        assertEquals(2, test.getLength());
        assertEquals("[1, 2]", Arrays.toString(test.getData()));
        assertEquals("id = 5, data = [1, 2]", test.toString());

    }
}
