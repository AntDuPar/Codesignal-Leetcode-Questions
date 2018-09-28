/*
Given an encoded string, return its corresponding decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. Note: k is guaranteed to be a positive integer.

Note that your solution should have linear complexity because this is what you will be asked during an interview.

For s = "4[ab]", the output should be
decodeString(s) = "abababab";

For s = "2[b3[a]]", the output should be
decodeString(s) = "baaabaaa";

For s = "z1[y]zzz2[abc]", the output should be
decodeString(s) = "zyzzzabcabc".
*/

String decodeString(String s) {
    String solu = "";
    char [] stringList = s.toCharArray();
    boolean inBrackets = false;
    String inBra = "";
	String sNum = "";
    int num = 0;
	int numBrack = 0;
    for(int i = 0; i < stringList.length; i++){
        if(!Character.isDigit(stringList[i]) && inBrackets == false && stringList[i] != ']' && stringList[i] != '['){
            solu += stringList[i];
        }
        if(Character.isDigit(stringList[i]) && inBrackets == false){
			sNum += stringList[i];
        }
		if(stringList[i] == ']'){
			numBrack--;
			if(numBrack == 0){
				num = Integer.parseInt(String.valueOf(sNum));
				inBrackets = false;
				solu += multiplyString(num, inBra);
				inBra = "";
				sNum = "";
			}
		}
		if(inBrackets == true && i == stringList.length-1){
			inBrackets = false;
			solu += multiplyString(num, inBra);
			inBra = "";
		}
		if(inBrackets == true){
			inBra += stringList[i];
		}
        if(stringList[i] == '['){
			numBrack++;
            inBrackets = true;
        }
    }
    return solu;
}

String multiplyString(int k, String a){
    String result = "";
	if(a.contains("]") || a.contains("[")){
		a = decodeString(a);
	}
	for(int i = 0; i < k; i++){
		result += a;
	}
    return result;
}