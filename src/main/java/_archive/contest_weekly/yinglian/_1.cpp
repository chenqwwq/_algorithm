//
// Created by 陈炳鑫 on 2022/3/13.
//


#include "bits/stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    bool isPalindrome(ListNode *head) {
        vector<int> stack;
        ListNode *fake = head;
        while (fake) {
            stack.push_back(fake->val);
            fake = fake->next;
        }
        return handle(stack,0,stack.size()-1, false);
    }

    bool handle(vector<int> &nums, int l, int r, bool flag) {
        while (l < r) {
            if (nums[l] != nums[r]) {
                if (flag) return false;
                return handle(nums, l + 1, r, true) or handle(nums, l, r - 1, true);
            }
            l++;
            r--;
        }
        return true;
    }
};