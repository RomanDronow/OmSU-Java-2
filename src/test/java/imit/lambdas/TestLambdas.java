package imit.lambdas;

import org.junit.Test;

import static imit.lambdas.Sex.MALE;
import static org.junit.Assert.*;

public class TestLambdas {
    private static final Human h1 = new Human("a", "b", "c", 11, MALE);
    private static final Human h2 = new Human("a", "b", "c", 12, MALE);
    private static final Human h3 = new Human("a", "d", "e", 11, MALE);
    private static final Student s1 = new Student("a", "b", "c", 11, MALE,
            "omsu", "imit", "dunno");


    @Test
    public void FunctionTest() {
        assertEquals(Integer.valueOf(5), LambdaRunner.run(LambdaDemo.FUNC_STRING_LENGTH, "qwert"));
        assertEquals(Character.valueOf('q'), LambdaRunner.run(LambdaDemo.FUNC_STRING_FIRST_CHAR, "qwert"));
        assertEquals(Integer.valueOf(10), LambdaRunner.run(LambdaDemo.FUNC_COUNT_WORDS, "qwert,, , 123, 123, 2,,7,,"));
        assertEquals(Integer.valueOf(11), LambdaRunner.run(LambdaDemo.FUNC_GET_AGE, s1));
        assertEquals("c a b", LambdaRunner.run(LambdaDemo.FUNC_COMPILE_FULLNAME, s1));
        assertEquals(h2, LambdaRunner.run(LambdaDemo.FUNC_INCREASE_AGE, h1));
    }

    @Test
    public void PredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.PREDICATE_NO_WHITESPACES, "qwert"));
        assertFalse(LambdaRunner.run(LambdaDemo.PREDICATE_NO_WHITESPACES, "qwer t"));
    }

    @Test
    public void BiPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.BI_PREDICATE_LASTNAME, h1, h2));
        assertFalse(LambdaRunner.run(LambdaDemo.BI_PREDICATE_LASTNAME, h1, h3));
    }

    @Test
    public void QuadroPredicateTest() {
        assertTrue(LambdaRunner.run(LambdaDemo.QU_PREDICATE_NOT_YOUNGER, h1, h2, s1, 13));
        assertFalse(LambdaRunner.run(LambdaDemo.QU_PREDICATE_NOT_YOUNGER, h1, h2, s1, 12));
    }
}
