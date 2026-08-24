class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        int direction = 0;

        for(int i=0; i<numRows; i++){
            rows[i] = new StringBuilder();
        }
        int currentRow = 0;

        for(int i = 0; i<s.length(); i++){
            rows[currentRow].append(s.charAt(i));
            if(currentRow == numRows-1) direction = 1;
            if(currentRow == 0) direction = 0;

            if(direction == 1) currentRow--;
            if(direction == 0) currentRow++;
        }
        StringBuilder result = new StringBuilder();
        for(int i= 0;i<numRows; i++){
            result.append(rows[i]);
        }
        return result.toString();
    }
}