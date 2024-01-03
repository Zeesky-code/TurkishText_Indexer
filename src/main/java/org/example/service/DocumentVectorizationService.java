package org.example.service;

import java.util.*;

public class DocumentVectorizationService {
    private List<List<String>> tokenizedData;

    public Map<String, Integer> createBagOfWords(List<List<String>> tokenizedData) {
        Map<String, Integer> bagOfWords = new TreeMap<>(); // TreeMap for alphabetical sorting

        this.tokenizedData = tokenizedData;

        // Create our vocabulary with all unique tokens
        Set<String> vocabulary = new HashSet<>();
        for (List<String> document : tokenizedData) {
            vocabulary.addAll(document);
        }

        // Initialize the bag of words with zeros
        for (String word : vocabulary) {
            bagOfWords.put(word, 0);
        }

        // Update token counts in the bag of words
        for (List<String> document : tokenizedData) {
            for (String word : document) {
                bagOfWords.put(word, bagOfWords.get(word) + 1);
            }
        }

        return bagOfWords;
    }

    public double[] getDocumentVector(List<String> document, Map<String, Integer> bagOfWords) {
        double[] documentVector = new double[bagOfWords.size()];
        int totalDocuments = this.tokenizedData.size();

        for (int i = 0; i < documentVector.length; i++) {
            String word = new ArrayList<>(bagOfWords.keySet()).get(i);
            int count = bagOfWords.get(word);

            // Calculate Term Frequency
            long termFrequency = document.stream().filter(token -> token.equals(word)).count();
            double tf = (double) termFrequency / document.size();

            // Calculate Inverse Document Frequency (IDF) with smoothing
            int documentFrequency = 0;
            for (List<String> doc : this.tokenizedData) {
                if (doc.contains(word)) {
                    documentFrequency++;
                }
            }
            double idf = Math.log((double) (totalDocuments + 1) / (documentFrequency + 1)) + 1;
            documentVector[i] = tf * idf;
        }

        return documentVector;
    }


    public String findMostFrequentWord(List<List<String>> tokenizedData, Map<String, Integer> bagOfWords) {
        Map.Entry<String, Integer> mostFrequentEntry = null;

        for (Map.Entry<String, Integer> entry : bagOfWords.entrySet()) {
            if (mostFrequentEntry == null || entry.getValue() > mostFrequentEntry.getValue()) {
                mostFrequentEntry = entry;
            }
        }

        return mostFrequentEntry != null ? mostFrequentEntry.getKey() : null;
    }
}
