package top.chenqwwq;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        final CompletableFuture<Object> a = new CompletableFuture<>();
        final CompletableFuture<Object> b = new CompletableFuture<>();
        final CompletableFuture<Object> c = new CompletableFuture<>();
        final CompletableFuture<Object> d = new CompletableFuture<>();
        final CompletableFuture<Void> cf = CompletableFuture.allOf(a, b, c, d);
        System.out.println("111");
    }
}
