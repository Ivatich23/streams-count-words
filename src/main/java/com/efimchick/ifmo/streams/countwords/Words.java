package com.efimchick.ifmo.streams.countwords;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Words {
    public String countWords(List<String> lines) {
        return lines.stream().map(String::toLowerCase)
                .map(line->line.split("(?U)[\\pP\\s\\d+]"))
                .flatMap(array->Arrays.stream(array))
                .filter(word->word.length()>=4)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(entry->entry.getValue()>=10L)
                .sorted(Map.Entry.comparingByValue()
                        .thenComparing(Comparator.comparing((word1,word2)->{

                        }) {
            @Override
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                if(o2.getValue().equals(o1.getValue())) {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    int i = 0;
                    while (i < s1.length() && i < s2.length()) {

                        if (s1.charAt(i) > s2.charAt(i)) {
                            return 1;

                        } else if (s1.charAt(i) < s2.charAt(i)) {
                            return -1;

                        } else if (i == s1.length() - 1) {

                            return -1;
                        } else if (i == s2.length() - 1) {

                            return 1;

                        } else {
                            i++;
                        }

                    }
                }
                return (int) (o2.getValue() - o1.getValue());
            }
        }).map(entry->entry.getKey() + " - "+entry.getValue())
                .collect(Collectors.joining("\n"));

    }
}
