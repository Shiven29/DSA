class Solution {

    Boolean[][] memo;

    private boolean match(String s, String p , int i , int j){
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if(j == p.length()){
            memo[i][j] = i == s.length();
            return memo[i][j];
        }
        boolean firstMatch = i<s.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j) == '.');

        if(j+1<p.length() && p.charAt(j+1) == '*'){
            boolean answer = match(s,p,i,j+2) || (firstMatch && match(s,p,i+1,j));
            memo[i][j] = answer;
            return answer;
        }

        boolean answer =  firstMatch && match(s,p,i+1,j+1);
        memo[i][j] = answer;
        return answer;
    }

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return match(s,p,0,0);
    }
}