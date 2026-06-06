package top.chenqwwq.pat.advanced._1017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1017 Queueing at Bank (25 分)
 * Suppose a bank has K windowCnt open for service. There is a yellow line in front of the windowCnt which devides the waiting area into two parts. All the customers have to wait in line behind the yellow line, until it is his/her turn to be served and there is a window available. It is assumed that no window can be occupied by a single customer for more than 1 hour.
 * <p>
 * Now given the arriving time T and the processing time P of each customer, you are supposed to tell the average waiting time of all the customers.
 * <p>
 * Input Specification:
 * Each input file contains one test case. For each case, the first line contains 2 numbers: N (≤10
 * 4
 * ) - the total number of customers, and K (≤100) - the number of windowCnt. Then N lines follow, each contains 2 times: HH:MM:SS - the arriving time, and P - the processing time in minutes of a customer. Here HH is in the range [00, 23], MM and SS are both in [00, 59]. It is assumed that no two customers arrives at the same time.
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
public class Main {
	/*
	7 3
	07:55:00 16
	17:00:01 2
	07:59:59 15
	08:01:00 60
	08:00:00 30
	08:00:02 2
	08:03:00 10

	9 3
	05:44:13 1
	07:55:00 16
	17:00:01 2
	07:59:59 15
	08:01:00 60
	08:01:00 23
	08:00:00 30
	08:00:02 2
	08:03:00 10
	 */
	private static final String regex = ":";

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final String[] cnt = reader.readLine().split("\\s+");
		final int customerCnt = Integer.parseInt(cnt[0]), windowCnt = Integer.parseInt(cnt[1]);
		int[][] customers = new int[customerCnt][2];
		final int endTime = getTime(17, 0, 1);
		int currTime = getTime(8, 0, 0);

		int needService = 0;
		for (int i = 0; i < customerCnt; i++) {
			final String s = reader.readLine();
			final String[] line = s.split("\\s+");
			final String[] times = line[0].split(regex);
			customers[i][0] = getTime(Integer.parseInt(times[0]), Integer.parseInt(times[1]), Integer.parseInt(times[2]));
			customers[i][1] = Math.min(60, Integer.parseInt(line[1])) * 60;
			if (customers[i][0] < endTime) {
				needService++;
			}
		}
		if (needService == 0 || windowCnt == 0) {
			System.out.printf("%.1f\n", 0f);
			return;
		}
		// 排序,先来先服务
		Arrays.sort(customers, Comparator.comparingInt(o -> o[0]));

		int idx = 0, ans = 0;
		// 正在服务的人，保存结束时间
		PriorityQueue<Integer> windows = new PriorityQueue<>();

		// 初始入队列
		while (idx < needService && windows.size() < windowCnt && customers[idx][0] <= currTime) {
			ans += currTime - customers[idx][0];
			windows.offer(currTime + customers[idx++][1]);
		}

		while (idx < needService) {
			if (windows.size() == windowCnt) {
				// 上一个结束服务的时间
				currTime = windows.poll();
			} else {
				// 没有正在服务的,直接选下一个需要服务的时间
				currTime = customers[idx][0];
			}

			while (idx < needService && windows.size() < windowCnt && customers[idx][0] <= currTime) {
				ans += currTime - customers[idx][0];
				windows.offer(currTime + customers[idx++][1]);
			}
		}

		System.out.printf("%.1f\n", 1f * ans / 60 / needService);
	}

	private static int getTime(int hour, int minute, int second) {
		return hour * 3600 + minute * 60 + second;
	}
}