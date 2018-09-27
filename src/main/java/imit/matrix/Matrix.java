package imit.matrix;

import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix {
    private final double[] array;
    private final int size;


    public Matrix(int size) {
        this.size = size;
        array = new double[size * size];
    }

    public Matrix(IMatrix other) {
        this(other.getSize());
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setElement(i, j, other.getElement(i, j));
            }
        }
    }

    @Override
    public double getElement(int row, int column) {
        return array[row * size + column];
    }

    @Override
    public void setElement(int row, int column, double elem) {
        array[row * size + column] = elem;
    }

    @Override
    public double calculateDeterminant() {

        Matrix bff = new Matrix(this);

        int c = 1;
        boolean isChanged = false;
        while (getElement(0, 0) == 0) {
            swapRows(c);
            c++;
            isChanged = true;
        }

        double result = 1;
        Matrix tmp = new Matrix(this);


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    this.setElement(j, k, tmp.getElement(j, k));
                }
            }

            for (int j = i + 1; j < size; j++) {
                for (int k = i; k < size; k++) {
                    double temp = tmp.getElement(j, k) - tmp.getElement(i, k) * this.getElement(j, i) / tmp.getElement(i, i);
                    tmp.setElement(j, k, temp);
                }
            }
        }

        for (int i = 0; i < size; i++) {
            result = result * tmp.getElement(i, i);
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                setElement(i, j, bff.getElement(i, j));
            }
        }

        if (isChanged) {
            return -result;
        }
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

    private void swapRows(int row2) {
        double[] buffer = new double[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = getElement(0, i);
            setElement(0, i, getElement(row2, i));
            setElement(row2, i, buffer[i]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return size == matrix.size &&
                Arrays.equals(array, matrix.array);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }
}
