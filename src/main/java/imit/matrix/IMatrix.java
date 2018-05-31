package imit.matrix;

import imit.matrix.exceptions.OutOfBoundsException;

public interface IMatrix {

    double getElement(int x, int y) throws OutOfBoundsException;
    void setElement(int y, int x, double value) throws OutOfBoundsException;
    double calculateDeterminant() throws OutOfBoundsException ;
    int getSize();
}
