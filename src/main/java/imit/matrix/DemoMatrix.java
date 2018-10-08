package imit.matrix;

import java.io.*;

public class DemoMatrix {
    public static void write(IMatrix matrix, File file) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(String.valueOf(matrix.getSize()));
            bw.newLine();
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    bw.write(String.valueOf(matrix.getElement(i, j)) + " ");
                }
                bw.newLine();
            }
        }
    }

    public static Matrix read(File file) throws MatrixException, IOException {
        Matrix matrix = null;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int size;
            try {
                size = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                throw new MatrixException("No size written!");
            }
            matrix = new Matrix(size);
            String[] line;
            for (int i = 0; i < size; i++) {
                line = br.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    matrix.setElement(i, j, Double.parseDouble(line[j]));
                }
            }
        }
        return matrix;
    }

    public static double sum(IMatrix matrix) {
        double res = 0;
        for (int i = 0; i < Math.pow(matrix.getSize(), 2); i++) {
            res += matrix.getElement(i / matrix.getSize(), i % matrix.getSize());
        }
        return res;
    }

    public static void print(IMatrix matrix) {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                System.out.print(String.valueOf(matrix.getElement(i, j)) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3);
        matrix.setElement(0, 1, 2.4);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test.dat"))) {
            oos.writeObject(matrix);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test.dat"))) {
            matrix = (Matrix) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        print(matrix);
        System.out.println(sum(matrix));
    }
}
