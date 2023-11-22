package org.example;

import java.util.Objects;

public class Main {
    Preprocessor textProcessor = new Preprocessor();
    public static void main(String[] args) {
        //Get poem text
        String poem1 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");
        String poem2 = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/cankiri_hapishanesinden_mektuplar");
        if(Objects.equals(poem1, "") || Objects.equals(poem2, "")){
            System.out.println("Error reading poem from URL");
        }

        System.out.println(poem1);
        System.out.println(poem2);
    }
}