package imit.matrix;

public interface IMatrix {
    double getElement(int row, int column) throws ArrayIndexOutOfBoundsException;
    void setElement(int row, int column, double elem) throws ArrayIndexOutOfBoundsException;
    double calculateDeterminant() throws ArrayIndexOutOfBoundsException;
    double getDeterminant() throws ArrayIndexOutOfBoundsException;
    int getSize();
    IMatrix transpose();
}
