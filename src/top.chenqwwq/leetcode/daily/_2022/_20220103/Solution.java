package top.chenqwwq.leetcode.daily._2022._20220103;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author chenbingxin
 * @date 2022/1/3
 **/
public class Solution {
    String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public String dayOfTheWeek(int day, int month, int year) {
        final DayOfWeek dayOfWeek = LocalDate.of(year, month, day).getDayOfWeek();
        return week[dayOfWeek.ordinal()];
    }
}
