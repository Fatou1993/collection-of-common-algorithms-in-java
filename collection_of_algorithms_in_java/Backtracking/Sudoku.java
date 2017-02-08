// Implémentation de l'algorithme Sudoku avec Backtracking 
// Complexité en O(n*n) avec n le nombre de colonnes

public class Sudoku {
	public static void printGrid(int[][] sol){
		int n = sol.length;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(j==n-1 && i!=n-1){
					System.out.println(sol[i][j]);
				}else{
					System.out.print(sol[i][j]+" ");
				}
			}
			
		}
	}
	
	public static boolean isFullyFilled(int[][] grid, int[] val){
		int n = grid.length;
		for(int i=0; i<n; ++i){
			for(int j=0; j<n; ++j){
				if(grid[i][j]==0){
					val[0]=i;
					val[1]=j;
					return false;
				}
					
			}
		}
		return true;
	}
	
	public static boolean isSafeColumn(int[][] grid,int col,int i){
		int n = grid.length;
		for(int row=0; row<n; ++row){
			if(grid[row][col]==i)
				return false;
		}
		return true;
	}
	
	public static boolean isSafeRow(int[][] grid,int row,int i){
		int n = grid.length;
		for(int col=0; col<n; ++col){
			if(grid[row][col]==i)
				return false;
		}
		return true;
	}
	
	public static boolean isSafeBox(int[][] grid,int row,int col,int i){
		int starting_row = row - row%3;
		int starting_column = col - col%3;
		for(int k=0; k<3; ++k){
			for(int l=0; l<3; ++l){
				if(grid[k+starting_row][l+starting_column]==i)
					return false;
			}
		}
		return true;
	}
	
	public static boolean isSafe(int[][] grid,int row,int col,int i){
		return isSafeColumn(grid, col, i) && isSafeRow(grid, row, i) && isSafeBox(grid, row, col, i);
	}
	public static boolean SolveSudoku(int[][] grid){
		int[] values ={0,0};
		if(isFullyFilled(grid, values))
			return true;
		int row = values[0];
		int col = values[1];
		
		for(int num=1; num<10; ++num){
			if(isSafe(grid, row, col, num)){
				grid[row][col]=num;
				if(SolveSudoku(grid))
					return true;
				grid[row][col]=0;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		if (SolveSudoku(grid))
		    printGrid(grid);
		else
			System.out.println("Pas de solution");
	}

}
