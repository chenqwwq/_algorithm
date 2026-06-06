//
// Created by 陈炳鑫 on 2022/4/29.
//


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Person {
    string name;
    int age, worth;

    Person(string name, int age, int worth) : name(std::move(name)), age(age), worth(worth) {}
};

int main() {
    int N, K;
    cin >> N >> K;
    vector<vector<Person *>> ps(201, vector<Person *>{});
    string name;
    int age, worth;
    for (int i = 0; i < N; i++) {
        cin >> name >> age >> worth;
        ps[age].push_back(new Person(name, age, worth));
    }
    for (int i = 1; i <= 200; ++i) {
        sort(ps[i].begin(), ps[i].end(), [&](Person *p1, Person *p2) -> bool {
            if (p1->worth == p2->worth) {
                return p1->name < p2->name;
            }
            return p1->worth > p2->worth;
        });
    }
    int a, mmin, mmax;
    for (int i = 0; i < K; ++i) {
        cin >> a >> mmin >> mmax;
        printf("Case #%d:\n", i + 1);
        vector<int> pos(201, 0);
        bool flag = false;
        for (int j = 0; j < a; ++j) {
            int p = -1;
            for (int k = mmin; k <= mmax; ++k) {
                if (ps[k].empty() || pos[k] >= ps[k].size()) continue;
                if (p == -1 || ps[k][pos[k]]->worth > ps[p][pos[p]]->worth) {
                    p = k;
                }
            }
            if (p == -1) break;
            flag = true;
            printf("%s %d %d\n", ps[p][pos[p]]->name.c_str(), ps[p][pos[p]]->age, ps[p][pos[p]]->worth);
            pos[p]++;
        }
        if (!flag) printf("None\n");
    }
    return 0;
}
