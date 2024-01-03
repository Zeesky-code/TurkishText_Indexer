package org.example.service;

import zemberek.tokenization.TurkishTokenizer;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PreprocessorService {
    static TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
    List<String> tokens;
    public List<String> process(String text){
        String loweredText = lowerText(text);
        loweredText = removePunctuation(loweredText);
        return getTokens(loweredText);
    }
    public List<String> getTokens(String text){
        tokens = tokenizer.tokenizeToStrings(text);
        return tokens;
    }
    public String lowerText(String text){
        return text.toLowerCase();
    }
    public String removePunctuation(String text){

        Pattern punctuationPattern = Pattern.compile("[^\\w\\s]"); //remove all characters that are not whitespace or letters
        Matcher matcher = punctuationPattern.matcher(text);
        return matcher.replaceAll("");
    }
}
