/*
Note: Write a solution that only iterates over the string once and uses O(1) additional memory, since this is what you would 
be asked to do during a real interview.

Given a string s, find and return the first instance of a non-repeating character in it. If there is no such character, return '_'.
*/

char firstNotRepeatingCharacter(String s) {
    for(int i = 0; i < s.length(); i++){
        if(s.indexOf(s.charAt(i)) ==s.lastIndexOf(s.charAt(i)) ){
            return s.charAt(i);
        }
    }
    return '_';
}
