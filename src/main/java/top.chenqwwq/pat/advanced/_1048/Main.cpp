//
// Created by 陈炳鑫 on 2022/4/26.
//


#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    int nums[N];
    for (int i = 0; i < N; ++i) cin >> nums[i];
    sort(nums, nums + N);
    int l = 0, r = N - 1;
    while (l < r){
        int sum = nums[l] + nums[r];
        if(sum == M){
            printf("%d %d\n",nums[l],nums[r]);
            return 0;
        }else if(sum < M) l++;
        else r--;
    }
    cout << "No Solution" << endl;
    return 0;
}