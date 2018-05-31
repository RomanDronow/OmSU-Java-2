package imit.collections;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
    String title;
    Set<Group> groups;

    public Data(){
        this.title = "default title";
        this.groups = new HashSet<Group>();
    }

    public Data(String title, Set<Group> groups) {
        this.title = title;
        this.groups = groups;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public int getSize(){
        return getGroups().size();
    }

    public DataIterator iterator(){
        return new DataIterator(this);
    }
}
