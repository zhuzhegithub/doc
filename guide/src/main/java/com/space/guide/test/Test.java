package com.space.guide.test;

import com.space.guide.bean.InputBean;
import com.space.guide.utils.SymbolConvertUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author zhuzhe
 * @date 2018/6/13 20:43
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

        /*保存标志对应的积分值*/
        Map<String, Double> creditsMap = new HashMap<>();

        for (String example : exampleList) {
            String[] split = example.split(" ");
            String symbols = "" + symbolMap.get(split[0]) + symbolMap.get(split[1]);
            Integer values = SymbolConvertUtil.getValues(symbols);
            creditsMap.put(split[2], Double.valueOf(split[4]) / values);
        }

        for (String question : questionList) {
            if (question.startsWith("how much is ")) {
                //how much is pish tegj glob glob ?
                String substring = question.substring("how much is ".length(), question.indexOf(" ?"));
                String symbols = "";
                String[] split = substring.split(" ");
                for (int i = 0; i < split.length; i++) {
                    symbols += symbolMap.get(split[i]);
                }
                Integer values = SymbolConvertUtil.getValues(symbols);
                System.out.println(substring + " is " + values);
            } else if (question.startsWith("how many Credits is ")) {
                //how many Credits is glob prok Silver ?
                String substring = question.substring("how many Credits is ".length(), question.indexOf(" ?"));
                String symbols = "";
                String[] split = substring.split(" ");
                for (int i = 0; i < split.length - 1; i++) {
                    symbols += symbolMap.get(split[i]);
                }
                Integer values = SymbolConvertUtil.getValues(symbols);
                System.out.println(substring + " is " + Double.valueOf(creditsMap.get(split[split.length - 1]) * values).intValue() + " Credits");
            } else {
                System.out.println("I have no idea what you are talking about");
            }
        }
    }
}
