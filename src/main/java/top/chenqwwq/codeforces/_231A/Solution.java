package top.chenqwwq.codeforces._231A;

import java.util.Scanner;

/**
 * @author chenbingxin
 * @date 2021/12/17
 **/
public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int lc = scanner.nextInt();

		int ans = 0;
		for (int i = 0; i < lc; i++) {
			int cnt = 0;
			for (int j = 0;j < 3;j++){
				cnt += scanner.nextInt();
			}
			if(cnt >= 2){
				ans++;
			}
		}
		System.out.println(ans);
	}
}
