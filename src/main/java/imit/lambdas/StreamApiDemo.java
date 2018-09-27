package imit.lambdas;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiDemo extends LambdaDemo {
    public static final Function<List<Object>, List<Object>> FUNCTION_REMOVE_ALLNULL =
            list -> list != null ? list.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()) : null;

    public static final Function<Set<Integer>, Long> FUNCTION_FIND_POSITIVES =
            set -> set != null ? set.stream()
                    .filter(integer -> integer > 0)
                    .count() : null;

    public static final Function<List<Object>,List<Object>> FUNCTION_GET_LAST_THREE =
            list -> list != null ? list.stream()
                    .skip(list.size() - 3)
                    .collect(Collectors.toList()) : null;

    public static final Function<List<Integer>,Integer> FUNCTION_GET_FIRST_ODD =
            list -> list != null ? list.stream()
                    .filter(integer -> integer % 2 == 0)
                    .findFirst()
                    .orElse(null): null;

    public static final Function<Integer[], List<Integer>> FUNCTION_GET_SQUARES_LIST =
            array -> new ArrayList<>(Arrays.stream(array)
                    .map(integer -> integer*integer)
                    .collect(Collectors.toSet()));

    public static final Function<List<String>, List<String>> FUNCTION_GET_NOT_EMPTY_STRINGS =
            list -> list != null ? list.stream()
                    .filter(string -> !"".equals(string))
                    .sorted()
                    .collect(Collectors.toList()) : null;

    public static final Function<Set<String>, List<String>> FUNCTION_SETTOLIST_SORT_BACK =
            set -> set != null ? set.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList()) : null;

    public static final Function<Set<Integer>, Integer> FUNCTION_SUM_OF_SQUARES =
            set -> set != null ? set.stream()
                    .map(integer -> integer*integer)
                    .reduce((a,b) -> a + b).orElse(0): null;

    public static final Function<Collection<Human>, Integer> FUNCTION_SORT_PEOPLE =
            c -> c != null ? c.stream()
                    .max(Comparator.comparingInt(Human::getAge))
                    .map(Human::getAge).orElse(null)
                    : null;
}

