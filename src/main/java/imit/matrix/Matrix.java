package imit.matrix;

import imit.matrix.exceptions.OutOfBoundsException;

import java.util.Arrays;

public class Matrix implements IMatrix {
    protected int x, y;
    protected double[] matrix;
    protected double determinant;
    protected int size;
    protected boolean isCalculated;

    public Matrix(){
        size = 1;
        matrix = new double[size*size];
        matrix[0] = 1;
        isCalculated = false;
    }
    public Matrix(int size) {
        this.size = size;
        matrix = new double[size * size];
        isCalculated = false;
    }

    public Matrix(Matrix other) {
        this.size = other.size;
        this.matrix = Arrays.copyOf(other.matrix, other.size);
        this.isCalculated = false;
    }

    public double getElement(int x, int y) throws OutOfBoundsException {
        if ((x >= size || x < 0) || (y >= size || y < 0)) {
            throw new OutOfBoundsException();
        }
        return matrix[x * size + y];
    }

    public void setElement(int y, int x, double value) throws OutOfBoundsException {
        if ((x >= size || x < 0) || (y >= size || y < 0)) {
            throw new OutOfBoundsException();
        }
        matrix[this.x * size + this.y] = value;
    }

    public double calculateDeterminant() throws OutOfBoundsException {
        if (isCalculated) {
            return this.determinant;
        }
        Matrix strom = new Matrix(this);
        double determinant = 1.0, temp = 0, dtemp = 0;
        int place;
        boolean rowNotEmpty = false;
        for (int k = 0; k < size; k++) {
            place = k;
            for (int i = 0; i < size; i++) {
                if (strom.getElement(i, k) != 0) {
                    place = i;
                    rowNotEmpty = true;
                    if (place >= k) {
                        break;
                    }
                }
            }
            if (place > k){
                for (int i = 0; i < size; i++){
                    dtemp = strom.getElement(k,i);
                    strom.setElement(k, i, strom.getElement(place,i));
                    strom.setElement(place,i,dtemp);
                }
                determinant *= -1;
            }
            if (!rowNotEmpty) {
                return 0;
            }
            temp = strom.getElement(k, k);
            determinant *= temp;
            for (int i = k+1; i < size; i++) {
                dtemp = strom.getElement(i, k) / temp;
                for (int j = k+1; j < size; j++) {
                    strom.setElement(i, j, strom.getElement(i, j) - strom.getElement(k, j) * dtemp);
                }
            }
            rowNotEmpty = false;
        }
        this.determinant = determinant;
        isCalculated = true;
        return determinant;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix1 = (Matrix) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }
}
