package imit.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {                                                                                          //Task 10-2
    String title;
    Group[] groups;

    public Data(){
        this.title = "default title";
        this.groups = new Group[8];
    }

    public Data(String title, Group[] groups) {
        this.title = title;
        this.groups = groups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getLength(){
        return getGroups().length;
    }

    public DataIterator iterator(){
        return new DataIterator(this);
    }
}
