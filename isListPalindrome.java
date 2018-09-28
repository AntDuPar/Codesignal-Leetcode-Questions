/*
Note: Try to solve this task in O(n) time using O(1) additional space, where n is the number of elements in l, 
since this is what you'll be asked to do during an interview.

Given a singly linked list of integers, determine whether or not it's a palindrome.
*/

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    List<Integer> tmp = new ArrayList<Integer>();
    while(l != null){
        tmp.add(l.value);
        l = l.next;
    }
    for(int i = 0; i < tmp.size()/2; i++){
        Integer front = new Integer(tmp.get(i));
        Integer back = new Integer(tmp.get(tmp.size()-i-1));
        if(!front.equals(back)){
            return false;
        }
    }
    return true;
}
