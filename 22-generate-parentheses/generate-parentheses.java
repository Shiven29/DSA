class Solution {

    private void backtrack(String current, int open , int close , List<String> result, int n){
        if(open==n && close == n){
            result.add(current);
            return;
        }
        if(open<n){
            backtrack(current+"(",open+1,close,result,n);
        }
        if(close<open){
            backtrack(current+")",open,close+1,result,n);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String current = "";
        backtrack(current,0,0,result,n);
        return result;
    }
}