package org.hong.javafundamental.algorithm;

public class Matrix {
	
	private int rows;
	private int columns;
	
	private int[][] elements;
	private static final String WHITE_SPACE = " ";
	
	public static final int ZERO = 0;
	
	Matrix(int rows, int columns, int[][] elements) {
		this.rows = rows;
		this.columns = columns;
		this.elements = elements;	
	}
	
	public void printMatrixInSpiralForm() {
		
		// Traverse through one row or column
		int iterator;
		int startingRowIndex = 0;
		int startingColumnIndex = 0;
		int endingRowIndex = rows;
		int endingColumnIndex = columns;
		
		if (rows == ZERO || columns == ZERO) {
			System.out.println("Matrix must contain at least one row and one column!");
		}
		else {
			System.out.println("Printing the Matrix in Spiral Form:");
			while (startingColumnIndex < endingColumnIndex && startingRowIndex < endingRowIndex) {
				// Print the first row from left to right from remaining rows of matrix
				for (iterator = startingColumnIndex; iterator < endingColumnIndex; iterator++) {
					System.out.print(elements[startingRowIndex][iterator] + WHITE_SPACE);
				}
				// Increase the startingRowIndex to mark down the printing of first row
				startingRowIndex++;
				
				// Print the last column from top to bottom from the remaining columns of matrix
				for (iterator = startingRowIndex; iterator < endingRowIndex; iterator++) {
					System.out.print(elements[iterator][endingColumnIndex - 1] + WHITE_SPACE);
				}
				// Decrease the endingColumnIndex to mark down the printing of last column
				endingColumnIndex--;
				
				// Print the last row from right to left from remaining rows of matrix
				if (startingRowIndex < endingRowIndex) {
					for (iterator = endingColumnIndex - 1; iterator >= startingColumnIndex; iterator--) {
						System.out.print(elements[endingRowIndex - 1][iterator] + WHITE_SPACE);
					}
					// Decrease the endingRowIndex to mark down the printing of last row
					endingRowIndex--;
				}
				
				// Print the first column from bottom to top from the remaining columns of matrix
				if(startingColumnIndex < endingColumnIndex) {
					for (iterator = endingRowIndex - 1; iterator >= startingRowIndex; iterator--) {
						System.out.print(elements[iterator][startingColumnIndex] + WHITE_SPACE);
					}
					// Decrease the endingColumnIndex to mark down the printing of last column
					startingColumnIndex++;
				}
					
			}
		}
	}

}
