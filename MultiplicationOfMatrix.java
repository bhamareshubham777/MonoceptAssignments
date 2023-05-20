package assignment4;

import java.util.Scanner;

public class MultiplicationOfMatrix{
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows in first matrix: ");
        int row1 = scanner.nextInt();

        System.out.print("Enter number of columns in first matrix: ");
        int col1 = scanner.nextInt();

        System.out.print("Enter number of rows in second matrix: ");
        int row2 = scanner.nextInt();

        System.out.print("Enter number of columns in second matrix: ");
        int col2 = scanner.nextInt();

        if (row1 != col2) {
            System.out.println("Matrix multiplication is not possible");
            return;
        }

        int firstMatrix[][] = new int[row1][col1];
        int secondMatrix[][] = new int[row2][col2];
        int resultMatrix[][] = new int[row1][col2];

        System.out.println("Enter values for matrix A : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++)
                firstMatrix[i][j] = scanner.nextInt();
        }
        System.out.println("Enter values for matrix B : ");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++)
                secondMatrix[i][j] = scanner.nextInt();
        }

        System.out.println("Matrix multiplication is : ");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                resultMatrix[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

