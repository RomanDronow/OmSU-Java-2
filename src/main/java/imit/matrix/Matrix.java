package imit.matrix;

import java.util.Arrays;

public class Matrix implements IMatrix {
    private double[] array;
    private int size;


    public Matrix(int size) {
        this.size = size;
        array = new double[size * size];
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
        if (size == 2) {
            return array[0] * array[3] - array[1] * array[2];
        }
        return 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.array);
    }

    public void doTriangleMatrix() {
        for (int i = 0; i < size - 1; i++) {
            double tmp = getElement(i,i);
        }
    }
}
