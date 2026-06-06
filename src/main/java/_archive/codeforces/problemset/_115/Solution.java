package top.chenqwwq.codeforces._115;

import java.util.Scanner;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();
		final int[] leader = new int[n];
		for (int i = 0; i < n; i++) {
			leader[i] = scanner.nextInt() - 1;
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			int curr = 1,j = i;
			while (leader[j] >= 0){
				curr++;
				j = leader[j];
				leader[j] = -1;
			}
			max = Math.max(max,curr);
		}
		System.out.println(max);
	}
}
