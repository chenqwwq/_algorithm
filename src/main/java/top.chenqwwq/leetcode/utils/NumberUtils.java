package top.chenqwwq.leetcode.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chen
 * @date 2020/5/11 下午9:13
 */
public class NumberUtils {

    /**
     * 小数点后截取
     *
     * @param d     目标数字
     * @param scale 小数点后位数
     * @return 结果数字
     */
    public static double getScale(double d, int scale) {
        return new BigDecimal(d).setScale(scale, RoundingMode.DOWN).doubleValue();
    }

}
