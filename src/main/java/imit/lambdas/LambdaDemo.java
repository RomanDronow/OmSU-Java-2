package imit.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

class LambdaDemo {
    public static final Function<String, Integer> FUNC_STRING_LENGTH = string -> string == null ? null : string.length();

    public static final Function<String, Character> FUNC_STRING_FIRST_CHAR = string -> string.length() == 0 ? null : string.charAt(0);

    public static final Predicate<String> PREDICATE_NO_WHITESPACES = string -> string == null || !string.contains(" ");

    public static final Function<String, Integer> FUNC_COUNT_WORDS = string -> {
        int counter = 0;
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) == ',')
                counter++;
        return counter + 1;
    };

    public static final Function<Human, Integer> FUNC_GET_AGE = human -> human == null ? null : human.getAge();

    public static final BiPredicate<Human, Human> BI_PREDICATE_LASTNAME = (human, human2) -> human != null && human2 != null && human.getLastName().equals(human2.getLastName());

    public static final Function<Human, String> FUNC_COMPILE_FULLNAME = human -> human == null ? null : human.getLastName().concat(" ")
                            .concat(human.getFirstName()).concat(" ")
                               .concat(human.getMiddleName());

    public static final Function<Human, Human> FUNC_INCREASE_AGE = human -> {
        if (human == null) {
            return null;
        }
        return new Human(human.getFirstName(),human.getMiddleName(),human.getLastName(),human.getAge()+1,human.getSex());
    };

    public static final QuPredicate<Human,Human,Human,Integer> QU_PREDICATE_NOT_YOUNGER = (human, human2, human3, age) -> {
      if (human != null && human2 != null && human3 != null){
          return human.getAge() < age && human2.getAge() < age && human3.getAge() < age;
      }
      return false;
    };
}
