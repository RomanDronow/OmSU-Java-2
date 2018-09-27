package imit.collections;

import java.util.*;

class    PhoneBook {                            // Task 9*
    private final Map<Human, List<String>> phonebook;

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    public void addNumber(Human name, String number) {
        phonebook.putIfAbsent(name, new ArrayList<>());
        phonebook.get(name).add(number);
    }

    public void removeNumber(Human name, String number) {
        List<String> temp = phonebook.get(name);
        temp.remove(number);
        phonebook.put(name, temp);
    }

    public List<String> getNumbersByName(Human name) {
        return phonebook.get(name);
    }

    public Human findHumanByNumber(String number) {
        Set<Map.Entry<Human, List<String>>> set = phonebook.entrySet();
        for (Map.Entry<Human, List<String>> entry : set) {
            if (entry.getValue().contains(number)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
