package imit.matrix;

public class InvertableMatrix extends Matrix implements IInvertableMatrix{
    private int size;
    private double[] array;

    public InvertableMatrix(int size) {
        super(size);
    }

    public InvertableMatrix(IMatrix other) throws ArrayIndexOutOfBoundsException {
        super(other);
    }


    @Override
    public IInvertableMatrix invert() throws ArrayIndexOutOfBoundsException {
         double det = this.calculateDeterminant();
         if (det == 0){
             throw new ArrayIndexOutOfBoundsException("Determinant == zero");
         }
         Matrix copy = new Matrix(this);
         return null;
    }

}
