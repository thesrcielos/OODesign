package org.eci;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class to run the mean and standard deviation calculator.
 *
 * Reads a file path from the console, parses two columns of numerical data,
 * calculates mean and standard deviation for each column, and prints the results.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the data file: ");
        String path = scanner.nextLine();

        try {
            FileDataReader.ColumnData data = FileDataReader.readTwoColumns(path);

            System.out.println("Column 1:");
            printStats(data.column1());

            System.out.println("\nColumn 2:");
            printStats(data.column2());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static void printStats(List<Double> data) {
        double mean = MathUtils.mean(data);
        double stdDev = MathUtils.stdDev(data);
        System.out.printf("Mean: %.2f%n", mean);
        System.out.printf("Standard Deviation: %.2f%n", stdDev);
    }
}


