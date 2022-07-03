//
// Created by 陈炳鑫 on 2022/2/20.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    ListNode *mergeNodes(ListNode *head) {
        auto *fake = new ListNode;
        ListNode *curr = fake;
        while (head != nullptr) {
            head = head->next;
            int tmp = 0;
            while (head != nullptr && head->val != 0) {
                tmp += head->val;
                head = head->next;
            }
            if(tmp != 0) curr = curr->next = new ListNode(tmp);
        }
        return fake->next;
    }
};