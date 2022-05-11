//
// Created by 陈炳鑫 on 2022/4/25.
//


#include <iostream>
#include <cstring>

using namespace std;

int main() {
    int N;
    cin >> N;
    int nums[N + 1];
    memset(nums,0, sizeof(nums));

    int sum = 0, num = 0;
    for (int i = 0; i < N; ++i) {
        cin >> num;
        sum += num;
        nums[i + 1] = sum;
    }

    int M;
    cin >> M;
    int l, r;
    // 0 1 3 7 21 30
    // 0 1 2 3 4  5
    for (int i = 0; i < M; ++i) {
        cin >> l >> r;
        if(l > r) swap(l,r);
        printf("%d\n", min(nums[r - 1] - nums[l - 1], sum - nums[r - 1] + nums[l - 1]));
    }
    return 0;
}