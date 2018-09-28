/*
Note: Your solution should have only one BST traversal and O(1) extra space complexity, since this is what you will be asked to accomplish in an interview.

A tree is considered a binary search tree (BST) if for each of its nodes the following is true:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and the right subtrees must also be binary search trees.
Given a binary search tree t, find the kth smallest element in it.

Note that kth smallest element means kth element in increasing order. See examples for better understanding.

*/

//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }

ArrayList<Integer> treeList;
int kthSmallestInBST(Tree<Integer> t, int k) {
    treeList = new ArrayList<>();
    makeList(t);
    return treeList.get(k-1);
}

void makeList(Tree<Integer> t){
    if(t.left != null){
        makeList(t.left);
    }
    treeList.add(t.value);
    if(t.right != null){
        makeList(t.right);
    }
}