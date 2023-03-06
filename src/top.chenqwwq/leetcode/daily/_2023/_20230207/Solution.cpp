//
// Created by chenqwwq on 2023/2/7.
//


#include "bits/stdc++.h"
#include "iostream"

typedef long long ll;

using namespace std;

class Solution {
public:
    vector<string> alertNames(vector<string> &keyName, vector<string> &keyTime) {
        auto getTime = [](string s) {
            return (s[0] - '0') * 10 * 60 + (s[1] - '0') * 60 + (s[3] - '0') * 10 + s[4] - '0';
        };
        int n = (int) keyName.size();
        map<string, vector<int>> name2Times;
        for (int i = 0; i < n; i++) {
            if (name2Times.find(keyName[i]) == name2Times.end()) name2Times[keyName[i]] = {};
            name2Times[keyName[i]].push_back(getTime(keyTime[i]));
        }


        vector<string> ans = {};
        for (auto entry: name2Times) {
            vector<int> &times = entry.second;
            if (times.size() < 3) continue;
            sort(times.begin(), times.end());
            for (int j = 2; j < times.size(); j++) {
                if (times[j] - times[j - 2] <= 60) {
                    ans.push_back(entry.first);
                    break;
                }
            }
        }
        return ans;
    }
};