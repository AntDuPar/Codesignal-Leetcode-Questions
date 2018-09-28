/*
Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the 
array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.
*/

boolean containsCloseNums(int[] nums, int k) {
    int one = 0;
    int two = 0;
    int distrance = 0;
    for(int i = 0; i < nums.length-1; i++){
        one = nums[i];
        for(int j = i+1; j < nums.length; j++){
            if(nums[j] == one){
                distrance = j-i;
                if(distrance <= k){
                    return true;
                }
            }
        }
    }
    return false;
}
