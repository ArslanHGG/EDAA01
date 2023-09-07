package sudoku;

public class Sudoku implements SudokuSolver{
	private int [][] grid = new int [9][9];
	
	public Sudoku () {
	}
	@Override
	public boolean solve() {
		if(!isAllValid()) {
			return false;
		}
		return solve(0, 0);
	}
	private boolean solve(int r, int c) {

		if(r == 9) {
			System.out.println("Löst!");
			return true;
		}
		else if(c == 9) {
			return solve(r+1, 0);
		}
		
		if (!isEmpty(r,c)) {
			return solve(r, c+1);
		}
		
		for(int i = 1; i < 10; i++) {
			grid[r][c] = i;
			if(isValid(r, c)) {
				grid[r][c] = i;
				if (solve(r, c+1)) {
					return true;
				}
				grid[r][c] = 0;
			}
			
		}
	
		//System.out.println("Dead end i ruta: " + r + ", " + c);

		
		return false;
	}

	@Override
	public void set(int row, int col, int digit) {
		if(row < 9 && row >= 0 && col < 9 && col >= 0 && digit <= 9 && digit >= 1) {
			grid[row][col] = digit;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public int get(int row, int col) {
		if(col > 8 || col < 0 || row > 9 || row < 0) {
				throw new IllegalArgumentException();
				}
		else{
			return grid[row][col];
			}
		}

	@Override
	public void clear(int row, int col) {
		grid[row][col] = 0;
		
	}

	@Override
	public void clearAll() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				grid[i][j] = 0;
			}
		}
		
	}

	@Override
	public boolean isValid(int row, int col) {
		int num = get(row,col);
		return correctRow(row, num) && correctSquare(row, col, num) && correctCol(num, col);
	}

	@Override
	public boolean isAllValid() {
		
		return true;
	}

	@Override
	public void setGrid(int[][] m) {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++ ) {
				if(m[i][j]) {
					throw new IllegalArgumentException();
				}
				}
			}
		if(m.length > 9 || m[0].length > 9) {
			throw new IllegalArgumentException();
		}
		
		grid = m;
		
	}

	@Override
	public int[][] getGrid() {
		return grid;
	}
	private boolean isEmpty(int row, int col) {
		if(get(row, col) != 0) {
			return false;
		}
		return true;
	}
	private boolean correctSquare(int row, int col, int num) {
		int boxRow = row -row % 3;
		int boxCol = col - col % 3;
		
		for(int i = boxRow; i < boxRow + 3; i++) {
			for(int j = boxCol; j < boxCol + 3; j++) {
				if(get(i, j) == num) {
					return false;
				}
			}
			
		}
		return true;
	}
	private boolean correctRow(int num, int row) {
		for(int i = 0; i < 9; i++) {
			if(get(row,i) == num) {
				return false;
			}
		}
		return true;
	}
	public boolean correctCol(int num, int col) {
		for(int i = 0; i < 9; i++) {
			if(get(i, col) == num) {
				return false;
			}
		}
		return true;
	}
}
