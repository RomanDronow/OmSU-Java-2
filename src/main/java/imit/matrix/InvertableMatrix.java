package imit.matrix;

import imit.matrix.exceptions.MatrixException;

public class InvertableMatrix extends Matrix implements IInvertableMatrix{

    public InvertableMatrix(int size){
        super(size);
    }

    public InvertableMatrix(Matrix matrix) throws MatrixException {
        this(matrix.getSize());
        if(matrix.calculateDeterminant() == 0) {
            throw new MatrixException("determinant equals to 0");
        }
        this.determinant = matrix.determinant;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                setElement(i,j,matrix.getElement(i,j));
            }
        }
    }

    public Matrix getInvertedMatrix() throws MatrixException {
        Matrix inverseMatrix = new Matrix(getSize());
        Matrix determMatrix = new Matrix(getSize()-1);
        int determMatrixElemCount;

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                determMatrixElemCount = 0;
                for (int k = 0; k < getSize(); k++) {
                    for (int l = 0; l < getSize(); l++) {
                        if (k != i && l != j) {
                            determMatrix.setElement(determMatrixElemCount / determMatrix.getSize(), determMatrixElemCount % determMatrix.getSize(), getElement(k, l));
                            determMatrixElemCount++;
                        }
                    }
                }
                inverseMatrix.setElement(j, i, ((i+j) % 2 == 0 ? 1 : -1 )*determMatrix.calculateDeterminant() / calculateDeterminant());
            }
        }
        return inverseMatrix;
    }
}
