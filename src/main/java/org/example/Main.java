package org.example;

import org.example.service.CosineSimilarityService;
import org.example.service.DocumentVectorizationService;
import org.example.service.PreprocessorService;
import org.example.service.WebScraperService;

import java.util.*;

public class Main {
    static PreprocessorService textProcessor = new PreprocessorService();

    public static void main(String[] args) {

        String poem1 = WebScraperService.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
        String poem2 = WebScraperService.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");

        List<String> poem1Tokens = textProcessor.process(poem1);
        List<String> poem2Tokens = textProcessor.process(poem2);
        List<List<String>> tokenizedData = List.of(poem1Tokens,poem2Tokens);
        DocumentVectorizationService documentVectorizationService = new DocumentVectorizationService();
        Map<String, Integer> bagOfWords = documentVectorizationService.createBagOfWords(tokenizedData);

        double[] vector1 = documentVectorizationService.getDocumentVector(poem1Tokens, bagOfWords);
        double[] vector2 = documentVectorizationService.getDocumentVector(poem2Tokens, bagOfWords);

        double similarity = CosineSimilarityService.computeCosineSimilarity(vector1, vector2);
        String mostFrequentWord = documentVectorizationService.findMostFrequentWord(tokenizedData, bagOfWords);
        System.out.println("Cosine Similarity: " + similarity);
        System.out.println("Most Frequent Word: " + mostFrequentWord);


    }

}