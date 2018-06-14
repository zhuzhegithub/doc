package com.space.guide.utils;

import com.space.guide.config.CharReduceRule;
import com.space.guide.config.GalaxySymbol;
import com.space.guide.exception.IllegalSymbolException;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuzhe
 * @date 2018/6/13 19:56
 * @email 1529949535@qq.com
 */
public class SymbolConvertUtil {

    private static Integer getValue(Character symbol) {
        GalaxySymbol galaxySymbol = GalaxySymbol.getSymbol(symbol);
        if (galaxySymbol == null) {
            throw new IllegalSymbolException("错误的符号");
        }
        return galaxySymbol.getValue();
    }

    /**
     * 根据symbol字符串获取值
     *
     * @param symbols
     * @return
     */
    public static Integer getValues(String symbols) {
        Integer value = 0;
        if (StringUtils.isEmpty(symbols)) {
            return null;
        }
        char[] split = symbols.toCharArray();
        if (split.length == 1) {
            return getValue(split[0]);
        }
        for (int i = 0; i < split.length - 1; i++) {
            if (getValue(split[i]) >= getValue(split[i + 1])) {
                if (split.length - i > 2) {
                    value += getValue(split[i]);
                } else {
                    value += (getValue(split[i]) + getValue(split[i + 1]));
                    return value;
                }
            } else {
                if (split.length - i > 3) {
                    value += (getValue(split[i + 1]) - getValue(split[i]));
                    // 一次消费了2个symbol,需要i++
                    i++;
                } else if (split.length - i > 2) {
                    value += (getValue(split[i + 1]) - getValue(split[i]));
                    value += getValue(split[i + 2]);
                    return value;
                } else {
                    value += (getValue(split[i + 1]) - getValue(split[i]));
                    return value;
                }
            }
        }
        return value;
    }

    public static boolean checkRepeat(String symbols) {
        List<String> repeat = Arrays.asList("IIII", "XXXX", "CCCC", "MMMM", "DD", "LL", "VV");
        if (symbols == null) {
            return false;
        }
        for (String string : repeat) {
            if (symbols.indexOf(string) >= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验字符相减规则
     *
     * @param minuend 被减数
     * @param sub     减数
     * @return
     */
    public static boolean reduceRule(Character minuend, Character sub) {
        if (CharReduceRule.ableReduce(minuend) && CharReduceRule.getRule(minuend) != null &&
                CharReduceRule.getRule(minuend).contains(sub)) {
            return true;
        }
        return false;
    }
}
