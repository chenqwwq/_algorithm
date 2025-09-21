//
// Created by 陈炳鑫 on 2022/5/4.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

// 素数筛
const int maxn = 1e9;
bool primes[maxn];

void sieve() {
    memset(primes, 0, sizeof(primes));
    for (int i = 3; i <= maxn; ++i) {
        for (int j = 2; j * i <= maxn; ++j) {
            primes[i * j] = false;
        }
    }
}

