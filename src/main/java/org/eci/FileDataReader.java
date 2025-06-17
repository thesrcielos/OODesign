package org.eci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for reading numerical data from a file with two columns.
 *
 * The file is expected to contain two numeric columns separated by spaces or commas.
 */
public class FileDataReader {

    /**
     * Reads a file and parses two columns of double values.
     *
     * @param filePath the path to the file
     * @return a {@code ColumnData} record containing two lists: one per column
     * @throws IOException if the file can't be read
     */
    public static ColumnData readTwoColumns(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));

        List<List<Double>> columns = lines.stream()
                .filter(line -> !line.trim().isEmpty())
                .map(line -> line.trim().split("\\s+|,"))
                .filter(parts -> parts.length >= 2)
                .map(parts -> List.of(
                        tryParse(parts[0]),
                        tryParse(parts[1])
                ))
                .filter(pair -> pair.get(0) != null && pair.get(1) != null)
                .toList();

        List<Double> column1 = new MyLinkedList<>();
        List<Double> column2 = new MyLinkedList<>();

        for (List<Double> pair : columns) {
            column1.add(pair.get(0));
            column2.add(pair.get(1));
        }

        return new ColumnData(column1, column2);
    }


    private static Double tryParse(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + s);
            return null;
        }
    }

    /**
     * Record that holds two columns of parsed numerical data.
     *
     * @param column1 the first column of numbers
     * @param column2 the second column of numbers
     */
    public record ColumnData(List<Double> column1, List<Double> column2) {}
}
