package sudoku;


public class Soduko implements SodukoSolver{
	private int [][] sod;
	public Soduko(int [][] board) {
		this.sod = board;
	}
	@Override
	public void add(int row, int col, int num) {
		if(row < 9 && row >= 0 && col < 9 && col >= 0 && num <= 9 && num >= 1) {
			sod[row][col] = num;
		}
		else {
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public boolean solve() {
		if(solve(0,0)) {
			//print lösning
			return true;
		}
		//print ej lösning
		return false;
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
			
			if(isValid(r, c, i)) {
				sod[r][c] = i;
				if (solve(r, c+1)) {
					return true;
				}
				sod[r][c] = 0;
			}
			
		}
	
		//System.out.println("Dead end i ruta: " + r + ", " + c);

		
		return false;
	}

	@Override
	public void remove(int row, int col) {
		if(row < 9 && row >= 0 && col < 9 && col >= 0 && sod[row][col] != 0) {
			sod[row][col] = 0;
		}
		else {
			throw new IllegalArgumentException("Try Again!");
		}
		
	}

	@Override
	public void clear() {
		for(int i = 0; i < sod.length; i++) {
			for(int w = 0; w < sod[i].length; w++) {
				sod[i][w] = 0;
			}
		}
		
	}


	@Override
	public boolean isEmpty(int row, int col) {
		if(sod[row][col] != 0) {
			return false;
		}
		return true;
	}

	@Override
	public int getNum(int row, int col) {
		return sod[row][col];
	}
	@Override
	public boolean correctCol(int num, int col) {
		for(int i = 0; i < 9; i++) {
			if(sod[i][col] == num) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean correctRow(int num, int row) {
		for(int i = 0; i < 9; i++) {
			if(sod[row][i] == num) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean isValid(int r, int c, int num) {
		return correctRow(num, r) && correctSquare(r, c, num) && correctCol(num, c);
	}
	@Override
	public boolean correctSquare(int row, int col, int num) {
		int boxRow = row -row % 3;
		int boxCol = col - col % 3;
		
		for(int i = boxRow; i < boxRow + 3; i++) {
			for(int j = boxCol; j < boxCol + 3; j++) {
				if(sod[i][j] == num) {
					return false;
				}
			}
			
		}
		return true;
	}
	@Override
	public int[][] matrix() {
		int [][] matrix = this.sod;
		return matrix;
	}
}
