//
// Created by chenqwwq on 2022/8/1.
//


#include "bits/stdc++.h"
#include "iostream"

using namespace std;

double dis(double x1, double y1, double x2, double y2) {
    return sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
}

int main() {
    double r, x1, y1, x2, y2;
    cin >> r >> x1 >> y1 >> x2 >> y2;
    double d = dis(x1, y1, x2, y2);
    if (d == 0) {
        printf("%.6f %.6f %.6f\n", x1 += r / 2, y1, r / 2);
        return 0;
    }
    if (d >= r) {
        printf("%.6f %.6f %.6f\n", x1, y1, r);
        return 0;
    }

    double k = (y2 - y1) / (x2 - x1);
    double a = k * k + 1, b = 2 * x1 + 2 * y1 * k, c = x1 * x1 + y1 * y1 - r * r;
    double delta = b * b - 4 * a * c;
    if (delta < 0) return 0;
    double p1 = (-b + sqrt(delta)) / (2 * a), p2 = (-b - sqrt(delta)) / (2 * a);
    double q1 = k * p1, q2 = k * p2;
    double d1 = dis(p1, q1, x2, y2), d2 = dis(p2, q2, x2, y2);
    double p, q, dd;
    if (d1 > d2)p = p1, q = q1, dd = d1;
    else p = p2, q = p2, dd = d2;
    printf("%.6f %.6f %.6f\n", (p + x2) / 2, (q + y2) / 2, dd / 2);
    return 0;
}