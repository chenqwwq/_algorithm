package top.chenqwwq.pat.advanced._1015;

import java.util.Scanner;

/**
 * 1015 Reversible Primes (20 point(s))
 * A reversible prime in any number system is a prime whose "reverse" in that number system is also a prime. For example in the decimal system 73 is a reversible prime because its reverse 37 is also a prime.
 * <p>
 * Now given any two positive integers N (<10
 * ​5
 * ​​ ) and D (1<D≤10), you are supposed to tell if N is a reversible prime with radix D.
 * <p>
 * Input Specification:
 * The input file consists of several test cases. Each case occupies a line which contains two integers N and D. The input is finished by a negative N.
 * <p>
 * Output Specification:
 * For each test case, print in one line Yes if N is a reversible prime with radix D, or No if not.
 * <p>
 * Sample Input:
 * 73 10
 * 23 2
 * 23 10
 * -2
 * Sample Output:
 * Yes
 * Yes
 * No
 *
 * @author chen
 * @date 2021-06-01
 **/
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			final String line = scanner.nextLine();
			final String[] nums = line.split("\\s");
			if (nums.length == 1) {
				return;
			}
			int num1 = Integer.parseInt(nums[0]), radix = Integer.parseInt(nums[1]);
			final boolean isPrime = isPrime(num1) && isPrime(getReverseNum(num1, radix));
			System.out.println(isPrime ? "Yes" : "No");
		}
		scanner.close();
	}

	public static int getReverseNum(int num, int radix) {
		int ans = 0;
		while (num != 0) {
			ans = ans * radix + (num % radix);
			num /= radix;
		}
		return ans;
	}


	public static boolean isPrime(int num) {
		if (num <= 3) {
			return num > 1;
		}
		if (num % 6 != 1 && num % 6 != 5) {
			return false;
		}
		int sqrt = (int) Math.sqrt(num);
		for (int i = 5; i <= sqrt; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
}
