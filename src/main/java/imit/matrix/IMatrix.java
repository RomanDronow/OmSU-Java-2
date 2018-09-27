package imit.matrix;

public interface IMatrix {
    double getElement(int row, int column);
    void setElement(int row, int column, double elem);
    double calculateDeterminant();
    int getSize();
}
