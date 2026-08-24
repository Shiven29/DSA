class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        boolean goingdown = false;

        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;

        for(int i = 0; i<s.length(); i++){
            rows[currentRow].append(s.charAt(i));
            if(currentRow == 0 || currentRow == numRows-1){
                goingdown = !goingdown;
            }

            currentRow += goingdown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for(int i= 0;i<numRows; i++){
            result.append(rows[i]);
        }
        return result.toString();
    }
}