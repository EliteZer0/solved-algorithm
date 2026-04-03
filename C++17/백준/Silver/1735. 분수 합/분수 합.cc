#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    int a, b, p, q;
    cin >> a >> b >> p >> q;

    // a/b p/q -> (a*q + p*b) / b*q
    int numerator = a*q + p*b;
    int denominator = b*q;
    bool isImproper = numerator > denominator ? true : false;
    int x = numerator;
    int y = denominator;
    int r = isImproper ?
            numerator % denominator : denominator % numerator;

    while (true){
        if(isImproper){
            if(r == 0){
                cout << numerator/y << ' ' << denominator/y;
                break;
            }
            else {
                int temp = r;
                r = y%r;
                y = temp;
            }
        }
        else{
            if(r == 0){
                cout << numerator/x << ' ' << denominator/x;
                break;   
            }
            else {
                int temp = r;
                r = x%r;
                x = temp;
            }
        }
    }
    return 0;
}