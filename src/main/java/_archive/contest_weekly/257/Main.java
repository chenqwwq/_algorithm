package top.chenqwwq.leetcode.contest.weekly._257;

import java.util.Scanner;

/**
 * @author chen
 * @date 2021/9/10
 **/
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] first = scanner.nextLine().split("\\s");

		final int n = Integer.parseInt(first[0]), m = Integer.parseInt(first[1]);
		int[][] products = new int[n][3];
		for (int i = 0; i < n; i++) {
			String[] line = scanner.nextLine().split("\\s");
			products[i] = new int[]{Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])};
		}

		int[][] dp = new int[m][n / 10];
		
	}
}