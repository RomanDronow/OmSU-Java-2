package imit.matrix;

import com.google.gson.Gson;
import imit.matrix.exceptions.MatrixException;

import java.io.*;

public class DemoMatrix {

    public static void printMatrix(Matrix matrix, OutputStream os) throws IOException, MatrixException {
        if (!os.equals(System.out)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write(Integer.toString(matrix.getSize()));
            bw.newLine();
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    bw.write(String.format("%.2f ",matrix.getElement(i,j)));
                }
            }
            bw.close();
        } else {
            System.out.println(Integer.toString(matrix.getSize()));
            for (int i = 0; i < matrix.getSize(); i++) {
                for (int j = 0; j < matrix.getSize(); j++) {
                    System.out.print(String.format("%.2f ", matrix.getElement(i, j)));
                }
            }
        }
    }

    public static Matrix readMatrix(InputStream is) throws IOException, MatrixException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Matrix matrix = new Matrix(Integer.parseInt(br.readLine()));
        for (int i = 0; i < matrix.getSize(); i++) {
            String[] mrow = br.readLine().split(" ");
            for (int j = 0; j < matrix.getSize(); j++) {
                matrix.setElement(i, j, Double.parseDouble(mrow[j].replace(',', '.')));
            }
        }
        br.close();
        return matrix;
    }

    public static double sumMatrix(Matrix matrix) throws MatrixException {
        double sum = 0;
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize(); j++) {
                sum += matrix.getElement(i, j);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws MatrixException, IOException {
        Matrix matrix = readMatrix(new FileInputStream(new File("matrix.txt")));
        printMatrix(matrix, System.out);





    /*    try {
            Matrix matrix = readMatrix(new FileInputStream(new File("matrix.txt")));
            printMatrix(matrix, System.out);
            System.out.printf("determ = %.2f\n", matrix.calculateDeterminant());

            matrix.setElement(2, 2, 22);
            printMatrix(matrix, System.out);
            System.out.printf("determ = %.2f\n", matrix.calculateDeterminant());

            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("serialize.txt")));
            new Gson().toJson(matrix, bw);
            bw.close();

            BufferedReader br = new BufferedReader(new FileReader(new File("serialize.txt")));
            Matrix deserializedMatrix = new Gson().fromJson(br, Matrix.class);
            br.close();
            printMatrix(deserializedMatrix, System.out);

            InvertableMatrix invmatrix = new InvertableMatrix(readMatrix(new FileInputStream(new File("invmatrix.txt"))));
            printMatrix(invmatrix, System.out);
            Matrix inverseMatrix = invmatrix.getInvertedMatrix();
            printMatrix(inverseMatrix, System.out);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
