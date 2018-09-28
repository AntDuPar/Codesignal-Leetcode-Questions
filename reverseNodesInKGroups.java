//https://leetcode.com/problems/reverse-nodes-in-k-group/description/

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//

ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
    if(l == null){
        return l;
    }
    ListNode<Integer> tmp = new ListNode<Integer>(0);
    tmp.next = l;
    ListNode<Integer> prev = tmp;
    int i = 0;
    ListNode<Integer> x = l;
    while(x != null){
        i++;
        if(i%k == 0){
            prev = reverse(prev, x.next);
            x = prev.next;
        }
        else{
            x = x.next;
        }
    }
    return tmp.next;
}

ListNode<Integer> reverse(ListNode<Integer> l, ListNode<Integer> j){
    ListNode<Integer> tmp = l.next;
    ListNode<Integer> curr = tmp.next;
    while(curr != j){
        tmp.next = curr.next;
        curr.next = l.next;
        l.next = curr;
        curr = tmp.next;
    }
 
    return tmp; 
}