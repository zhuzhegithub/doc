package com.space.guide.test;

import com.space.guide.bean.InputBean;
import com.space.guide.config.GalaxySymbol;
import com.space.guide.exception.IllegalInputException;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author zhuzhe
 * @date 2018/6/13 23:18
 * @email 1529949535@qq.com
 */
public class Test {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("input.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        Stream<String> lines = reader.lines();
        Object[] objects = lines.toArray();

        InputBean input = new InputBean().getInput(objects);

        Map<String, String> symbolMap = input.getSymbolMap();
        List<String> exampleList = input.getExampleList();
        List<String> questionList = input.getQuestionList();


        System.out.println(symbolMap);
    }
}
