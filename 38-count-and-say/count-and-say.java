class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for(int j = 1; j<n; j++){
            StringBuilder next = new StringBuilder();
            int i =0;
            while(i<s.length()){
                char digit = s.charAt(i);
                int count = 0;

                while(i<s.length() && s.charAt(i) == digit){
                    count++;
                    i++;
                }
                next.append(count);
                next.append(digit);
            }
            s = next.toString();
        }
        return s;
    }
}