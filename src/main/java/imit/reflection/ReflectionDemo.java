package imit.reflection;

import imit.collections.Human;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class ReflectionDemo {

    public static int countHumans(List list){
        int counter = 0;
        for (Object obj : list){
            if (obj instanceof Human){
                counter++;
            }
        }
        return counter;
    }

    public static List<String> getPublicMethods(Object object){
        List<String> list = new ArrayList<>();
        Method[] methods = object.getClass().getMethods();
        for (Method m : methods){
            list.add(m.getName());
        }
        return list;
    }

    public static List<String> getSupeclasses(Object object){
        List<String> list = new ArrayList<>();
        Class superclass = object.getClass().getSuperclass();
        while (superclass != null){
            list.add(superclass.getName());
            superclass = superclass.getSuperclass();
        }
        return list;
    }
}
