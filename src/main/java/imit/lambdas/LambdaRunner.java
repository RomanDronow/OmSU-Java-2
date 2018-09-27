package imit.lambdas;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdaRunner {

    public static <T> boolean run(Predicate<T> f, T t) {
        return f.test(t);
    }

    public static <T, R> R run(Function<T, R> f, T t) {
        return f.apply(t);
    }

    public static <U, V> boolean run(BiPredicate<U, V> f, U u, V v) {
        return f.test(u, v);
    }

    public static <T1, T2, T3, T4> boolean run(QuPredicate<T1, T2, T3, T4> f, T1 t1, T2 t2, T3 t3, T4 t4) {
        return f.test(t1, t2, t3, t4);
    }
}
