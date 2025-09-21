//
// Created by chenqwwq on 2024/6/17.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

int MOD = 10007;

// 计算 C(n,m)
//int combination(int n, int m) {
//    int ans = 1;
//    for (int i = n - m + 1; i < n; i++) {
//        ans = (ans * i % MOD);
//    }
//
//    while (m) ans /= m--;
//    return m;
//}

int combination(int n, int m) {

}


// 求最大公应数(辗转相除法
int gcd(int a, int b) {
    if (!b) return a;
    return gcd(b, a % b);
}