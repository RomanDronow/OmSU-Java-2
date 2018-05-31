package imit.collections;

import org.junit.Test;

import java.util.*;

import static imit.collections.ListDemo.*;
import static org.junit.Assert.assertEquals;

public class TestList {

    @Test
    public void testCountByChar(){
        List<String> sample = new ArrayList<String>();
        sample.add("abc");
        sample.add("abd");
        sample.add("bca");
        sample.add("cda");
        sample.add("aca");
        assertEquals(3, countByChar(sample, 'a'));
    }

    @Test
    public void testNamesakes(){
        List<Human> candidates = new ArrayList<>();
        Human person = new Human();
        Human candidate = new Human("Roman", "Sergeevich", "Dronov", 19 );
        Human candidate2 = new Human("Igor", "Igorevich", "Ivanov", 21);
        Human candidate3 = new Human();
        candidates.add(candidate);
        candidates.add(candidate2);
        candidates.add(candidate3);
        assertEquals(2, namesakes(candidates, person).size());
    }

    @Test
    public void testStalin(){
        List<Human> row = new ArrayList<>();
        Human prey = new Human("Ivan", "Ivanovich", "Ivanov", 18);
        Human candidate = new Human("Roman", "Sergeevich", "Dronov", 19 );
        Human candidate2 = new Human("Igor", "Igorevich", "Ivanov", 21);
        Human candidate3 = new Human();
        Human candidate4 = new Human("Ivan", "Ivanovich", "Ivanov", 19);
        row.add(candidate);
        row.add(candidate2);
        row.add(candidate3);
        row.add(candidate4);
        assertEquals(3, stalin(row, prey).size());
    }

    @Test
    public void testNotIntersects(){
        List<Set<Integer>> sets = new ArrayList<>();
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        Set<Integer> controlSet = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        controlSet.add(4);
        controlSet.add(5);
        controlSet.add(6);
        sets.add(set1);
        sets.add(set2);
        assertEquals(1, notIntersects(sets,controlSet).size());
    }

    @Test
    public void testMaxAge(){
        ArrayList<Human> people = new ArrayList<>();
        Student stud = new Student("IMIT");
        Human hum1 = new Human();
        Human hum2 = new Human("Oleg", "Oleg", "Oleg", 34);
        Human hum3 = new Human("Oleg", "Oleg", "Olehghyuhuyg", 34);
        people.add(hum1);
        people.add(hum2);
        people.add(hum3);
      people.add(stud);
        assertEquals(2, maximalAge(people).size());
    }

    @Test
    public void testHumansInSet(){
        HashMap<Integer, Human> humap = new HashMap<>();
        Set<Integer> pasta = new HashSet<>();
        pasta.add(1);
        pasta.add(3);
        Human hum1 = new Human();
        Human hum2 = new Human("Oleg", "Oleg", "Oleg", 34);
        Human hum3 = new Human("Oleg", "Oleg", "Olehghyuhuyg", 34);
        humap.put(1,hum1);
        humap.put(2,hum2);
        humap.put(3,hum3);
        assertEquals("[Human{Ivan Ivanovich Ivanov , age=18}, Human{Oleg Oleg Olehghyuhuyg , age=34}]", humansInSet(humap, pasta).toString());
    }

    @Test
    public void testHumansUnderAge(){
        HashMap<Integer, Human> humap = new HashMap<>();
        Set<Integer> pasta = new HashSet<>();
        pasta.add(1);
        pasta.add(3);
        Human hum1 = new Human();
        Human hum2 = new Human("Oleg", "Oleg", "Oleg", 34);
        Human hum3 = new Human("Oleg", "Oleg", "Olehghyuhuyg", 34);
        humap.put(1,hum1);
        humap.put(2,hum2);
        humap.put(3,hum3);
        assertEquals(1, humansUnderAge(humap,pasta));
    }

    @Test
    public void testGroups(){

    }
}
