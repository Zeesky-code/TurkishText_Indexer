package org.example;

import java.util.*;

public class Main {
    static Preprocessor textProcessor = new Preprocessor();
    static DocumentVectorization documentVectorization = new DocumentVectorization();
    public static void main(String[] args) {

        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/ellerinize_ve_yalana_dair");
        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");

        List<List<String>> tokenizedData = new ArrayList<>();
        List<String> poem1Tokens = textProcessor.process(poem1);
        tokenizedData.add(poem1Tokens);

        List<String> poem2Tokens = textProcessor.process(poem2); tokenizedData.add(poem1Tokens);
        tokenizedData.add(poem2Tokens);

        Map<String, Integer> bagOfWords = documentVectorization.createBagOfWords(tokenizedData);
        double[] vector1 = documentVectorization.getDocumentVector(poem1Tokens, bagOfWords);
        double[] vector2 = documentVectorization.getDocumentVector(poem2Tokens, bagOfWords);

        double similarity = CosineSimilarity.computeCosineSimilarity(vector1, vector2);
        System.out.println("Cosine Similarity: " + similarity);


    }

}