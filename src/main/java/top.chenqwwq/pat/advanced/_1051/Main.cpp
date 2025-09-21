//
// Created by 陈炳鑫 on 2022/4/26.
//


#include <iostream>

using namespace std;

int main() {
    int M, N, K;
    cin >> M >> N >> K;
    int stack[M];
    for (int i = 0; i < K; ++i) {
        int nums[N];
        for (int j = 0; j < N; ++j) cin >> nums[j];
        int pos = 0, curr = 0;
        memset(stack, 0, sizeof(stack));
        bool success = true;
        for (int j = 0; j < N; ++j) {
            while (curr < nums[j]) {
                stack[pos++] = ++curr;
                if (pos > M) {
                    success = false;
                    break;
                }
            }
            if (stack[pos - 1] == nums[j]) pos--;
            else {
                success = false;
                break;
            }
        }
        printf("%s\n", success ? "YES" : "NO");
    }
    return 0;
}