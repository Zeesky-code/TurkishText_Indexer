package org.example;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Get poem text
        String poem = WebScraper.getPoemText("https://www.cs.rpi.edu/~sibel/poetry/poems/nazim_hikmet/hos_geldin");
        if(Objects.equals(poem, "")){
            System.out.println("Error reading poem from URL");
        }
        System.out.println(poem);
    }
}