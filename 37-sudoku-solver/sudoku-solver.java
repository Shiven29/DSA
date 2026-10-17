class Solution {
    private boolean isValid(char[][] board, int row, int col, char digit){
        for(int k = 0; k<9;k++){
            if(board[row][k] == digit) return false;
            if(board[k][col] == digit) return false;
        }
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;

        for(int i = 0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[startRow+i][startCol+j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean solve(char[][] board){
        for(int i=0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char digit = '1'; digit<='9';digit++){
                        if(isValid(board,i,j,digit)){
                            board[i][j] = digit;
                            if(solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        if(solve(board)){
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    System.out.print(board[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}