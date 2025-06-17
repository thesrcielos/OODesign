package org.eci;

import java.util.List;

public class MathUtils {
    public static double mean(List<Double> data) {
        double sum = 0;
        for (Double val : data) sum += val;
        return sum / data.size();
    }

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
