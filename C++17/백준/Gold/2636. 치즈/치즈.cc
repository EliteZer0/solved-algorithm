#include <bits/stdc++.h>
using namespace std;

bool visited[100][100];
bool melt[100][100];
int board[100][100];
int height, width, turn, cheese;

bool check(int r, int c){
    return r >= 0 && r < height && c >= 0 && c < width;
}

int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, -1, 1};

void bfs(int r, int c){
    queue<pair<int,int>> que;
    que.push({r, c});
    visited[r][c] = true;

    while(!que.empty()){
        int cr = que.front().first;
        int cc = que.front().second;
        que.pop();

        for(int d = 0; d < 4; d++){
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if(!check(nr, nc)) continue;
            if(visited[nr][nc]) continue;

            if(board[nr][nc] == 0){
                visited[nr][nc] = true;
                que.push({nr, nc});
            } 
            else {
                melt[nr][nc] = true;
            }
        }
    }

    for(int i = 0; i<height; i++){
        for(int j = 0; j<width; j++){
            if(melt[i][j]){
                board[i][j] = 0;
                cheese--;
            }                
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> height >> width;
 
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            cin >> board[i][j];
            if(board[i][j] == 1)
                cheese ++;
        }
    }

    turn = 0;
    int lastCheese = 0;
    while (cheese > 0){
        for(int i = 0; i<height; i++){
            for(int j = 0; j<width; j++){
                visited[i][j] = false;
                melt[i][j] = false;
            }
        }

        int before = cheese;

        bfs(0, 0);
        
        turn++;
        lastCheese = before;
    }

    cout << turn << "\n" << lastCheese;
    
    return 0;
}