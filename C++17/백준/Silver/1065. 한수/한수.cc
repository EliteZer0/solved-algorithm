#include <bits/stdc++.h>
using namespace std;

int count_AP(int num){
    if(num<100) return num;
    
    int cnt = 99;
    for(int i = 100; i<=num; i++){
        int hundreds = i/100;
        int tens = (i%100)/10;
        int units = i%10;
        if(hundreds - tens == tens- units) cnt++;
    }
    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;
    
    cout << count_AP(N);
    return 0;
}