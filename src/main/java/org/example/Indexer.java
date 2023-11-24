package org.example;

import java.util.HashMap;
import java.util.Map;

public class Indexer {
    public static Map<String,Integer> countUniqueStrings(String[] stringArray) {
        Map<String, Integer> uniqueTokens = new HashMap<>();

        for (String str : stringArray) {
            if (uniqueTokens.containsKey(str)) {
                uniqueTokens.put(str, uniqueTokens.get(str) + 1);
            } else {
                uniqueTokens.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : uniqueTokens.entrySet()) {
            String uniqueString = entry.getKey();
            int count = entry.getValue();
            System.out.printf("%s: %d occurrences\n", uniqueString, count);
        }
        return uniqueTokens;
    }
}
