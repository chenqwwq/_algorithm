//
// Created by chenqwwq on 2024/7/15.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:

    unordered_set<int> ss;

    ListNode *modifiedList(vector<int> &nums, ListNode *head) {
        ss = unordered_set<int>(nums.begin(), nums.end());
        ListNode *fake = new ListNode;
        fake->next = head;
        dfs(fake, head);
        return fake->next;
    }

    void dfs(ListNode *pre, ListNode *cur) {
        if (!cur) return;
        if (ss.find(cur->val) != ss.end()) {
            pre->next = cur->next;
            dfs(pre, cur->next);
            return;
        }
        dfs(cur,cur->next);
    }
};