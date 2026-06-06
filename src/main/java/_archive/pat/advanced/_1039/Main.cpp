//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>
#include <unordered_map>
#include <algorithm>
#include <vector>

using namespace std;

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    unordered_map<string, vector<int>> nameAndCourses;
    string name;
    for (int i = 0; i < k; ++i) {
        int course, cnt;
        scanf("%d %d", &course, &cnt);
        for (int j = 0; j < cnt; ++j) {
            cin >> name;
            if (nameAndCourses.find(name) == nameAndCourses.end()) nameAndCourses[name] = {};
            nameAndCourses[name].push_back(course);
        }
    }
    for (int i = 0; i < n; ++i) {
        cin >> name;
        if (nameAndCourses.find(name) == nameAndCourses.end()) {
            printf("%s %d\n", name.c_str(), 0);
        } else {
            auto nc = nameAndCourses[name];
            printf("%s %d", name.c_str(), (int) nc.size());
            sort(nc.begin(), nc.end());
            for (auto c: nc) cout << " " << c;
            cout << endl;
        }
    }
    return 0;
}