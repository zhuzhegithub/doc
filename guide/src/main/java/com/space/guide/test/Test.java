package com.space.guide.test;

import com.space.guide.bean.InputBean;
import com.space.guide.config.GalaxySymbol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        Map<String, Character> symbolMap = input.getSymbolMap();
        List<String> exampleList = input.getExampleList();
        List<String> questionList = input.getQuestionList();

        for (String example : exampleList) {
            System.out.println(example);
            String[] split = example.split(" ");

            int num1 = GalaxySymbol.getSymbol(symbolMap.get(split[0])).getValue();
            int num2 = GalaxySymbol.getSymbol(symbolMap.get(split[1])).getValue();


            //int num3 = GalaxySymbol.getSymbol(symbolMap.get(split[2])).getValue();

            int num3 = Integer.valueOf(split[4]) - num1 - num2;

            int result = Integer.valueOf(split[4]);
        }


    }
}
