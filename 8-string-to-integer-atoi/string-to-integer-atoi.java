class Solution {
    public int myAtoi(String s) {
        long result = 0;
        int i = 0;
        int sign = 1;
        while(i<s.length() && s.charAt(i)==' '){
            i++;
        }
        if(i<s.length() && s.charAt(i)=='-'){
            sign = -1;
            i++;
        }else if(i<s.length()&&s.charAt(i)=='+'){
            sign = 1;
            i++;
        }
        while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9')){
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;
            if(sign == 1 && result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(sign == -1 && ((-1*result)<Integer.MIN_VALUE)){
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(result*sign);
    }
}