//
// Created by chenqwwq on 2022/1/19.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

#define MAX_BITS 30

class Solution {
    struct Node {
        Node *next[2]{nullptr, nullptr};

        Node() {}
    } root;

    void insert(int num) {
        Node *node = &root;
        for (int i = MAX_BITS; i >= 0; --i) {
            int target = (num >> i) & 1;
            if (!node->next[target]) node->next[target] = new Node();
            node = node->next[target];
        }
    }

    int calculation(int num) {
        int curr = 0;
        Node *node = &root;
        for (int i = MAX_BITS; i >= 0; --i) {
            int n = (num >> i) & 1;
            if (node->next[n ^ 1]) {
                curr |= (1 << i);
                node = node->next[n ^ 1];
            } else node = node->next[n];
        }
        return curr;
    }

public:
    int findMaximumXOR(vector<int> &nums) {
        auto n = nums.size();
        if (n < 2) return 0;
        int ans = INT_MIN;
        for (int i = 1; i < n; i++) {
            insert(nums[i - 1]);
            ans = max(ans, calculation(nums[i]));
        }
        return ans;
    }
};