#include <bits/stdc++.h>
using namespace std;

int solve(int n){
    long long target = 1 % n;
    int digits = 1;
    while(true){
        if(target % n == 0)
            return digits;
        else {
            target = (target * 10 + 1) % n;
            digits ++;
        }
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    while(cin >> n){
        cout << solve(n) << '\n';
    }
    
    return 0;
}