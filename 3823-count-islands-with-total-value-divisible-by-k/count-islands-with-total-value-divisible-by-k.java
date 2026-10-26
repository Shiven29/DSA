class Solution {
    private long dfs(int[][] grid , int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == 0){
            return 0;
        }
        long sum = grid[r][c];
        grid[r][c] = 0;
        sum += dfs(grid,r-1,c);
        sum += dfs(grid,r+1,c);
        sum += dfs(grid,r,c-1);
        sum += dfs(grid,r,c+1);
        return sum;
    }

    public int countIslands(int[][] grid, int k) {
       int count = 0;
        for(int i=0; i<grid.length; i++){
        for(int j=0; j<grid[0].length; j++){
            if(grid[i][j] > 0){
                long sum = dfs(grid,i,j);
                if(sum%k==0){
                    count++;
                    }
                }
            }
        }
    return count; 
    }  
}