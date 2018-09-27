package imit.collections;

import java.util.*;

public class ListDemo {
    public  static int countByChar(List<String> strings, char symbol) {                 // Task 1
        int counter = 0;
        for (String string : strings) if (string.charAt(0) == symbol) counter++;
        return counter;
    }

    public static List<Human> namesakes(List<Human> candidates, Human human) {         // Task 2
        List<Human> confirmed = new ArrayList<>();
        for (Human h : candidates) {
            if (h.getLastName().equals(human.getLastName())) {
                confirmed.add(h);
            }
        }
        return confirmed;
    }

    public static List<Human> removePerson(List<Human> row, Human human) {                     // Task 3
        List<Human> humans = row;
        humans.remove(human);
        return humans;
    }

    public static List<Set<Integer>> notIntersects(List<Set<Integer>> sets, Set<Integer> integerSet) {     // Task 4
        for (Set<Integer> s : sets) {
            int buf = s.size();
            s.retainAll(integerSet);
            if (s.size() != buf) {
                sets.remove(s);
            }
        }
        return sets;
    }

    public static Set<Human> maximalAge(List<? extends Human> people) {                 // Task 5*
        Set<Human> oldies = new HashSet<>();
        int maxAge = 0;
        for(Object person : people){

            if (((Human) person).getAge()> maxAge){
                maxAge = ((Human) person).getAge();
            }
        }
        for (Object person : people){
            if (((Human) person).getAge() == maxAge){
                oldies.add((Human) person);
            }
        }
        return oldies;
    }

    public static Set<Human> humansInSet(HashMap<Integer, Human> humap, Set<Integer> integers){            // Task 7
        Set<Human> result = new HashSet<>();
        for(int num: integers){
            if (humap.containsKey(num)){
                result.add(humap.get(num));
            }
        }
        return result;
    }

    public static Set<Human> humansUnderAge(HashMap<Integer, Human> humap, Set<Integer> integers){         // Task 8
        Set<Human> result = new HashSet<>();
        for(int num: integers){
            if(humap.containsKey(num)&& humap.get(num).getAge()<=18){
                result.add(humap.get(num));
            }
        }
        return result;
    }
}
