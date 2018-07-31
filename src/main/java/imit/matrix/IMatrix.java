package imit.matrix;

public interface IMatrix {

    int getSize();
    double get(int i, int j);
    void set(int i, int j, double value);
    double getDeterminant();
    IMatrix getCofactor(int row, int col);
    IMatrix transpose();

}
