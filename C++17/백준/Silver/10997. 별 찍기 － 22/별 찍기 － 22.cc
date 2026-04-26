#include <bits/stdc++.h>
using namespace std;
 
char board[399][397];
// 시작 위치는 현재 테두리의 오른쪽 위
void drawStar(int n, int r, int c) {
    int width = 4 * n - 3;
    int height = width + 2;
    
    // 위쪽 가로줄을 오른쪽에서 왼쪽으로 그림
    for (int i = 1; i < width; i++) board[r][c--] = '*';
    // 왼쪽 세로줄을 위에서 아래로 그림
    for (int i = 1; i < height; i++) board[r++][c] = '*';
    // 아래쪽 가로줄을 왼쪽에서 오른쪽으로 그림
    for (int i = 1; i < width; i++) board[r][c++] = '*';
    /*
    오른쪽 세로줄을 아래에서 위로 그림
    단, 위쪽 입구가 열려 있어야 하므로 height - 2까지
    */ 
    for (int i = 1; i < height - 2; i++) board[r--][c] = '*';
    
    // 안쪽 별 모양으로 이어지는 연결 부분
    board[r][c] = '*'; 
    c--;
    board[r][c] = '*';
    
    // n == 2가 안쪽의 기본 모양
    if (n == 2) {
        board[r][c-1] = '*';
        board[r+1][c-1] = '*';
        board[r+2][c-1] = '*';
        return;
    }
 
    drawStar(n-1, r, c-1);
}
 
int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    cin >> n;
 
    if (n == 1) {
        printf("*");
        return 0;
    }

    /*
    n == 1일 때는 예외
    가로 : 1 -> 5 -> 9 -> 13 -> 4(n-1) + 1 = 4n - 3
    세로 : 1 -> 7 -> 11 -> 15 -> 가로 + 2
    */
    int width = 4 * n - 3;
    int height = width + 2;
 
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            board[i][j] = ' ';
        }
    }

    /*
    시작점은 첫번째 행의 마지막 열
    */
    int r = 0;
    int c = 4*n - 4;
    
    drawStar(n, r, c);
 
    for (int i = 0; i < height; i++) {
        // 두번째 줄에 공백이 있으면 안됨
        if (i == 1) {
            cout << "*\n";
            continue;
        }
 
        for (int j = 0; j < width; j++) {
            cout << board[i][j];
        }
        cout << "\n";
    }
    
    return 0;
}