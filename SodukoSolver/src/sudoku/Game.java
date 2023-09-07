package sudoku;

public class Game {

	public static void main(String[] args) {
		int[][] matrix = {
				  {0, 0, 4, 0, 5, 0, 0, 0, 0},
				  {9, 0, 0, 7, 3, 4, 6, 0, 0},
				  {0, 0, 3, 0, 2, 1, 0, 4, 9},
				  {0, 3, 5, 0, 9, 0, 4, 8, 0},
				  {0, 9, 0, 0, 0, 0, 0, 3, 0},
				  {0, 7, 6, 0, 1, 0, 9, 2, 0},
				  {3, 1, 0, 9, 7, 0, 2, 0, 3},
				  {0, 0, 9, 1, 8, 2, 0, 0, 3},
				  {0, 0, 0, 0, 6, 0, 1, 0, 0}};
		SudokuSolver sod = new Sudoku();
		sod.setGrid(matrix);
		//UserInterface f = new UserInterface();
		sod.solve();
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				System.out.print(sod.getGrid()[i][j]);
			}
			System.out.println();
		}
	}

}
