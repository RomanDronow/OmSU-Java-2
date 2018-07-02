package imit.lambdas;

@FunctionalInterface
public interface QuPredicate<T,U,V,W> {
    boolean test(T t, U u, V v, W w);
}
