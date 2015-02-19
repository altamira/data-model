/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Alessandro
 */
public class MagnitudeFactory {
    public static Map<String, Magnitude> persistentMap = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("dimencional", new Magnitude(101l, "dimencional")),
                new AbstractMap.SimpleEntry<>("peso", new Magnitude(102l, "peso")),
                new AbstractMap.SimpleEntry<>("unidade", new Magnitude(103l, "unidade")),
                new AbstractMap.SimpleEntry<>("tempo", new Magnitude(104l, "tempo")))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    public static Magnitude MagnitudeFactory(String name) {
        Magnitude m = persistentMap.get(name);
        if (m == null) {
            throw new IllegalArgumentException("Unknow magnitude " + name);
        }
        return m;
    }    
}
