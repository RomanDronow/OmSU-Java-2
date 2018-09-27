package imit.matrix;

class DemoMatrix {
    public static void main(String[] args) {
        Matrix mx = new Matrix(2);
        double c = 0;
        for (int i = 0; i < mx.getSize(); i++) {
            for (int j = 0; j < mx.getSize(); j++) {
                mx.setElement(i,j,c);
                c++;
            }
        }
        System.out.println(mx.toString());
        System.out.println(mx.calculateDeterminant());
        System.out.println(mx.toString());
    }

}
