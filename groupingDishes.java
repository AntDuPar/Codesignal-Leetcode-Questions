/*
You have a list of dishes. Each dish is associated with a list of ingredients used to prepare it. You want to group the dishes by ingredients, so that for each ingredient you'll be able to find all the dishes that contain it (if there are at least 2 such dishes).

Return an array where each element is a list with the first element equal to the name of the ingredient and all of the other elements equal to the names of dishes that contain this ingredient. The dishes inside each list should be sorted lexicographically. The result array should be sorted lexicographically by the names of the ingredients in its elements.

Example

For
  dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Salad", "Salad", "Sandwich"],
                            ["Sauce", "Pizza", "Quesadilla", "Salad"],
                            ["Tomato", "Pizza", "Salad", "Sandwich"]]
For
  dishes = [["Pasta", "Tomato Sauce", "Onions", "Garlic"],
            ["Chicken Curry", "Chicken", "Curry Sauce"],
            ["Fried Rice", "Rice", "Onions", "Nuts"],
            ["Salad", "Spinach", "Nuts"],
            ["Sandwich", "Cheese", "Bread"],
            ["Quesadilla", "Chicken", "Cheese"]]
the output should be
  groupingDishes(dishes) = [["Cheese", "Quesadilla", "Sandwich"],
                            ["Chicken", "Chicken Curry", "Quesadilla"],
                            ["Nuts", "Fried Rice", "Salad"],
                            ["Onions", "Fried Rice", "Pasta"]]
*/

String[][] groupingDishes(String[][] dishes) {
    Hashtable<String, Integer> hash1 = new Hashtable<>();
    ArrayList<ArrayList<String>> tmpList = new ArrayList<ArrayList<String>>();
    for(int i = 0; i < dishes.length; i++){
        for(int l = 1; l < dishes[i].length; l++){
            if(hash1.containsKey(dishes[i][l])){
                int num = hash1.get(dishes[i][l]);
                num++;
                hash1.put(dishes[i][l], num);
            }
            else{
                int one = 1;
                hash1.put(dishes[i][l], one);                
            }
        }
    }
    Set<String> keys = hash1.keySet();
    int i = 0;
    Set<String> sortKey = new TreeSet<String>(keys);
    ArrayList<String> tmp = new ArrayList<>();
    for(String key: sortKey){
        ArrayList<String> empty = new ArrayList<>();
        if(hash1.get(key) > 1){
            tmp.add(key);
            tmpList.add(empty);
            i++;
        }
    }
    for(int m = 0; m < dishes.length; m++){
        for(int l = 1; l < dishes[m].length; l++){
            for(int k = 0; k < tmp.size(); k++){
                if(dishes[m][l].equals(tmp.get(k))){
                    tmpList.get(k).add(dishes[m][0]);
                }
            }
        }
    }
    for(int q = 0; q < tmpList.size(); q++){
        Collections.sort(tmpList.get(q));
        tmpList.get(q).add(0, tmp.get(q));
    }
    String[][] solution = new String[tmpList.size()][];
    for (int j = 0; j < tmpList.size(); j++) {
        ArrayList<String> row = tmpList.get(j);
        solution[j] = row.toArray(new String[row.size()]);
    }
    return solution;
}
