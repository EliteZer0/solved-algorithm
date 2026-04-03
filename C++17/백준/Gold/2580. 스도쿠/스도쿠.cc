#include <bits/stdc++.h>
using namespace std;

struct sudoku_slot {
    int r, c;
};

int n = 9;
int sudoku[9][9];
vector<sudoku_slot> slot_list;
int slot_cnt;

bool can_place(int r, int c, int num){
    for(int i = 0; i<n; i++){
        // 가로줄
        if(sudoku[r][i] == num)
            return false;
        // 세로줄
        if(sudoku[i][c] == num)
            return false;
    }
    // 정사각형
    int sr = r/3 * 3;
    int sc = c/3 * 3;
    for(int i = 0; i<3; i++){
        for(int j = 0; j<3; j++){
            if(sudoku[sr+i][sc+j] == num)
                return false;
        }
    }
    return true;
}

bool solve(int depth){
    if(depth == slot_cnt) {
        return true;
    }
    sudoku_slot cur = slot_list[depth];
    int r = cur.r;
    int c = cur.c;
    for(int i = 1; i<=9; i++){
        if(!can_place(r, c, i)) continue;
        
        sudoku[r][c] = i;
        
        if(solve(depth+1))
            return true;
        
        sudoku[r][c] = 0;
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            cin >> sudoku[i][j];
            if(sudoku[i][j] == 0)
                slot_list.push_back({i, j});
        }
    }

    slot_cnt = slot_list.size();
    solve(0);

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            cout << sudoku[i][j];
            if(j<n-1) cout << ' ';
        }
        if(i<n-1) cout << '\n';
    }
    
    return 0;
}