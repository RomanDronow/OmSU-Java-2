package imit.matrix;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class DemoMatrix {

    public static void print(OutputStream os, IMatrix m) {
        PrintStream ps = new PrintStream(os);
        int size = m.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                ps.format(Locale.US, "%+.6f\t", m.get(i, j));
            ps.print("\n");
        }
        ps.close();
    }

    public static IMatrix read(InputStream is) throws IllegalStateException {
        Scanner s = new Scanner(is);
        s.useLocale(Locale.US);
        if (!s.hasNext())
            throw new IllegalStateException("The provided stream is empty.");
        int size = s.nextInt();
        IMatrix m = new Matrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!s.hasNext())
                    throw new IllegalStateException("The provided stream data is corrupt.");
                m.set(i, j, s.nextDouble());
            }
        }
        return m;
    }

    public static double sum(IMatrix m) {
        double sum = 0;
        for (int i = 0; i < m.getSize(); i++)
            for (int j = 0; j < m.getSize(); j++)
                sum += m.get(i, j);
        return sum;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IMatrix m1;
        m1 = read(new FileInputStream("input.txt"));
        print(System.out, m1);
        System.out.println("Sum = " + sum(m1));
        System.out.println("Det = " + m1.getDeterminant());
        m1.set(0, 0, -5);
        print(System.out, m1);
        System.out.println("Sum = " + sum(m1));
        System.out.println("Det = " + m1.getDeterminant());
        IInvertedMatrix m2 = new InvertedMatrix(m1);
        print(System.out, m2.getInvertedMatrix());
        print(System.out, m2.getInvertedMatrix().getInvertedMatrix());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output.dat"));
        oos.writeObject(m1);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output.dat"));
        IMatrix m3 = (IMatrix) ois.readObject();
        print(System.out, m3);
        try {
            m1.set(2, 2, 2);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        try {
            ois = new ObjectInputStream(new FileInputStream("123.dat"));
            m3 = (IMatrix) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
//        try {
//            ois = new ObjectInputStream(new FileInputStream("input.txt"));
//            m3 = (IMatrix) ois.readObject();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//      }
    }
}
