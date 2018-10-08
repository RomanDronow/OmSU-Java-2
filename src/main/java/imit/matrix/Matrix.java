package imit.matrix;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Matrix implements IMatrix, Serializable {
    private final double[] array;
    private final int size;
    private double determinant;
    private boolean detCalculated;

    public Matrix() {
        size = 3;
        array = new double[size * size];
        determinant = 0;
        detCalculated = false;
    }

    public Matrix(int size) {
        this.size = size;
        array = new double[size * size];
        determinant = 0;
        detCalculated = false;
    }

    public Matrix(IMatrix other) throws ArrayIndexOutOfBoundsException {
        size = other.getSize();
        array = new double[size * size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                setElement(row, col, other.getElement(row, col));
            }
        }
        this.determinant = other.getDeterminant();
        detCalculated = true;
    }

    @Override
    public double getElement(int row, int column) throws ArrayIndexOutOfBoundsException {
        if (row < 0 || column < 0 || row >= size || column >= size)
            throw new ArrayIndexOutOfBoundsException("Out of borders");
        return array[row * size + column];
    }

    @Override
    public void setElement(int row, int column, double elem) throws ArrayIndexOutOfBoundsException {
        if (row < 0 || column < 0 || row >= size || column >= size)
            throw new ArrayIndexOutOfBoundsException("Out of borders");
        detCalculated = false;
        array[row * size + column] = elem;
    }

    @Override
    public double calculateDeterminant() throws ArrayIndexOutOfBoundsException {
        if (size == 2) {
            detCalculated = true;
            determinant = array[0] * array[3] - array[1] * array[2];
            return determinant;
        }
        double det = 0;
        int sign = 1;
        for (int col = 0; col < size; col++) {
            det += sign * getElement(0, col) * getAddMinor(0, col).getDeterminant();
            sign *= -1;
        }
        detCalculated = true;
        determinant = det;
        return determinant;
    }

    public Matrix getAddMinor(int row, int column) throws ArrayIndexOutOfBoundsException {
        Matrix result = new Matrix(size - 1);
        for (int i = 0; i < size; i++) {
            if (i == row)
                continue;
            for (int j = 0; j < size; j++) {
                if (j == column)
                    continue;
                result.setElement(i >= row ? i - 1 : i, j >= column ? j - 1 : j, getElement(i, j)); // спасибо идее за супер сокращения, я даже в комменты вынес
                /*if (i >= row) {                                                                      то, что сначала было
                    if (j >= column) {
                        result.setElement(i - 1, j - 1, getElement(i, j));
                    } else {
                        result.setElement(i - 1, j, getElement(i, j));
                    }
                } else {
                    if (j >= column) {
                        result.setElement(i, j - 1, getElement(i, j));
                    } else {
                        result.setElement(i, j, getElement(i, j));
                    }
                }*/
            }
        }
        return result;
    }


    @Override
    public double getDeterminant() throws ArrayIndexOutOfBoundsException {
        if (detCalculated) {
            return determinant;
        }
        determinant = calculateDeterminant();
        detCalculated = true;
        return determinant;

    }

    @Override
    public IMatrix transpose() {
        IMatrix transposed = new Matrix(this);
        double tmp;
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++) {
                tmp = transposed.getElement(i, j);
                transposed.setElement(i, j, transposed.getElement(j, i));
                transposed.setElement(j, i, tmp);
            }
        return transposed;
    }

    @Override
    public int getSize() {
        return size;
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
        result = 13 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
