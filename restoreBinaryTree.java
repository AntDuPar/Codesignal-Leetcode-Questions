//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

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

Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
    return makeTree(inorder, preorder);
}

Tree<Integer> makeTree(int[] inorder, int[] preorder){
    if(inorder.length == 0){
        return null;
    }
    int value = preorder[0];
    Tree<Integer> node = new Tree<Integer>(value);
    if(inorder.length == 1){
        return node;
    }
    int sizeLeft = 0;
    int sizeRight = 0;
    boolean seen = false;
    for(int i = 0; i < inorder.length; i++){
        if(inorder[i] == value){
            seen = true;
        }
        else if(!seen){
            sizeLeft++;
        }
        else{
            sizeRight++;
        }
    }
    seen = false;
    int[] inOrderLeft = new int[sizeLeft];
    int[] inOrderRight = new int[sizeRight];
    int[] preOrderLeft = new int[sizeLeft];
    int[] preOrderRight = new int[sizeRight];
    int tmp = 0;
    for(int x = 0; x < inorder.length; x++){
        if(inorder[x] == value){
            seen = true;
            tmp = 0;
        }
        else if(!seen){
            inOrderLeft[tmp] = inorder[x];
            tmp++;
        }
        else{
            inOrderRight[tmp] = inorder[x];
            tmp++;
        }
    }
    tmp = 0;
    for(int j = 1; j < preorder.length; j++){
        if(j < sizeLeft + 1){
            preOrderLeft[tmp] = preorder[j];
            tmp++;
        }
        if(j == sizeLeft + 1){
            tmp = 0;
        }
        if(j >= sizeLeft + 1){
            preOrderRight[tmp] = preorder[j];
            tmp++;
        }
        
    }
    node.left = makeTree(inOrderLeft, preOrderLeft);
    node.right = makeTree(inOrderRight, preOrderRight);
    return node;
}