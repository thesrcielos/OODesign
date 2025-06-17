package org.eci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataReader {

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

    public record ColumnData(List<Double> column1, List<Double> column2) {}
}
