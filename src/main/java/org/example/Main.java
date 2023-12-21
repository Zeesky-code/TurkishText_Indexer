package org.example;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Main {
    static Preprocessor textProcessor = new Preprocessor();
    public static void main(String[] args) {

        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");
        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
        if(Objects.equals(poem1, "") || Objects.equals(poem2, "")){
            System.out.println("Error reading poem from URL");
            System.exit(400);
        }

        List<String> poem1Tokens = textProcessor.process(poem1);
        List<String> poem2Tokens = textProcessor.process(poem2);

        for (String token: poem1Tokens) {
            System.out.println(token);
        }
//        System.out.println("Tokens in poem 1");
//        Map<String, Integer> termFrequency1 = Indexer.countUniqueStrings(poem1Tokens);
//
//        System.out.println("Tokens in poem 2");
//        Map<String, Integer> termFrequency2 = Indexer.countUniqueStrings(poem2Tokens);

    }

}