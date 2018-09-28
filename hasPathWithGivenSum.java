/*
Given a binary tree t and an integer s, determine whether there is a root to leaf path in t such that the sum of vertex values equals s.
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

boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    if(t == null){
        return false;
    }
    return traverseTree(t, 0, s);
}
boolean checkB = false;
boolean traverseTree(Tree<Integer> tree, int sum, int check){
    int tmpSum = sum;
    tmpSum += tree.value;
    if(checkB == true){
        return true;
    }
    if(tmpSum == check && tree.left == null && tree.right == null){
        checkB = true;
        return true;
    }
    if(tmpSum == check){
        System.out.println(tree.value);
    }
    if(tree.left != null){
        checkB = traverseTree(tree.left, tmpSum, check);  
    }
    if(tree.right != null){
        checkB = traverseTree(tree.right, tmpSum, check);  
    }
    return checkB;
}