//
// Created by 陈炳鑫 on 2022/4/5.
//

#include <iostream>
#include "string.h"

using namespace std;

struct STU {
    int id, grade;
    char name[10];
};

int main() {
    int n, c;
    scanf("%d %d", &n, &c);
    STU stu[n];
    for (int i = 0; i < n; ++i) {
        scanf("%d %s %d", &stu[i].id, stu[i].name, &stu[i].grade);
    }
    sort(stu, stu + n, [&](STU s1, STU s2) -> int {
        if (c == 1) return s1.id < s2.id;
        if (c == 2) {
            int res = strcmp(s1.name,s2.name);
            return res != 0 ? (res <= 0) : s1.id < s2.id;
        }
        if (c == 3) return s1.grade == s2.grade ? s1.id < s2.id : s1.grade < s2.grade;
        return -1;
    });

    for (auto v: stu) {
        printf("%06d %s %d\n", v.id, v.name, v.grade);
    }
}