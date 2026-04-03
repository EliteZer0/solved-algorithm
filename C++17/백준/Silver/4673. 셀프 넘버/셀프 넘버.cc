#include <bits/stdc++.h>
using namespace std;

void find_selfnumber(vector<bool>& exist){
    for(int i = 1; i<10000; i++){
        int thousands = i/1000;
        int hundreds = (i%1000)/100;
        int tens = (i%100)/10;
        int units = i%10;
        int num;
        if(i<10){
            num = i+i;
            exist[num] = true;   
        }
        else if(i<100){
            num = i + tens + units;
            exist[num] = true;
        }
        else if(i<1000){
            num = i + hundreds + tens + units;
            exist[num] = true;
        }
        else{
            num = i + thousands + hundreds + tens + units;
            exist[num] = true;
        }
    }
}

int main() {
    vector<bool> exist(20000);
    exist[0] = true;
    find_selfnumber(exist);

    for(int i = 1; i<10000; i++){
        if(!exist[i]) cout << i << "\n";
    }
    
    return 0;
}