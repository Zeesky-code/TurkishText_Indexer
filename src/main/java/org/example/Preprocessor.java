package org.example;

public class Preprocessor {
    String [] tokens;
    public String[] getTokens(String text){
        tokens= text.split("\\s");
        return tokens;
    }
    public String lowerText(String text){
        return text.toLowerCase();
    }
}
