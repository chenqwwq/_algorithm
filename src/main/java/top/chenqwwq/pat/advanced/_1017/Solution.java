package top.chenqwwq.pat.advanced._1017;

import java.util.Scanner;

/**
 * 1017 Queueing at Bank (25 分)
 * Suppose a bank has K windows open for service. There is a yellow line in front of the windows which devides the waiting area into two parts. All the customers have to wait in line behind the yellow line, until it is his/her turn to be served and there is a window available. It is assumed that no window can be occupied by a single customer for more than 1 hour.
 * <p>
 * Now given the arriving time T and the processing time P of each customer, you are supposed to tell the average waiting time of all the customers.
 * <p>
 * Input Specification:
 * Each input file contains one test case. For each case, the first line contains 2 numbers: N (≤10
 * 4
 * ) - the total number of customers, and K (≤100) - the number of windows. Then N lines follow, each contains 2 times: HH:MM:SS - the arriving time, and P - the processing time in minutes of a customer. Here HH is in the range [00, 23], MM and SS are both in [00, 59]. It is assumed that no two customers arrives at the same time.
 * <p>
 * Notice that the bank opens from 08:00 to 17:00. Anyone arrives early will have to wait in line till 08:00, and anyone comes too late (at or after 17:00:01) will not be served nor counted into the average.
 * <p>
 * Output Specification:
 * For each test case, print in one line the average waiting time of all the customers, in minutes and accurate up to 1 decimal place.
 * <p>
 * Sample Input:
 * 7 3
 * 07:55:00 16
 * 17:00:01 2
 * 07:59:59 15
 * 08:01:00 60
 * 08:00:00 30
 * 08:00:02 2
 * 08:03:00 10
 * 结尾无空行
 * Sample Output:
 * 8.2
 * 结尾无空行
 *
 * @author chen
 * @date 2021-08-11
 **/
public class Solution {
	private static final String regex = ":";
	static int customer, windows;
	static int[][] arriving;
	static int[] processing;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		customer = scanner.nextInt();
		windows = scanner.nextInt();
		arriving = new int[customer][3];
		processing = new int[customer];
		for (int i = 0; i < customer; i++) {
			final String[] line = scanner.nextLine().split("\\s");
			final String[] times = line[0].split(regex);
			arriving[i][0] = Integer.parseInt(times[0]);
			arriving[i][1] = Integer.parseInt(times[1]);
			arriving[i][2] = Integer.parseInt(times[2]);
			processing[i] = Integer.parseInt(line[1]);
		}

	}
}
