/*
You are given a recursive notation of a binary tree: each node of a tree is represented as a set of three elements:

value of the node;
left subtree;
right subtree.
So, a tree can be written as (value left_subtree right_subtree). It is guaranteed that 1 = value = 109. If a node doesn't exist then it is represented as an empty set: (). For example, here is a representation of a tree in the given picture:

(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))


Your task is to obtain a list of nodes, that are the most distant from the tree root, in the order from left to right.

In the notation of a node its value and subtrees are separated by exactly one space character.

Example

For

tree = "(2 (7 (2 () ()) (6 (5 () ()) (11 () ()))) (5 () (9 (4 () ()) ())))"
the output should be
treeBottom(tree) = [5, 11, 4].
*/

int[] treeBottom(String tree) {
    int count = 0;
    int highest = 0;
    String[] treeList = tree.split(" ");
    List<String> nodes = new ArrayList<>();
    for(String c : treeList){
        for(char d : c.toCharArray()){
            if(d == '('){
                count++;
            }
            if(d == ')'){
                count--;
            }
        }
        String newS = c.replace("(", "");
        newS = newS.replace(")", "");
        newS = newS.replace(" ", "");
        if(newS.length() > 0){
            nodes.add(newS);
            nodes.add("" + count);
            if(count > highest){
                highest = count;
            }
        }
    }
    List<Integer> sol = new ArrayList<>();
    for(int i = 0; i < nodes.size(); i+=2){
        int countN = Integer.parseInt(nodes.get(i+1));
        if(countN == highest){
            sol.add(Integer.parseInt(nodes.get(i)));
        }
    }
    int[] solution = new int[sol.size()];
    for(int i = 0; i < sol.size(); i++){
        solution[i] = sol.get(i);
    }
    return solution;
}