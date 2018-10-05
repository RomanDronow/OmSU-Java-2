package imit.matrix;

class DemoMatrix {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
        double start = System.nanoTime();
        Matrix m1 = new Matrix(50);
        /*m1.setElement(0,0,11);
        m1.setElement(0,1,4);
        m1.setElement(0,2,5);
        m1.setElement(1,0,-2);
        m1.setElement(1,1,3);
        m1.setElement(1,2,4);
        m1.setElement(2,0,5);
        m1.setElement(2,1,1);
        m1.setElement(2,2,2);*/
        double c = 1;
        for (int i = 0; i < m1.getSize(); i++) {
            for (int j = 0; j < m1.getSize(); j++) {
                m1.setElement(i,j,c);
                c++;
            }
        }
        System.out.println(m1.getDeterminant());
        System.out.println((System.nanoTime() - start)/1000000000);
    }

}
