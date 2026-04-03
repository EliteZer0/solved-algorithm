#include <stdio.h>

int main(){
    int size = 0;
    int target = 0;
    scanf("%d %d", &size, &target);
    for(int i = 0; i<size; i++){
        int compare = 0;
        scanf("%d ", &compare);
        if(compare<target){
            printf("%d ", compare);
        }
    }
    return 0;
}