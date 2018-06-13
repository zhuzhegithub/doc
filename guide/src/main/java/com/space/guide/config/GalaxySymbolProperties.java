package com.space.guide.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhuzhe
 * @date 2018/6/13 16:35
 * @email 1529949535@qq.com
 */
@Component
@ConfigurationProperties(prefix = "galaxy.symbol")
@Data
public class GalaxySymbolProperties {

    private Integer symbolI = 1;

    private Integer symbolV = 5;

    private Integer symbolX = 10;

    private Integer symbolL = 50;

    private Integer symbolC = 100;

    private Integer symbolD = 500;

    private Integer symbolM = 1000;

    public GalaxySymbol getSymbol(String symbol) {
        for (GalaxySymbol galaxySymbol : GalaxySymbol.values()) {
            if (galaxySymbol.getSymbol().equals(symbol)) {
                galaxySymbol.setValue(1999);
                return galaxySymbol;
            }
        }
        return null;
    }

    public enum GalaxySymbol {

        GalaxySymbolI("I", 1),
        GalaxySymbolV("V", 5),
        GalaxySymbolX("X", 10),
        GalaxySymbolL("L", 50),
        GalaxySymbolC("C", 100),
        GalaxySymbolD("D", 500),
        GalaxySymbolM("M", 1000);

        private String symbol;

        private Integer value;

        GalaxySymbol(String symbol, Integer value) {
            this.symbol = symbol;
            this.value = value;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
