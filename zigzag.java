/*
A sequence of integers is called a zigzag sequence if each of its elements is either strictly less than all its neighbors or strictly greater than all its neighbors. For example, the sequence 4 2 3 1 5 3 is a zigzag, but 7 3 5 5 2 and 3 8 6 4 5 aren't. Sequence of length 1 is also a zigzag.

For a given array of integers return the length of its longest contiguous sub-array that is a zigzag sequence.

Example

For a = [9, 8, 8, 5, 3, 5, 3, 2, 8, 6], the output should be
zigzag(a) = 4.

The longest zigzag sub-arrays are [5, 3, 5, 3] and [3, 2, 8, 6] and they both have length 4.

For a = [4, 4], the output should be
zigzag(a) = 1.

The longest zigzag sub-array is [4] - it has only one element, which is strictly greater than all its neighbors (there are none of them).

Input/Output

[execution time limit] 3 seconds (java)

[input] array.integer a

Guaranteed constraints:
2 = a.length = 25,
0 = a[i] = 100.

[output] integer
*/

int zigzag(int[] a) {
        int len = 0;
        int tmp = 0;
        boolean inC = false;
        for(int i = 0; i < a.length; i++){
	        if(i == 0 || !inC){
		        tmp++;
		        inC = true;
	        }
	        if(i > 0 && i < a.length-1){
		        if(a[i] > a[i-1] && a[i] > a[i+1]){
			        tmp++;
                        }
	                else if(a[i] < a[i-1] && a[i] < a[i+1]){
			        tmp++;
                        }
	        	else{
		        	tmp++;
			        if(tmp > len){
				        len = tmp;
			        }
			        tmp = 0;
			        inC = false;
		        }
	        }
        }
        //edge case
        if(a.length == 2){
                len++;
        }
        return len;
}