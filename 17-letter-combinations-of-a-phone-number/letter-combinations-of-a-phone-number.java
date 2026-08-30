class Solution {
    private String alphabet(char ch){
        switch(ch){
            case '2':return "abc";
            case '3':return "def";
            case '4':return "ghi";
            case '5':return "jkl";
            case '6':return "mno";
            case '7':return "pqrs";
            case '8':return "tuv";
            case '9':return "wxyz";
        }
        return "";
    }

    private void backtrack(String digits, int index , StringBuilder current, List<String> result){
        if(index == digits.length()){
            result.add(current.toString());
            return;
        }
        String letters = alphabet(digits.charAt(index));
        for(int i=0; i<letters.length(); i++){
            current.append(letters.charAt(i));
            backtrack(digits, index+1, current, result);
            current.deleteCharAt(current.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        backtrack(digits , 0 , new StringBuilder(), result);
        return result;
    }
}