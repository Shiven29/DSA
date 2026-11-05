class Solution {
    public String simplifyPath(String path) {
        String[] pats = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i<pats.length; i++){
            if(pats[i].equals(""))
                continue;
            else if(pats[i].equals("."))
                continue;
            else if(pats[i].equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(pats[i]);
            }
        }
        String result = "/" + String.join("/",stack);
        return result;
    }
}