package org.example;

import java.util.*;

public class Main {
    static Preprocessor textProcessor = new Preprocessor();

    public static void main(String[] args) {

        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");

        List<String> poem1Tokens = textProcessor.process(poem1);
        List<String> poem2Tokens = textProcessor.process(poem2);
        List<List<String>> tokenizedData = List.of(poem1Tokens,poem2Tokens);
        DocumentVectorization documentVectorization = new DocumentVectorization();
        Map<String, Integer> bagOfWords = documentVectorization.createBagOfWords(tokenizedData);

        double[] vector1 = documentVectorization.getDocumentVector(poem1Tokens, bagOfWords);
        double[] vector2 = documentVectorization.getDocumentVector(poem2Tokens, bagOfWords);

        double similarity = CosineSimilarity.computeCosineSimilarity(vector1, vector2);
        String mostFrequentWord = documentVectorization.findMostFrequentWord(tokenizedData, bagOfWords);
        System.out.println("Cosine Similarity: " + similarity);
        System.out.println("Most Frequent Word: " + mostFrequentWord);


    }

}