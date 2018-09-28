//https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

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

List<Integer> values = new ArrayList<>();

int[] largestValuesInTreeRows(Tree<Integer> t) {
        List<Tree<Integer>> firstNode = new ArrayList<>();
        firstNode.add(t);
        if(t != null){
                values.add(t.value);
        }
        getHighest(firstNode);
        int[] answer = new int[values.size()];
        for(int i = 0; i < values.size(); i++){
                answer[i] = values.get(i);
        }
        return answer;
}

void getHighest(List<Tree<Integer>> nodes){
        List<Integer> tmpValues = new ArrayList<>();
        List<Tree<Integer>> newNodes = new ArrayList<>();
        for(Tree t : nodes){
                if(t != null){
                        if(t.left != null){
                                newNodes.add(t.left);
                                Tree<Integer> tmp = t.left;
                                tmpValues.add(tmp.value);
                        }
                        if(t.right != null){
                                newNodes.add(t.right);
                                Tree<Integer> tmp = t.right;
                                tmpValues.add((tmp.value));
                        }
                }
        }
        if(tmpValues.size() == 0){
                return;
        }
        int highest = -10000;
        for(int val : tmpValues){
                if(val > highest){
                        highest = val;
                }
        }
        values.add(highest);
        getHighest(newNodes);
        return;
}