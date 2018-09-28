//https://leetcode.com/problems/climbing-stairs/description/

int[][] climbingStaircase(int n, int k) {
    ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
    makeList(n, k, answer, new ArrayList<Integer>());
    int[][] returnAnsw = answer.stream().map(u->u.stream().mapToInt(i->i).toArray()).toArray(int[][]::new);
    return returnAnsw;
}

void makeList(int n, int k, ArrayList<ArrayList<Integer>> answer, ArrayList<Integer> steps){
    if(n == 0){
        ArrayList<Integer> tmp = new ArrayList<Integer>(steps);
        answer.add(tmp);
    }
    else{
        for(int i = 1; i < k+1; i++){
            if(i <= n){
                steps.add(i);
                makeList(n-i, k, answer, steps);
                steps.remove(steps.size()-1);
            }
        }
    }
}