//
// Created by chenqwwq on 2023/4/11.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<int> nextLargerNodes(ListNode *head) {
        vector<int> nodes;
        while (head) {
            nodes.push_back(head->val);
            head = head->next;
        }
        int n = (int) nodes.size();

        vector<int> ans(n, 0);
        int stack[n], p = 0;
        for (int i = 0; i < n; i++) {
            // 维护一个单调递减栈
            while (p > 0 && nodes[stack[p - 1]] < nodes[i]) {
                ans[stack[--p]] = nodes[i];
            }
            stack[p++] = i;
        }
        return ans;
    }
};