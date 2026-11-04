class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while(i>=0 || j>=0 || carry!=0){
            int sum = carry;

            if(i>=0){
                int digit = a.charAt(i) - '0';
                sum += digit;
                i--;
            }
            if(j>=0){
                int digit = b.charAt(j) - '0';
                sum+=digit;
                j--;
            }
            result.append(sum%2);
            carry = sum/2;
        }
        return result.reverse().toString();
    }
}