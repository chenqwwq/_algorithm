//
// Created by 陈炳鑫 on 2022/3/28.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) {
        ListNode *fake = new ListNode, *node = fake;
        int num = 0;
        while (l1 && l2) {
            int sum = l1->val + l2->val + num;
            num = sum / 10;
            node->next = new ListNode(sum % 10);
            node = node->next;
            l1 = l1->next;
            l2 = l2->next;
        }
        while (l1) {
            int sum = l1->val + num;
            num = sum / 10;
            node->next = new ListNode(sum % 10);
            node = node->next;
            l1 = l1->next;
        }
        while (l2) {
            int sum = l2->val + num;
            num = sum / 10;
            node->next = new ListNode(sum % 10);
            node = node->next;
            l2 = l2->next;
        }
        if (num > 0) {
            node->next = new ListNode(num);
        }
        return fake->next;
    }
};