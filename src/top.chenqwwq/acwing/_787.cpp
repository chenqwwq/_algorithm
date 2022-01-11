//
// Created by 陈炳鑫 on 2022/1/8.
//

#include <iostream>

using namespace std;

const int N = 1e6 + 10;
int n;
int arr[N];

void quick_sort(int arr[], int l, int r) {
    if (l >= r) return;
    int rivet = arr[l], i = l - 1, j = r + 1;
    while (i < j) {
        do i++; while (arr[i] < rivet);
        do j--; while (arr[j] > rivet);
//        while (arr[++i] < rivet);
//        while (arr[--j] > rivet);
        if (i < j) swap(arr[i], arr[j]);
    }
    quick_sort(arr, l, j);
    quick_sort(arr, j + 1, r);
}

int main() {
    scanf("%d", &n);
    for (int i = 0; i < n; ++i) scanf("%d", &arr[i]);
    quick_sort(arr, 0, n - 1);
    for (int i = 0; i < n; ++i) printf("%d ", arr[i]);
    return 0;
}
