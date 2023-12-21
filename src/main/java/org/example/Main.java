package org.example;

import java.util.*;

public class Main {
    static Preprocessor textProcessor = new Preprocessor();
    static DocumentVectorization documentVectorization = new DocumentVectorization();
    public static void main(String[] args) {

        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/ellerinize_ve_yalana_dair");
        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
        if(Objects.equals(poem1, "") || Objects.equals(poem2, "")){
            System.out.println("Error reading poem from URL");
            System.exit(400);
        }
        List<List<String>> tokenizedData = new ArrayList<>();
        List<String> poem1Tokens = textProcessor.process(poem1);
        List<String> poem2Tokens = textProcessor.process(poem2);
        tokenizedData.add(poem1Tokens);
        tokenizedData.add(poem2Tokens);

        Map<String, Integer> bagOfWords = documentVectorization.createBagOfWords(tokenizedData);

        // Get document vectors
        for (List<String> document : tokenizedData) {
            double[] documentVector = documentVectorization.getDocumentVector(document, bagOfWords);
            System.out.println("Document Vector: " + Arrays.toString(documentVector));
        }

    }

}