class IslandPerimeter{
    public static int islandPerimeter(int[][] grid){
        int perimeter = 0 ;
        int rows = grid.length;
        int col = grid[0].length;

        for(int i = 0 ; i < rows ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j]==1){
                    perimeter += 4;
                    if( i > 0 && grid[i-1][j] == 1 ){
                        perimeter --;
                    } if (i < rows-1 && grid[i+1][j] == 1){
                        perimeter--;
                    } if ( j > 0 && grid[i][j-1] == 1){
                        perimeter--;
                    } if(j < col-1 && grid[i][j+1] == 1){
                        perimeter--;
                    }
                }
            }
        }        
        System.out.println(perimeter);
        return perimeter;
    }
    public static void main(String[] args) {
        int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        islandPerimeter(grid);
    }
}