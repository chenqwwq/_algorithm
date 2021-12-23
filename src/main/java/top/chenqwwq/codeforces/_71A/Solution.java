package top.chenqwwq.codeforces._71A;

import java.util.Scanner;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cnt = scanner.nextInt();
		String line;
		while (cnt-- >= 0) {
			line = scanner.nextLine();
			if (line.length() <= 10) {
				System.out.println(line);
			} else {
				System.out.println(String.valueOf(line.charAt(0)) + (line.length() - 2) + line.charAt(line.length() - 1));
			}
		}
	}
}
