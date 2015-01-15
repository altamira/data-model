/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Alessandro
 */
public class Functions {

    public static Map<String, String> translateTable(String language) throws IllegalArgumentException {

        switch (language) {
            case "pt-BR":
                return Collections.unmodifiableMap(Stream.of(
                        new AbstractMap.SimpleEntry<>("quadrado", "AREA_SQUARE"),
                        new AbstractMap.SimpleEntry<>("retangulo", "AREA_RECTANGLE"),
                        new AbstractMap.SimpleEntry<>("redondo", "AREA_CIRCLE"),
                        new AbstractMap.SimpleEntry<>("circulo", "AREA_CIRCLE"),
                        new AbstractMap.SimpleEntry<>("furo", "AREA_CIRCLE"),
                        new AbstractMap.SimpleEntry<>("oblongo", "AREA_OBLONG"))
                        .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
        }

        throw new IllegalArgumentException("Language " + language + " not supported.");
    }

    public static String translate(String name) {
        String function = translateTable("pt-BR").get(name.toLowerCase());
        
        return function == null ? name : function;
    }

    public static List<String> translate(List<String> functions) {

        // TO DO
        
        return functions;
    }

}
