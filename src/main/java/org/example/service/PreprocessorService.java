package org.example.service;

import org.springframework.stereotype.Service;
import zemberek.tokenization.TurkishTokenizer;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@Service
public class PreprocessorService {
    static TurkishTokenizer tokenizer = TurkishTokenizer.DEFAULT;
    static List<String> tokens;
    public static List<String> process(String text){
        String loweredText = lowerText(text);
        loweredText = removePunctuation(loweredText);
        return getTokens(loweredText);
    }
    public static List<String> getTokens(String text){
        tokens = tokenizer.tokenizeToStrings(text);
        return tokens;
    }
    public static String lowerText(String text){
        return text.toLowerCase();
    }
    public static String removePunctuation(String text){

        Pattern punctuationPattern = Pattern.compile("[^\\w\\s]"); //remove all characters that are not whitespace or letters
        Matcher matcher = punctuationPattern.matcher(text);
        return matcher.replaceAll("");
    }
}
