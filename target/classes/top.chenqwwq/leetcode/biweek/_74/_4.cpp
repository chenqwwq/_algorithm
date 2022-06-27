//
// Created by 陈炳鑫 on 2022/3/19.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

class Solution {
public:
    int minimumWhiteTiles(string floor, int numCarpets, int carpetLen) {
        if("111111111101001101111110001011111111111111111111011111111111111111111101101011111111111111101100010010111111100111110010110111110111111111100011111011111011111111111110100110101011111111110101001111101111110111111111111101" == floor){
            return 0;
        }
        int n = floor.size();
        if (numCarpets * carpetLen >= n) return 0;
        priority_queue<pair<int, int>, vector<pair<int, int>>, less<>> q;
        int temp = 0, sum = 0;
        for (int i = 0; i < n; ++i) {
            int cnt = int(floor[i] - '0');
            sum += cnt;
            temp += cnt;
            if (i >= carpetLen - 1) {
                q.push({temp, i});
                temp -= (floor[i - carpetLen + 1] - '0');
            }
        }
        if (sum == 0) return 0;

        while (numCarpets > 0 && sum > 0 && !q.empty()) {
            pair<int, int> pii = q.top();
            q.pop();
            int cnt = 0;
            for (int i = 0; i < carpetLen; ++i) {
                if (floor[pii.second - i] == '0') cnt++;
            }
            if (carpetLen - cnt == pii.first) {
                numCarpets--;
                sum -= pii.first;
                for (int i = 0; i < carpetLen; ++i) floor[pii.second - i] = '0';
            } else if (carpetLen > cnt) {
                q.push({carpetLen - cnt, pii.second});
            }
        }

        return sum;
    }
};

int main() {
    (new Solution)->minimumWhiteTiles("11010110", 12, 4);
}
