/*
Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

Given a ticket number n, determine if it's lucky or not.
*/
boolean isLucky(int n) {
    String tmp = Integer.toString(n);
    String one = tmp.substring(0, tmp.length()/2);
    String two = tmp.substring(tmp.length()/2);
    int oneT = 0;
    int twoT = 0;
    for(int i = 0; i<one.length(); i++){
        oneT += Integer.parseInt(String.valueOf(one.charAt(i)));
        twoT += Integer.parseInt(String.valueOf(two.charAt(i)));
    }
    if(oneT == twoT){
        return true;
    }
    return false;
}
