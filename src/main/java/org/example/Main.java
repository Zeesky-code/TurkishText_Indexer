package org.example;

import java.util.Map;

public class Main {
    static Preprocessor textProcessor = new Preprocessor();
    public static void main(String[] args) {
        String test = "cankiri hapisanesinden mektuplar saat dort yoksun saat bes yok alti, yedi, ertesi gun, daha ertesi ve belki kim bilir... hapisane avlusunda bir bahcemiz vardi. sicak bir duvar dibinde on bes adim";

        //Get poem text
//        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");
//        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
//
//        poem1 = textProcessor.lowerText(poem1);
//        poem2 = textProcessor.lowerText(poem2);

//        if(Objects.equals(poem1, "") || Objects.equals(poem2, "")){
//            System.out.println("Error reading poem from URL");
//        }
//
//        System.out.println(poem1);
//        System.out.println(poem2);

        String [] tokens = textProcessor.process(test);
        Map<String, Integer> termFrequency =Indexer.countUniqueStrings(tokens);

    }

}