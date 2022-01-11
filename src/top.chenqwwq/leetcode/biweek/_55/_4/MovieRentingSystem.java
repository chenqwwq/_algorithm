package top.chenqwwq.leetcode.biweek._55._4;

import java.util.*;

/**
 * @author chen
 * @date 2021/6/26
 **/
public class MovieRentingSystem {

	static class Entry {
		int shop;
		int movie;
		int price;

		public Entry(int shop, int movie, int price) {
			this.shop = shop;
			this.movie = movie;
			this.price = price;
		}

		public int getShop() {
			return shop;
		}

		public int getMovie() {
			return movie;
		}

		public int getPrice() {
			return price;
		}
	}

	Map<Integer, PriorityQueue<Entry>> hash = new HashMap<>();
	Set<String> rented = new HashSet<>();
	Map<String, Entry> map = new HashMap<>();
	PriorityQueue<Entry> rentedQueue = new PriorityQueue<>(Comparator.comparingInt(Entry::getPrice).thenComparingInt(Entry::getShop).thenComparingInt(Entry::getMovie));

	public MovieRentingSystem(int n, int[][] entries) {
		for (int[] entry : entries) {
			final Entry node = new Entry(entry[0], entry[1], entry[2]);
			PriorityQueue<Entry> queue = hash.getOrDefault(node.movie, new PriorityQueue<>(Comparator.comparingInt(Entry::getPrice).thenComparingInt(Entry::getShop)));
			queue.add(node);
			hash.put(node.movie, queue);
			map.put("" + node.shop + node.movie, node);
		}
	}


	public List<Integer> search(int movie) {
		final PriorityQueue<Entry> entries = hash.get(movie);
		if(entries == null || entries.isEmpty()){
			return new ArrayList<>();
		}
		List<Integer> ans = new ArrayList<>();
		List<Entry> polls = new ArrayList<>();
		while (ans.size() < 5 && !entries.isEmpty()) {
			final Entry poll = entries.poll();
			polls.add(poll);
			if (!rented.contains("" + poll.shop + poll.movie)) {
				ans.add(poll.shop);
			}
		}
		entries.addAll(polls);
		hash.put(movie, entries);
		return ans;
	}

	public void rent(int shop, int movie) {
		final String key = "" + shop + movie;
		rented.add(key);
		rentedQueue.add(map.get(key));
	}

	public void drop(int shop, int movie) {
		final String key = "" + shop + movie;
		rented.remove(key);
		rentedQueue.remove(map.get(key));
	}

	public List<List<Integer>> report() {
		List<List<Integer>> ans = new ArrayList<>();
		List<Entry> polls = new ArrayList<>();
		while (ans.size() < 5 && !rentedQueue.isEmpty()) {
			final Entry poll = rentedQueue.poll();
			polls.add(poll);
			ans.add(Arrays.asList(poll.shop, poll.movie));
		}
		rentedQueue.addAll(polls);
		return ans;
	}
}