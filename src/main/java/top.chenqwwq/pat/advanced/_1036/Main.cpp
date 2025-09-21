//
// Created by 陈炳鑫 on 2022/4/18.
//


#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);
    string name, ID;
    char gender;
    int grade;
    vector<pair<string, string>> ps(2);
    int fg = -1, mg = -1;
    for (int i = 0; i < n; ++i) {
        cin >> name >> gender >> ID;
        scanf("%d", &grade);
        if (gender == 'F') {
            if (fg == -1 || fg < grade) {
                fg = grade;
                ps[0] = make_pair(name, ID);
            }
        } else if (gender == 'M') {
            if (mg == -1 || mg > grade) {
                mg = grade;
                ps[1] = make_pair(name, ID);
            }
        }
    }
    if (fg == -1) printf("%s\n", "Absent");
    else printf("%s %s\n", ps[0].first.c_str(), ps[0].second.c_str());
    if (mg == -1) printf("%s\n", "Absent");
    else printf("%s %s\n", ps[1].first.c_str(), ps[1].second.c_str());
    if (fg == -1 || mg == -1) printf("%s\n", "NA");
    else printf("%d\n", fg - mg);
    return 0;
}