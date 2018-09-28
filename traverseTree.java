/*
Note: Try to solve this task without using recursion, since this is what you'll be asked to do during an interview.

Given a binary tree of integers t, return its node values in the following format:

The first element should be the value of the tree root;
The next elements should be the values of the nodes at height 1 (i.e. the root children), ordered from the leftmost to the rightmost one;
The elements after that should be the values of the nodes at height 2 (i.e. the children of the nodes at height 1) ordered in the same way;
Etc.

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

int[] traverseTree(Tree<Integer> t) {
    boolean done = false;
    List<Integer> values = new ArrayList<>();
    List<Tree> nodes = new ArrayList<>();
    if(t == null){
        return new int[0];
    }
    nodes.add(t);
    values.add(t.value);
    while (!done){
        List<Tree> nodesTMP = new ArrayList<>();
        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).left != null){
                nodesTMP.add(nodes.get(i).left);
                Tree<Integer> tmp = nodes.get(i).left;
                values.add(tmp.value);
            }
            if(nodes.get(i).right != null){
                nodesTMP.add(nodes.get(i).right);
                Tree<Integer> tmp2 = nodes.get(i).right;
                values.add(tmp2.value);
            }
        }
        if(nodesTMP.size() == 0){
            done = true;
        }
        nodes = nodesTMP;
    }
    int vals[] = new int[values.size()];
    for(int i = 0; i < values.size(); i++){
        vals[i] = values.get(i);
    }
    return vals;
}