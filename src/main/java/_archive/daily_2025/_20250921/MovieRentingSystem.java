package top.chenqwwq.leetcode.daily._2025._20250921;

import java.util.*;

class MovieRentingSystem {
    // (shop, movie) -> price
    private final Map<Long, Integer> shopMovieToPrice = new HashMap<>();

    // movie -> {(price, shop)}
    private final Map<Integer, TreeSet<int[]>> unrentedMovieToPriceShop = new HashMap<>();

    // {(price, shop, movie)}
    private final TreeSet<int[]> rentedMovies = new TreeSet<>((a, b) -> {
        if (a[0] != b[0]) {
            return a[0] - b[0];
        }
        if (a[1] != b[1]) {
            return a[1] - b[1];
        }
        return a[2] - b[2];
    });

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            // 把 shop 和 movie 存储到一个 long 中，方便作为 HashMap 的 key
            shopMovieToPrice.put((long) shop << 32 | movie, price);
            unrentedMovieToPriceShop
                    .computeIfAbsent(movie, s -> new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]))
                    .add(new int[]{price, shop});
        }
    }

    // 获取 unrentedMovieToPriceShop[movie] 的前 5 个 shop
    public List<Integer> search(int movie) {
        if (!unrentedMovieToPriceShop.containsKey(movie)) {
            return List.of();
        }
        List<Integer> ans = new ArrayList<>(5); // 预分配空间
        for (int[] ps : unrentedMovieToPriceShop.get(movie)) {
            ans.add(ps[1]);
            if (ans.size() == 5) {
                break;
            }
        }
        return ans;
    }

    // 借电影
    public void rent(int shop, int movie) {
        int price = shopMovieToPrice.get((long) shop << 32 | movie);
        // 从 unrentedMovieToPriceShop 移到 rentedMovies
        unrentedMovieToPriceShop.get(movie).remove(new int[]{price, shop});
        rentedMovies.add(new int[]{price, shop, movie});
    }

    // 还电影
    public void drop(int shop, int movie) {
        int price = shopMovieToPrice.get((long) shop << 32 | movie);
        // 从 rentedMovies 移到 unrentedMovieToPriceShop
        rentedMovies.remove(new int[]{price, shop, movie});
        unrentedMovieToPriceShop.get(movie).add(new int[]{price, shop});
    }

    // 获取 rentedMovies 的前 5 个 shop 和 movie
    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>(5); // 预分配空间
        for (int[] e : rentedMovies) {
            ans.add(List.of(e[1], e[2]));
            if (ans.size() == 5) {
                break;
            }
        }
        return ans;
    }
}
