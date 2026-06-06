package top.chenqwwq.codeforces._4A;

import java.util.Scanner;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Watermelon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int weight = scanner.nextInt();
		System.out.println(weight <= 2 || (weight % 2) == 1 ? "NO" : "YES");
	}
}
