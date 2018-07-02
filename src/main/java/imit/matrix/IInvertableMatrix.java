package imit.matrix;

import imit.matrix.exceptions.MatrixException;

public interface IInvertableMatrix extends IMatrix{
    Matrix getInvertedMatrix() throws MatrixException;
}       //Task 2
