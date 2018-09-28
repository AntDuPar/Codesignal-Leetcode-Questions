/*
Given two binary trees t1 and t2, determine whether the second tree is a subtree of the first tree. 
A subtree for vertex v in a binary tree t is a tree consisting of v and all its descendants in t. 
Determine whether or not there is a vertex v (possibly none) in tree t1 such that a subtree for vertex v (possibly empty) in t1 equals t2.
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

boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    return lookAtTree(t1, t2);
}

boolean lookAtTree(Tree<Integer> t1, Tree<Integer> t2){
    if(t2 == null){
        return true;
    }
    if(t1 == null){
        return false;
    }
    if(checkTree(t1, t2)){
        return true;
    }
    boolean check = (lookAtTree(t1.left, t2) || lookAtTree(t1.right, t2));
    return check;
}

boolean checkTree(Tree<Integer> t1, Tree<Integer> t2){
    if(t1 == null && t2 == null){
        return true;
    }
    if(t1 == null || t2 == null){
        return false;
    }
    boolean check = (t1.value.equals(t2.value) && checkTree(t1.left, t2.left) && checkTree(t1.right, t2.right));
    return check;
}