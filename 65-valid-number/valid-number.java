class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false , seenDot = false, seenE = false , digitAfterE = false; 
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                seenDigit = true;
                if(seenE){
                    digitAfterE = true;
                }
            }
            else if(c=='.'){
                if(seenE == true || seenDot == true){
                    return false;
                }else{
                    seenDot = true;
                }
            }
            else if(c=='e'||c == 'E'){
                if(seenE == true || seenDigit == false){
                    return false;
                }else{
                    seenE = true;
                }
            }
            else if(c == '+' || c == '-'){
                if(i!=0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }else{
                return false;
            }
        }
        if(seenDigit && (!seenE || digitAfterE)){
            return true;
        }else{
            return false;
        }
    }
}