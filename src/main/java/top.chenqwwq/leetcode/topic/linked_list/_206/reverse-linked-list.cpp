//
// Created by 陈炳鑫 on 2022/3/27.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        if (!head || !head->next) return head;
        ListNode *pre = head, *curr = head->next;
        head->next = nullptr;
        while (curr) {
            ListNode *next = curr->next;
            curr->next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
};