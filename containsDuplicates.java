/*
Given an array of integers, write a function that determines whether the array contains any duplicates.
Your function should return true if any element appears at least twice in the array, and it should return false if every element is distinct.
*/

boolean containsDuplicates(int[] a) {
    HashSet<Integer> mySet = new HashSet<>();
    for(int i: a){
        mySet.add(i);
    }
    return !(mySet.size() == a.length);
}
