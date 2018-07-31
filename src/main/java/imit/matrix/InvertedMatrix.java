package imit.matrix;

import java.io.Serializable;

public class InvertedMatrix extends Matrix implements IInvertedMatrix, Serializable {

    public InvertedMatrix(int n) {
        super(n);
    }

    public InvertedMatrix(IMatrix other) {
        super(other);
    }

    @Override
    public IInvertedMatrix getInvertedMatrix() throws IllegalStateException {
        double d = getDeterminant();
        if (d == 0)
            throw new IllegalStateException("Matrix Determinant equals zero.");
        IMatrix adjugateMatrix = new Matrix(getSize());
        for (int i = 0; i < getSize(); i++)
            for (int j = 0; j < getSize(); j++)
                adjugateMatrix.set(i, j, Math.pow(-1, i + j) * getCofactor(i, j).getDeterminant());
        adjugateMatrix = adjugateMatrix.transpose();
        for (int i = 0; i < getSize(); i++)
            for (int j = 0; j < getSize(); j++)
                adjugateMatrix.set(i, j, adjugateMatrix.get(i, j) / d);
        return new InvertedMatrix(adjugateMatrix);
    }

}