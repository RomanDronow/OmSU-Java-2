package imit.matrix;

import java.io.Serializable;

public class InvertableMatrix extends Matrix implements IInvertableMatrix, Serializable {
    private int size;
    private double[] array;

    public InvertableMatrix(int size) {
        super(size);
    }

    public InvertableMatrix(IMatrix other) throws ArrayIndexOutOfBoundsException {
        super(other);
    }


    @Override
    public IInvertableMatrix invert() throws MatrixException {
        double det = this.calculateDeterminant();
        if (det == 0) {
            throw new MatrixException("Determinant == zero");
        }
        IMatrix minorMatrix = new Matrix(this.getSize());
        for (int i = 0; i < this.getSize(); i++) {
            for (int j = 0; j < this.getSize(); j++) {
                minorMatrix.setElement(i, j, Math.pow(-1, i + j) * getAddMinor(i, j).getDeterminant());
            }
        }
        minorMatrix = minorMatrix.transpose();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                minorMatrix.setElement(i, j, minorMatrix.getElement(i, j) / det);
            }
        }
        InvertableMatrix result = new InvertableMatrix(minorMatrix);
        return result;
    }

}
