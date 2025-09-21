package top.chenqwwq.leetcode.contest.weekly._263._2;

/**
 * @author chen
 * @date 2021-10-18
 **/
public class Bank {

	long[] accounts;

	public Bank(long[] balance) {
		accounts = balance;
	}

	boolean check(int account) {
		return account > 0 && account <= accounts.length;
	}

	public boolean transfer(int account1, int account2, long money) {
		if (!check(account1) || !check(account2)) {
			return false;
		}
		if (accounts[account1 - 1] < money) {
			return false;
		}
		accounts[account1 - 1] -= money;
		accounts[account2 - 1] += money;
		return true;
	}

	public boolean deposit(int account, long money) {
		if(!check(account)){
			return false;
		}
		accounts[account - 1] += money;
		return true;
	}

	public boolean withdraw(int account, long money) {
		if(!check(account)){
			return false;
		}
		if (accounts[account - 1] < money) {
			return false;
		}
		accounts[account - 1] -= money;
		return true;
	}
}