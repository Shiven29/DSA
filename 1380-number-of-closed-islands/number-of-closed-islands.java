class Solution {
    private void dfs(int[][] grid, int r, int c){
        if(r<0 || r>=grid.length ||c<0 || c>=grid[0].length || grid[r][c] == 1){
            return;
        }
        grid[r][c] = 1;
        dfs(grid , r-1,c);
        dfs(grid , r+1,c);
        dfs(grid , r , c-1);
        dfs(grid , r , c+1);
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        //Process boundary land here;
        for(int j =0; j<grid[0].length; j++){
            dfs(grid,0,j);
            dfs(grid, grid.length-1,j);
        }

        for(int i=0; i<grid.length; i++){
            dfs(grid, i, 0);
            dfs(grid,i,grid[0].length-1);
        }

        //Count remaining islands here;
        for(int i= 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}