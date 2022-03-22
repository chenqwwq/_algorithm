//
// Created by 陈炳鑫 on 2022/3/18.
//


#include "stdc++.h"
#include "common.h"

using namespace std;

typedef long long ll;

class Bank {
private:
    vector<ll> bank;
    int userCnt;
public:
    Bank(vector<ll> &balance) {
        bank = balance;
        userCnt = balance.size();
    }

    bool transfer(int account1, int account2, ll money) {
        if (account1 > userCnt || account2 > userCnt) return false;
        if (bank[account1 - 1] < money) return false;
        bank[account1 - 1] -= money;
        bank[account2 - 1] += money;
        return true;
    }

    bool deposit(int account, ll money) {
        if (account > userCnt) return false;
        bank[account - 1] += money;
        return true;
    }

    bool withdraw(int account, ll money) {
        if (account > userCnt) return false;
        if (bank[account - 1] < money) return false;
        bank[account - 1] -= money;
        return true;
    }
};
