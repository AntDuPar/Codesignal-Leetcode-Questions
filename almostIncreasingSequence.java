/*
Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence 
by removing no more than one element from the array.
*/

boolean almostIncreasingSequence(int[] sequence) {
    for(int i = sequence.length-1; i >= 0; i--){
        int test = 0;
        int numPrev = 0;
        int start = 1;
        if(i == 0){
            numPrev = sequence[1];
            start = 2;
        }
        else{
            numPrev = sequence[0];
        }
        for(int k = start; k < sequence.length; k++){
            int next = sequence[k];
            if(k != i){
                if(numPrev >= next){
                    test++;
                }
                numPrev = sequence[k];
            }
        }
        if(test == 0){
            return true;
        }
    }
    return false;
}
