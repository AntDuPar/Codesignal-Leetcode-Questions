/*
Given a binary tree t, determine whether it is symmetric around its center, i.e. each side mirrors the other.
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

boolean isTreeSymmetric(Tree<Integer> t) {
    if(t == null){
        return true;
    }
    if(t.left == null && t.right == null){
        return true;
    }
    if(t.left != null && t.right == null){
        return false;
    }
    if(t.left == null && t.right != null){
        return false;
    }
    return recursiveCheck(t.right, t.left);    
}

boolean recursiveCheck(Tree<Integer> r, Tree<Integer> l){
    if(r == null || l == null){
        return r == null && l == null;
    }
    return r.value.equals(l.value) && recursiveCheck(r.right, l.left) && recursiveCheck(r.left, l.right);
}