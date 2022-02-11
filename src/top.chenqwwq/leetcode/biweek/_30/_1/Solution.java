package top.chenqwwq.leetcode.biweek._30._1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * <p>
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * <p>
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 *
 * @author chen
 * @date 2020/7/11 下午10:30
 */
public class Solution {
    static Map<String, String> month = new HashMap<>();

    static {
        String[] s = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < s.length; i++) {
            month.put(s[i], i < 9 ? "0" + (i + 1) : i + 1 + "");
        }
    }

    public String reformatDate(String date) {
        if (date == null || date.length() == 0) {
            return "";
        }

        final String[] time = date.split(" ");
        final String th = time[0].substring(0, time[0].length() - 2);

        return time[2] + "-" + month.get(time[1]) + "-" + (th.length() < 2 ? 0 + th : th);
    }
}
