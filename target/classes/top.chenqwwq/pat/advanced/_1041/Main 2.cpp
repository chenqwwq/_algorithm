//
// Created by 陈炳鑫 on 2022/4/19.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    vector<int> nums(n);
    int num;
    int hash[10001];
    for (int i = 0; i < n; ++i) {
        scanf("%d", &num);
        nums[i] = num;
        hash[num]++;
    }
    for (int i = 0; i < n; ++i) {
        if (hash[nums[i]] == 1) {
            printf("%d\n", nums[i]);
            return 0;
        }
    }
    printf("%s\n", "None");
    return 0;
}