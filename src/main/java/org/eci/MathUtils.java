package org.eci;

import java.util.List;

/**
 * Utility class for statistical calculations.
 *
 * Provides static methods to compute:
 * - Mean (average) of a list of numbers
 * - Sample standard deviation of a list of numbers
 */
public class MathUtils {
    /**
     * Computes the mean of a list of numbers.
     *
     * @param data the list of numbers
     * @return the arithmetic mean
     */
    public static double mean(List<Double> data) {
        double sum = 0;
        for (Double val : data) sum += val;
        return sum / data.size();
    }


    /**
     * Computes the sample standard deviation of a list of numbers.
     *
     * @param data the list of numbers
     * @return the standard deviation
     */
    public static double stdDev(List<Double> data) {
        double mean = mean(data);
        double sumSq = 0;
        for (Double val : data) {
            double diff = val - mean;
            sumSq += diff * diff;
        }
        return Math.sqrt(sumSq / (data.size() - 1));
    }
}
