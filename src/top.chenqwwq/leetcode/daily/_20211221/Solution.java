package top.chenqwwq.leetcode.daily._20211221;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author chenbingxin
 * @date 2021/12/21
 **/
public class Solution {
	private static final int[] m2d = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

	public int dayOfYear(String date) {
		final String[] ds = date.split("-");
		final int year = Integer.parseInt(ds[0]), month = Integer.parseInt(ds[1]), day = Integer.parseInt(ds[2]);
		return m2d[month-1] + (month > 2 && year % 4 == 0 ? 1 : 0) + day;
	}
}