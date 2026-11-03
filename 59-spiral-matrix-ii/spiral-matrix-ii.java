class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int count = 1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                matrix[i][j] = count;
                count++;
            }
        }
        int[][] result = new int[n][n];
        int left = 0; int right =n-1;
        int top = 0; int bottom = n-1;
        count = 0;

        while(left<=right && top<=bottom){
            for(int i=left; i<=right; ++i){
                int row = count/n;
                int col = count%n;
                result[top][i] = matrix[row][col];
                count++;
            }top++;
            for(int i=top; i<=bottom; ++i){
                int row = count/n;
                int col = count%n;
                result[i][right] = matrix[row][col];
                count++;
            }right--;
            if(left<=right){
                for(int i = right; i>=left; --i){
                    int row = count/n;
                    int col = count%n;
                    result[bottom][i] = matrix[row][col];
                    count++;
                }bottom--;
            }
            if(top<=bottom){
                for(int i=bottom; i>=top; --i){
                    int row = count/n;
                    int col = count%n;
                    result[i][left] = matrix[row][col];
                    count++;
                }left++;
            }
        }
        return result; 
    }
}