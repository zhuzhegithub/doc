package com.space.guide.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhe
 * @date 2018/6/13 19:48
 * @email 1529949535@qq.com
 */
public enum GalaxySymbol {

    GalaxySymbolI(0, 'I', 1),
    GalaxySymbolV(1, 'V', 5),
    GalaxySymbolX(2, 'X', 10),
    GalaxySymbolL(3, 'L', 50),
    GalaxySymbolC(4, 'C', 100),
    GalaxySymbolD(5, 'D', 500),
    GalaxySymbolM(6, 'M', 1000);

    private Integer index;

    private Character symbol;

    private Integer value;

    GalaxySymbol(Integer index, Character symbol, Integer value) {
        this.index = index;
        this.symbol = symbol;
        this.value = value;
    }

    /**
     * 根据symbol获取value
     *
     * @param symbol
     * @return
     */
    public static GalaxySymbol getSymbol(Character symbol) {
        for (GalaxySymbol galaxySymbol : GalaxySymbol.values()) {
            if (galaxySymbol.getSymbol().equals(symbol)) {
                return galaxySymbol;
            }
        }
        return null;
    }

    public static List<Character> getAllSymbol() {
        List<Character> characterList = new ArrayList<>();
        for (GalaxySymbol galaxySymbol : GalaxySymbol.values()) {
            characterList.add(galaxySymbol.getSymbol());
        }
        return characterList;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
