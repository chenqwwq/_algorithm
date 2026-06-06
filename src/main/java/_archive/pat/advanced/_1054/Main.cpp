//
// Created by 陈炳鑫 on 2022/4/29.
//


#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    int M, N, num;
    cin >> M >> N;
    int total = M * N;
    unordered_map<int, int> hash;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> num;
            if (++hash[num] > (total >> 1)) {
                printf("%d\n", num);
                return 0;
            }
        }
    }
    return 0;
}