package imit.collections;

import java.util.Iterator;

public class DataIterator implements Iterator<Integer> {
    private int groupIndex = 0;
    private int numberIndex = 0;
    private final Data data;

    public DataIterator(Data data) {
        this.data = data;
    }


    @Override
    public boolean hasNext() {
        return groupIndex + 1 < data.getLength() || (groupIndex + 1 == data.getLength()) && (numberIndex < data.getGroups()[groupIndex].getLength());
    }

    @Override
    public Integer next() {
        if (hasNext() && numberIndex < data.getGroups()[groupIndex].getLength()) {
            numberIndex++;
            return data.getGroups()[groupIndex].getData()[numberIndex - 1];
        }
        if (hasNext()) {
            groupIndex++;
            numberIndex = 1;
            return data.getGroups()[groupIndex].getData()[numberIndex - 1];
        }
        return null;
    }
}

