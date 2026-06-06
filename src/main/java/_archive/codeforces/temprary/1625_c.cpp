//
// Created by chenqwwq on 2022/1/13.
//

#include "iostream"

using namespace std;

int N, L, K;

int main() {
    scanf("%d %d %d", &N, &L, &K);
    int signs[N + 1], speed[N];
    for (int i = 0; i < N; ++i) {
        scanf("%d", &signs[i]);
    }
    signs[N] = L;
    for (int i = 0; i < N; ++i) {
        scanf("%d", &speed[i]);
    }

    long long ans = 0;
    for (int i = 0; i < N; ++i) {
        ans += speed[i] * (signs[i + 1] - signs[i]);
    }

    while (K > 0) {
        int maxReduce = INT_MIN, pos = -1;
        for (int i = 1; i < N; ++i) {
            if (speed[i] == -1) {
                continue;
            }
            int reduce = (signs[i + 1] - signs[i]) * (speed[i] - speed[i - 1]);
            if (reduce > maxReduce) {
                maxReduce = reduce;
                pos = i;
            }
        }
        if (maxReduce <= 0) {
            printf("%lld", ans);
            return 0;
        }
        ans -= maxReduce;
        signs[pos] = signs[pos + 1];
    }
    printf("%lld", ans);
    return 0;
}