package imit.matrix;

import java.io.Serializable;
import java.util.Arrays;

public class Matrix implements IMatrix, Serializable {
    private final double[] matrix;
    private final int size;
    private double determinantCache;
    private boolean determinantCached;

    public Matrix(int n) {
        matrix = new double[n * n];
        size = n;
        determinantCache = 0;
        determinantCached = false;
    }

    public Matrix(IMatrix other) {
        this(other.getSize());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                set(i, j, other.get(i, j));
            }
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix1 = (Matrix) o;
        if (size != matrix1.size)
            return false;
        boolean notEqual = false;
        outer:
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (Math.abs(get(i, j) - matrix1.get(i, j)) > 0.0000000001) {
                    notEqual = true;
                    break outer;
                }
        return !notEqual;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public double get(int i, int j) {
        if (i < 0 || j < 0 || i >= size || j >= size)
            throw new ArrayIndexOutOfBoundsException();
        return matrix[i * size + j];
    }

    @Override
    public void set(int i, int j, double value) {
        if (i < 0 || j < 0 || i >= size || j >= size)
            throw new ArrayIndexOutOfBoundsException();
        determinantCached = false;
        matrix[i * size + j] = value;
    }

    public Matrix getCofactor(int row, int col) {
        Matrix res = new Matrix(size - 1);
        for (int i = 0; i < size; i++) {
            if (i == row)
                continue;
            for (int j = 0; j < size; j++) {
                if (j == col)
                    continue;
                res.set(i >= row ? i - 1 : i, j >= col ? j - 1 : j, get(i, j));
            }
        }
        return res;
    }

    @Override
    public IMatrix transpose() {
        IMatrix transposed = new Matrix(this);
        double tmp;
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++) {
                tmp = transposed.get(i, j);
                transposed.set(i, j, transposed.get(j, i));
                transposed.set(j, i, tmp);
            }
        return transposed;
    }

    @Override
    public double getDeterminant() {
        if (determinantCached)
            return determinantCache;
        determinantCache = calculateDeterminant();
        determinantCached = true;
        return determinantCache;
    }

    private double calculateDeterminant() {
        if (size == 1)
            return matrix[0];

        double res = 0;
        int sign = 1;
        for (int col = 0; col < size; col++) {
            res += sign * get(0, col) * getCofactor(0, col).getDeterminant();
            sign *= -1;
        }

        return res;
    }
}
