package imit.matrix;

import imit.matrix.exceptions.MatrixException;

public interface IMatrix {

    double getElement(int x, int y) throws MatrixException;
    void setElement(int y, int x, double value) throws MatrixException;
    double calculateDeterminant() throws MatrixException;
    int getSize();
}       // Task 1
