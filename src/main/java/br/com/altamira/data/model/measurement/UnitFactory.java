/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.altamira.data.model.measurement;

import static br.com.altamira.data.model.measurement.MagnitudeFactory.MagnitudeFactory;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Alessandro
 */
public class UnitFactory {

    public static Map<String, Unit> persistentMap = Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>("min", new Unit(210l, "minuto", "min", MagnitudeFactory("tempo"))),
                new AbstractMap.SimpleEntry<>("s", new Unit(211l, "segundo", "s", MagnitudeFactory("tempo"))),
                new AbstractMap.SimpleEntry<>("h", new Unit(212l, "hora", "h", MagnitudeFactory("tempo"))),
                new AbstractMap.SimpleEntry<>("mm", new Unit(213l, "milimetro", "mm", MagnitudeFactory("dimencional"))),
                new AbstractMap.SimpleEntry<>("m", new Unit(214l, "metro", "m", MagnitudeFactory("dimencional"))),
                new AbstractMap.SimpleEntry<>("kg", new Unit(215l, "quilograma", "kg", MagnitudeFactory("peso"))),
                new AbstractMap.SimpleEntry<>("TON", new Unit(216l, "tonelada", "TON", MagnitudeFactory("peso"))),
                new AbstractMap.SimpleEntry<>("un", new Unit(217l, "unidade", "un", MagnitudeFactory("unidade"))),
                new AbstractMap.SimpleEntry<>("pç", new Unit(218l, "peça", "pç", MagnitudeFactory("unidade"))))
                .collect(Collectors.toMap((e) -> e.getKey(), (e) -> e.getValue())));

    public static Unit UnitFactory(String symbol) {
        Unit u = persistentMap.get(symbol);
        if (u == null) {
            throw new IllegalArgumentException("Unknow measurement unit " + symbol);
        }
        return u;
    }
}
