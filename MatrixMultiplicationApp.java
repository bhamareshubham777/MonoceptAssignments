package com.techlabs.assignments;

import java.util.Scanner;

public class MatrixMultiplicationApp{
	private static Scanner scanner = new Scanner(System.in);
	private static int row1, row2, col1, col2;
	private static int firstMatrix[][];
	private static int secondMatrix[][];
	private static int resultMatrix[][];
	
    public static void main(String args[]) {     
        acceptMatrixSize();
        checkMatrixSize();
        createMatrices();
        acceptFirstMAtrix();
        acceptSecondMatrix();
        getMatrixMultiplication();
    }

	private static void acceptMatrixSize() {
		 System.out.print("Enter number of rows in first matrix: ");
	     row1 = scanner.nextInt();

	     System.out.print("Enter number of columns in first matrix: ");
	     col1 = scanner.nextInt();

	     System.out.print("Enter number of rows in second matrix: ");
	     row2 = scanner.nextInt();

	     System.out.print("Enter number of columns in second matrix: ");
	     col2 = scanner.nextInt();
		
	}
	
	private static void checkMatrixSize() {
		if (col1 != row2) {
            System.out.println("Matrix multiplication is not possible");
            System.exit(0);
        }		
	}
	
	private static void createMatrices() {
		firstMatrix = new int[row1][col1];
        secondMatrix = new int[row2][col2];
        resultMatrix = new int[row1][col2];
	}
	
	private static void acceptFirstMAtrix() {
		 System.out.println("Enter values for first matrix : ");
		 
	        for (int i = 0; i < row1; i++) 
	            acceptColumnsOfFirstMatrix(i);
	        
	}
	
	private static void acceptColumnsOfFirstMatrix(int i) {
		for (int j = 0; j < col1; j++)
            firstMatrix[i][j] = scanner.nextInt();
		
	}

	private static void acceptSecondMatrix() {
		 System.out.println("Enter values for second matrix : ");
		 
	        for (int i = 0; i < row2; i++) 
	            acceptColumnsOfSecondMatrix(i);
	        
	}

	private static void acceptColumnsOfSecondMatrix(int i) {
		for (int j = 0; j < col2; j++)
            secondMatrix[i][j] = scanner.nextInt();
		
	}

	private static void getMatrixMultiplication() {
		System.out.println("Matrix multiplication is : ");
		
        for (int i = 0; i < row1; i++) {
            multiplyFirst(i);
            System.out.println();
        }
	}

	private static void multiplyFirst(int i) {
		for (int j = 0; j < col2; j++) {
            multiplySecond(i,j);
             System.out.print(resultMatrix[i][j] + " ");
         }
	}

	private static void multiplySecond(int i, int j) {
		 resultMatrix[i][j] = 0;
         for (int k = 0; k < col1; k++) {
             resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
         }
	}

}


