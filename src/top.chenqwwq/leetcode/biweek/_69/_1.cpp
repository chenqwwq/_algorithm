//
// Created by 陈炳鑫 on 2022/1/9.
//

#include "stdc++.h"
#include "string"
#include "common.h"

using namespace std;

class Solution {
public:
    string capitalizeTitle(string title) {
        auto n = title.length();
        int i = 0;
        while (i < n) {
            if (title[i] == ' ') {
                i++;
                continue;
            }
            int start = i;
            while (i < n && title[i] != ' ') {
                printf("替换字符 %c -> %c\n",title[i], tolower(title[i]));
                title[i] = tolower(title[i]);
                i++;
            }
            if (i - start > 2) {
                title[start] = toupper(title[start]);
            }
        }
        return title;
    }
};