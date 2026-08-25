class Solution {
    private int value(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
        }
        return 0;
    }
    public int romanToInt(String s) {
        int n = 0;
        for(int i=0; i<s.length()-1; i++){
            int current = value(s.charAt(i));
            int next = value(s.charAt(i+1));
            if(current<next){
                n -= current;
            }else n+= current;
        }
        n += value(s.charAt(s.length()-1));
        return n;
    }
}