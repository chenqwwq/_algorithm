package top.chenqwwq;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chen
 * @date 2021-06-21
 **/
public class Solution {

	/**
	 * n 种商品各需要 goods[i] 个
	 * 第 j 个商店拥有第 i 种商品 shop[j][i] 个
	 * 求去的最少的门店
	 */
	public List<Integer> getMinShop(int[] goods, int[][] shop) {

		return dfs(goods, shop, 0, new ArrayList<>());
	}

	public List<Integer> dfs(int[] needs, int[][] shop, int i, List<Integer> shops) {
		if (check(needs)) {
			return new ArrayList<>(shops);
		}
		if (i >= shop.length) {
			return null;
		}
		// 不到这家店买
		final List<Integer> dfs = dfs(needs, shop, i + 1, shops);
		shops.add(i);
		// 到这家店买1
		reduce(needs, shop[i]);
		final List<Integer> dfs1 = dfs(needs, shop, i + 1, shops);
		add(needs, shop[i]);
		shops.remove(shops.size() - 1);

		return getLen(dfs) > getLen(dfs1) ? dfs1 : dfs;
	}

	public int getLen(List<Integer> list) {
		if (list == null) {
			return Integer.MAX_VALUE;
		}
		return list.size();
	}

	public void reduce(int[] needs, int[] cnts) {
		for (int i = 0; i < needs.length; i++) {
			needs[i] -= cnts[i];
		}
	}

	public void add(int[] needs, int[] cnts) {
		for (int i = 0; i < needs.length; i++) {
			needs[i] += cnts[i];
		}
	}

	public boolean check(int[] needs) {
		for (int i : needs) {
			if (i > 0) {
				return false;
			}
		}
		return true;
	}
}
