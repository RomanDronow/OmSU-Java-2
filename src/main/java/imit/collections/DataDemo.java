package imit.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataDemo {
    public static List<Integer> getAll(Data data) {
        List<Integer> list = new ArrayList<>();
        Iterator dataIterator = data.iterator();
        while (dataIterator.hasNext()) {
            list.add((Integer) dataIterator.next());
        }
        return list;
    }
}