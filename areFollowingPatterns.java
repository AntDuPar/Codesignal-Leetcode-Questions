/*
Given an array strings, determine whether it follows the sequence given in the patterns array. 
In other words, there should be no i and j for which strings[i] = strings[j] 
and patterns[i] ? patterns[j] or for which strings[i] ? strings[j] and patterns[i] = patterns[j].

Example:

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.
*/

boolean areFollowingPatterns(String[] strings, String[] patterns) {
    Hashtable<String, String> savedInfo = new Hashtable<>();
    if(strings.length != patterns.length){
        return false;
    }
    for(int i = 0; i < strings.length; i++){
        if(savedInfo.containsKey(patterns[i])){
            if(!savedInfo.get(patterns[i]).equals(strings[i])){
                return false;
            }
        }
        else{
            if(savedInfo.containsValue(strings[i])){
                return false;
            }
            savedInfo.put(patterns[i], strings[i]);
        }
    }
    return true;
}
