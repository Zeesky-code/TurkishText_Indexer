package org.example.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class WebScraperService {
    public String getPoemText(String url){
        String poem = "";
        try {
            // Connect to the webpage
            Document doc = Jsoup.connect(url).get();
            // Extract the poem text
            poem = doc.text();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return poem;
    }
}
