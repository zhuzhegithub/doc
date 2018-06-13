package com.space.guide.config;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuzhe
 * @date 2018/6/13 21:42
 * @email 1529949535@qq.com
 */
public class CharReduceRule {

    public static List<Character> getRule(Character character) {
        if (character == null) {
            return null;
        }
        if (character.equals('I')) {
            return CHARACTER_LIST_I;
        }
        if (character.equals('X')) {
            return CHARACTER_LIST_X;
        }
        if (character.equals('C')) {
            return CHARACTER_LIST_C;
        }
        return null;
    }

    /*是否可以被减*/
    public static boolean ableReduce(Character character) {
        return !CAN_NOT_REDUCE.contains(character);
    }

    /*允许被减规则，规则内的字符可以减*/
    private static final List<Character> CHARACTER_LIST_I = Arrays.asList('V', 'X');
    private static final List<Character> CHARACTER_LIST_X = Arrays.asList('L', 'C');
    private static final List<Character> CHARACTER_LIST_C = Arrays.asList('D', 'M');

    /*不允许被减的字符*/
    private static final List<Character> CAN_NOT_REDUCE = Arrays.asList('V', 'L', 'D');
}
