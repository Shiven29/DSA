class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[][] isZero = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    isZero[i][j] = true;
                }else{
                    isZero[i][j] = false;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(isZero[i][j] == true){
                    for(int k=0; k<matrix[0].length; k++){
                        matrix[i][k] = 0;
                    }
                    for(int l = 0; l<matrix.length; l++){
                        matrix[l][j] = 0;
                    }
                }
            }
        }
    }
}