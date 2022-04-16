//
// Created by 陈炳鑫 on 2022/4/15.
//



#include <iostream>
#include <vector>
#include "algorithm"

using namespace std;
typedef pair<double, double> pid;

int main() {
    int n;
    double capacity, distance, pu;
    scanf("%lf %lf %lf %d", &capacity, &distance, &pu, &n);
    vector<pid> ps(n + 1, make_pair(0.0f, 0));
    for (int i = 0; i < n; ++i) scanf("%lf %lf", &ps[i].second, &ps[i].first);
    ps[n].first = distance;
    ps[n].second = 0;
    sort(ps.begin(), ps.end());
    auto mmax = double(pu * capacity);
    if (ps[0].first != 0) {
        printf("The maximum travel distance = 0.00");
        return 0;
    }
    double remain = 0, dis = 0.0;
    double cost = 0.0;
    for (int i = 0; i < n;) {
        if (ps[i + 1].first - ps[i].first > mmax) {
            printf("The maximum travel distance = %.2lf\n", dis + mmax);
            return 0;
        }
        if (ps[i + 1].second < ps[i].second) {
            dis = ps[i + 1].first;
            cost += ((ps[i + 1].first - ps[i].first) / pu - remain) * ps[i].second;
            remain = 0;
            i++;
        } else {
            int j = i + 1;
            while (j < n && ps[j].second > ps[i].second && float(ps[j + 1].first - ps[i].first) <= mmax) j++;
            double diss = ps[j].second < ps[i].second ? (ps[j].first - ps[i].first) : mmax;
            dis = ps[j].first;
            cost += ((diss / pu) - remain) * ps[i].second;
            remain = ps[j].second < ps[i].second ? 0 : capacity - (ps[j].first - ps[i].first) / pu;
            i = j;
        }
    }
    printf("%.2f\n", cost);
    return 0;
}