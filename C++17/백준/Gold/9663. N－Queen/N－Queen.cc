#include <bits/stdc++.h>
using namespace std;

int n;
int cnt = 0;
bool used_col[15];
bool used_negative_linear[29];
bool used_positvie_linear[29];

bool check_attack(int r, int c){
    // 세로줄
    if(used_col[c])
        return true;
    // \ 대각선
    // 행과 열의 차가 같으면
    // \ 대각선에 위치
    else if(used_negative_linear[r-c+n-1])
        return true;
    // / 대각선
    // 행과 열의 합이 r+c랑 같으면
    // / 대각선에 위치
    else if(used_positvie_linear[r+c])
        return true;
    return false;
}

void find_queen_arrangement(int depth){
    if(depth == n){
        cnt++;
        return;
    }
    for(int i = 0; i<n; i++){
        if(check_attack(depth, i)) continue;
        used_col[i] = true;
        used_negative_linear[depth-i+n-1] = true;
        used_positvie_linear[depth+i] = true;
        find_queen_arrangement(depth+1);
        used_col[i] = false;
        used_negative_linear[depth-i+n-1] = false;
        used_positvie_linear[depth+i] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    find_queen_arrangement(0);
    
    cout << cnt;
    return 0;
}