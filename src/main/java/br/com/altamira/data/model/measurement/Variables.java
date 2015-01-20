/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import java.math.BigDecimal;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Alessandro
 */
public class Variables extends HashMap<String, BigDecimal> {

    public static Map<String, String> translateTable(String language) throws IllegalArgumentException {
        
        switch (language) {
            case "pt-BR":
                return Collections.unmodifiableMap(Stream.of(
                        new SimpleEntry<>("quantidade", "quantity"),
                        new SimpleEntry<>("largura", "width"),
                        new SimpleEntry<>("comprimento", "length"),
                        new SimpleEntry<>("altura", "height"),
                        new SimpleEntry<>("espessura", "thickness"),
                        new SimpleEntry<>("profundidade", "depth"),
                        new SimpleEntry<>("area", "area"),
                        new SimpleEntry<>("peso", "weight"))
                        .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));
        }
        
        throw new IllegalArgumentException("Language " + language + " not supported.");
    }

    public Variables() {
        /*
        put("quantity", BigDecimal.ZERO);
        put("width", BigDecimal.ZERO);
        put("length", BigDecimal.ZERO);
        put("thickness", BigDecimal.ZERO);
        put("weight", BigDecimal.ZERO);
        put("height", BigDecimal.ZERO);
        put("depth", BigDecimal.ZERO);
        */
    }


    public static String translateKey(String key) {
        return translateTable("pt-BR").get(key);
    }
    
    public static Map<String, BigDecimal> translateMap(Map<String, BigDecimal> variable) {

        translateTable("pt-BR").forEach((k, w) -> {
            if (variable.containsKey(k)) {
                variable.put(w, variable.remove(k));
            }
        });

        return variable;
    }

}
