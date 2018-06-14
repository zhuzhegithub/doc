package com.space.guide.bean;

import com.space.guide.config.GalaxySymbol;
import com.space.guide.exception.IllegalInputException;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuzhe
 * @date 2018/6/14 11:38
 * @email 1529949535@qq.com
 */
@Data
public class InputBean {

    private Map<String, Character> symbolMap;
    private List<String> exampleList;
    private List<String> questionList;

    public InputBean() {
        symbolMap = new HashMap<>();
        exampleList = new ArrayList<>();
        questionList = new ArrayList<>();
    }

    public InputBean getInput(Object[] objects) {

        for (int i = 0; i < objects.length; i++) {
            String object = String.valueOf(objects[i]);
            String[] split = object.split(" ");
            if (split.length == 3) {
                if (StringUtils.isEmpty(split[0]) || StringUtils.isEmpty(split[1]) || StringUtils.isEmpty(split[2]) ||
                        !split[1].equals("is") || split[2].toCharArray().length != 1 ||
                        !GalaxySymbol.getAllSymbol().contains(split[2].toCharArray()[0])) {
                    throw new IllegalInputException("非法的输入");
                }
                symbolMap.put(split[0], split[2].toCharArray()[0]);
                continue;
            }
            if (split.length == 6) {
                if (!split[3].equals("is") || !split[5].equals("Credits")) {
                    throw new IllegalInputException("非法的输入");
                }
                try {
                    Integer.valueOf(split[4]);
                } catch (Exception e) {
                    throw new IllegalInputException("非法的输入");
                }
                exampleList.add(object);
                continue;
            }
            if (object.indexOf("?") > -1) {
                questionList.add(object);
                continue;
            }
        }
        return this;
    }
}
