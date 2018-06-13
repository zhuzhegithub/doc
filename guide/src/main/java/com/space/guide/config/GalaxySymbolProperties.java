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
}
