//
// Created by chenqwwq on 2022/1/9.
//

#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int pairSum(ListNode *head) {
        ListNode *fast = head;
        ListNode *pre = nullptr;
        ListNode *curr = head;
        while (fast != nullptr){
            fast = fast->next->next;
            ListNode *next = curr->next;
            curr->next = pre;
            pre = curr;
            curr = next;
        }
        int ans = 0;
        while (curr != nullptr) {
            ans = max(curr->val + pre->val, ans);
            curr = curr->next;
            pre = pre->next;
        }
        return ans;
    }
};

