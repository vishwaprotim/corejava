package com.protim.corejava.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperations {

    public static void main(String[] args){
        var line = "A wonderful statement with unicode characters: ◉❖✓: Java ✨ Code 😀";
        System.out.println("Input Statement: " + line);
        var collection = frequency(line);
        collection.forEach((k,v) -> System.out.println(k + " -> " + v));
    }

    // String.chars() breaks emojis
    // Better to use codePoints() to preserve complex Unicode Characters
    // Also, do not convert it back to IntStream/Integer, as it will break the
    // complex characters again. Convert it to String
    public static Map<String, Long> frequency(String line){
        if(line == null || line.trim().isEmpty()){
            return Collections.emptyMap();
        }
        List<String> l = new ArrayList<>();
        line.toUpperCase().codePoints().forEach(c -> l.add(Character.toString(c)));

        return l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
