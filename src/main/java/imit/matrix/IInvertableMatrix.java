package imit.matrix;

public interface IInvertableMatrix extends IMatrix{
    IMatrix invert() throws MatrixException;
}
