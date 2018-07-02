package imit.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {

    public static boolean testString(Predicate<String> predicate, String string){
        return predicate.test(string);
    }

    public static Human humanOperation(UnaryOperator<Human> operator, Human human){
        return operator.apply(human);
    }

    public static boolean testThreeHuman(QuPredicate<Human,Human,Human,Integer> quPredicate, Human h, Human h2, Human h3, Integer age){
        return quPredicate.test(h,h2,h3,age);
    }

    public static boolean testTwoHumans(BiPredicate<Human,Human> biPredicate, Human h, Human h2){
        return biPredicate.test(h,h2);
    }

    public static <T,U> T process(Function<U, T> function, U u){
        return function.apply(u);
    }
}
