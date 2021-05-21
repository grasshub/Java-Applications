package org.hong.javafundamental.algorithm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Matrix {

    private final int rows;
    private final int columns;

    private final int[][] elements;
    private static final String WHITE_SPACE = " ";

    public static final int ZERO = 0;

    public void printMatrixInSpiralForm() {

        // Traverse through one row or column
        var startingRowIndex = 0;
        var startingColumnIndex = 0;

        if (rows == ZERO || columns == ZERO) {
            System.out.println("Matrix must contain at least one row and one column!");
        } else {
            System.out.println("Printing the Matrix in Spiral Form:");
            printMatrix(startingRowIndex, startingColumnIndex, rows, columns);
        }
    }

    private void printMatrix(int startingRowIndex, int startingColumnIndex, int endingRowIndex,
                             int endingColumnIndex) {
        while (startingColumnIndex < endingColumnIndex && startingRowIndex < endingRowIndex) {
            // Print the first row from left to right from remaining rows of matrix
            startingRowIndex = getStartingRowIndex(startingRowIndex, startingColumnIndex, endingColumnIndex);

            // Print the last column from top to bottom from the remaining columns of matrix
            endingColumnIndex = getEndingColumnIndex(startingRowIndex, endingRowIndex, endingColumnIndex);

            // Print the last row from right to left from remaining rows of matrix
            endingRowIndex =
                    getEndingRowIndex(startingRowIndex, startingColumnIndex, endingRowIndex, endingColumnIndex);

            // Print the first column from bottom to top from the remaining columns of matrix
            startingColumnIndex =
                    getStartingColumnIndex(startingRowIndex, startingColumnIndex, endingRowIndex, endingColumnIndex);
        }
    }

    private int getStartingColumnIndex(int startingRowIndex, int startingColumnIndex, int endingRowIndex,
                                       int endingColumnIndex) {
        int iterator;
        if (startingColumnIndex < endingColumnIndex) {
            for (iterator = endingRowIndex - 1; iterator >= startingRowIndex; iterator--) {
                System.out.println(elements[iterator][startingColumnIndex] + WHITE_SPACE);
            }
            // Decrease the endingColumnIndex to mark down the printing of last column
            startingColumnIndex++;
        }
        return startingColumnIndex;
    }

    private int getEndingRowIndex(int startingRowIndex, int startingColumnIndex, int endingRowIndex,
                                  int endingColumnIndex) {
        int iterator;
        if (startingRowIndex < endingRowIndex) {
            for (iterator = endingColumnIndex - 1; iterator >= startingColumnIndex; iterator--) {
                System.out.println(elements[endingRowIndex - 1][iterator] + WHITE_SPACE);
            }
            // Decrease the endingRowIndex to mark down the printing of last row
            endingRowIndex--;
        }
        return endingRowIndex;
    }

    private int getEndingColumnIndex(int startingRowIndex, int endingRowIndex, int endingColumnIndex) {
        int iterator;
        for (iterator = startingRowIndex; iterator < endingRowIndex; iterator++) {
            System.out.println(elements[iterator][endingColumnIndex - 1] + WHITE_SPACE);
        }
        // Decrease the endingColumnIndex to mark down the printing of last column
        endingColumnIndex--;
        return endingColumnIndex;
    }

    private int getStartingRowIndex(int startingRowIndex, int startingColumnIndex, int endingColumnIndex) {
        int iterator;
        for (iterator = startingColumnIndex; iterator < endingColumnIndex; iterator++) {
            System.out.println(elements[startingRowIndex][iterator] + WHITE_SPACE);
        }
        // Increase the startingRowIndex to mark down the printing of first row
        startingRowIndex++;
        return startingRowIndex;
    }

}
