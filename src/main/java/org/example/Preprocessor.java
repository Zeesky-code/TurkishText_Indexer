package org.example;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Preprocessor {
    String [] tokens;
    public String[] process(String text){
        String loweredText = lowerText(text);
        loweredText = removePunctuation(loweredText);
        return getTokens(loweredText);
    }
    public String[] getTokens(String text){
        tokens= text.split("\\s");
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
