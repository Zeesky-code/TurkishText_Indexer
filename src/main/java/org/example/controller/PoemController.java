package org.example.controller;

import org.example.service.CosineSimilarityService;
import org.example.service.DocumentVectorizationService;
import org.example.service.PreprocessorService;
import org.example.service.WebScraperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class PoemController {

    @Autowired
    private WebScraperService webScraperService;

    @Autowired
    private PreprocessorService preprocessorService;

    @Autowired
    private CosineSimilarityService cosineSimilarityService;

    @Autowired
    private DocumentVectorizationService documentVectorizationService;

    @PostMapping("/compare-poems")
    public String comparePoems(@RequestParam String url1, @RequestParam String url2, Model model) {
        // Scrape poems
        String poem1 = webScraperService.getPoemText(url1);
        String poem2 = webScraperService.getPoemText(url2);

        // Preprocess poems
        List<String> poem1Tokens = PreprocessorService.process(poem1);
        List<String> poem2Tokens = PreprocessorService.process(poem2);

        List<List<String>> tokenizedData = List.of(poem1Tokens,poem2Tokens);

        Map<String, Integer> bagOfWords = DocumentVectorizationService.createBagOfWords(tokenizedData);

        double[] vector1 = DocumentVectorizationService.getDocumentVector(poem1Tokens, bagOfWords);
        double[] vector2 = DocumentVectorizationService.getDocumentVector(poem2Tokens, bagOfWords);

        double similarity = CosineSimilarityService.computeCosineSimilarity(vector1, vector2) *100; //return percentage
        String mostFrequentWord = DocumentVectorizationService.findMostFrequentWord(tokenizedData, bagOfWords);

        // Pass the result to the view
        model.addAttribute("similarity", similarity);
        model.addAttribute("frequentWord", mostFrequentWord);

        // Return the name of the Thymeleaf template
        return "result";
    }
}

