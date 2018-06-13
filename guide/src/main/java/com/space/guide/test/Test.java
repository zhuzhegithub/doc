package com.space.guide.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

        //String string1 = reader.readLine();

        Stream<String> lines = reader.lines();
        Object[] objects = lines.toArray();
        for (int i = 0; i < objects.length; i++) {

            String object = String.valueOf(objects[i]);
            String[] split = object.split(" ");
            System.out.println(object);

            if (split.length == 3) {

            }

        }

        //System.out.println(lines.count());
    }
}
