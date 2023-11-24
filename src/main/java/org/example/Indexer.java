package org.example;

import java.util.HashMap;
import java.util.Map;

public class Indexer {
    public static Map<String,Integer> countUniqueStrings(String[] stringArray) {
        Map<String, Integer> uniquetokens = new HashMap<>();

        for (String str : stringArray) {
            if (uniquetokens.containsKey(str)) {
                uniquetokens.put(str, uniquetokens.get(str) + 1);
            } else {
                uniquetokens.put(str, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : uniquetokens.entrySet()) {
            String uniqueString = entry.getKey();
            int count = entry.getValue();
            System.out.printf("%s: %d occurrences\n", uniqueString, count);
        }
        return uniquetokens;
    }
}
