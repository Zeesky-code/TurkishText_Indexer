package org.example;

public class CosineSimilarity {
    public static double computeCosineSimilarity(double[] vector1, double[] vector2) {
        // Ensure the vectors are of the same length
        if (vector1.length != vector2.length) {
            throw new IllegalArgumentException("Vectors must be of the same length");
        }

        // Compute dot product
        double dotProduct = 0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
        }

        // Compute magnitudes
        double magnitude1 = calculateMagnitude(vector1);
        double magnitude2 = calculateMagnitude(vector2);

        // Avoid division by zero
        if (magnitude1 == 0 || magnitude2 == 0) {
            return 0.0;
        }

        // Compute cosine similarity
        return dotProduct / (magnitude1 * magnitude2);
    }

    private static double calculateMagnitude(double[] vector) {
        double sum = 0;
        for (double value : vector) {
            sum += value * value;
        }
        return Math.sqrt(sum);
    }
}
