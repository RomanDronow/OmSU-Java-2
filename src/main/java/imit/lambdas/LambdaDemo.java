package imit.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaDemo {
    public static final Function<String, Integer> FUNC_STRING_LENGTH = string -> string == null ? null : string.length();

    public static final Function<String, Character> FUNC_STRING_FIRST_CHAR = string -> string == null && string.length() != 0 ? string.charAt(0) : null;

    public static final Predicate<String> PREDICATE_NO_WHITESPACES = string -> string == null || !string.contains(" ");

    public static final Function<String, Integer> FUNC_COUNT_WORDS = string -> string == null ? null : string.split(",").length;

    public static final Function<Human, Integer> FUNC_AGE = human -> human == null ? null : human.getAge();

    public static final BiPredicate<Human, Human> BI_PREDICATE_LASTNAME = (human1, human2) -> human1 != null && human2 != null && human1.getLastName().equals(human2.getLastName());

    public static final Function<Human, String> FUNC_COMPILE_FULLNAME = human -> {
        return human == null ? null : human.getLastName().concat(" ")
                                .concat(human.getFirstName()).concat(" ")
                                   .concat(human.getMiddleName());
    };
}
