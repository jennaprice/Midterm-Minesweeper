
public class MineController {
	
	public static boolean processInput(int x, int y, boolean inputFlag, int sideL, CellField[][] currentField) {
		if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {
				currentField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = currentField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
					System.out.println("You hit a mine");
					return true;
				} else if (currentInitState == InitCellState.Free){
					//Recursive method for uncovering if you select a free square
					sweepAndCheck(x, y, sideL, currentField);
				} else {
					//If you nail a number
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
				}
			}
		} else if ((currentField[x][y].getViewStatus() == ViewStatus.FLAGGED) && inputFlag){
			currentField[x][y].setViewState(ViewStatus.COVERED);
			
			// Don't update board
		}
		return false;

	}

	public static void sweepAndCheck(int x, int y, int sideL, CellField[][] currentField) {
		if ((currentField[x][y].getCellState() == InitCellState.Free) && (currentField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			//Check every damn 
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
			sweepAt(y - 1, x - 1, sideL, currentField); // NW
			sweepAt(y - 1, x, sideL, currentField); // N
			sweepAt(y - 1, x + 1, sideL, currentField); // NE
			sweepAt(y, x - 1, sideL, currentField); // W
			sweepAt(y, x + 1, sideL, currentField); // E
			sweepAt(y + 1, x - 1, sideL, currentField); // SW
			sweepAt(y + 1, x, sideL, currentField); // S
			sweepAt(y + 1, x + 1, sideL, currentField); // SE

		} else {
			// Case for numbers/hints
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
		}
	}

	/*public static void sweepNear(int x, int y, int sideL, CellField[][] mineField) {
		// check cells in all directions, increment for each mine found starting
		sweepAt(y - 1, x - 1, sideL, mineField); // NW
		sweepAt(y - 1, x, sideL, mineField); // N
		sweepAt(y - 1, x + 1, sideL, mineField); // NE
		sweepAt(y, x - 1, sideL, mineField); // W
		sweepAt(y, x + 1, sideL, mineField); // E
		sweepAt(y + 1, x - 1, sideL, mineField); // SW
		sweepAt(y + 1, x, sideL, mineField); // S
		sweepAt(y + 1, x + 1, sideL, mineField); // SE

	}*/

	public static void sweepAt(int x, int y, int sideL, CellField[][] mineField) {
		// Check bounds before sweep, check if the square is free to continue sweeping, else uncover the number
		if (y >= 0 && y < sideL && x >= 0 && x < sideL) {
			if (mineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(y, x, sideL, mineField);
			} else {
				mineField[y][x].setViewState(ViewStatus.UNCOVERED);
			}
		}
	}
	/*public static boolean processInput(int x, int y, boolean inputFlag, int sideL, CellField[][] currentField) {
		if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {
				currentField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = currentField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					return true;
				} else {
					// Recursive method for uncovering
					sweepAndCheck(x, y, sideL, currentField);
					return false;
				}
			}
		} else {
			//Also extend this for unflag function
			// Don't update board
			return false;
		}
		return false;

	}

	public static void sweepAndCheck(int x, int y, int sideL, CellField[][] currentField) {
		
		if (currentField[x][y].getCellState() == InitCellState.Free) {
			// Nested/repeated if so we don't run check neighbors for uncovered free cells
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
			sweepAt(y - 1, x - 1, sideL, currentField); // NW
			sweepAt(y - 1, x, sideL, currentField); // N
			sweepAt(y - 1, x + 1, sideL, currentField); // NE
			sweepAt(y, x - 1, sideL, currentField); // W
			sweepAt(y, x + 1, sideL, currentField); // E
			sweepAt(y + 1, x - 1, sideL, currentField); // SW
			sweepAt(y + 1, x, sideL, currentField); // S
			sweepAt(y + 1, x + 1, sideL, currentField); // SE
		} 
		
	}

	public static void sweepNear(int x, int y, int sideL, CellField[][] mineField) {
		// check cells in all directions, increment for each mine found starting
		mineField[x][y].setViewState(ViewStatus.UNCOVERED);
		sweepAt(y - 1, x - 1, sideL, mineField); // NW
		sweepAt(y - 1, x, sideL, mineField); // N
		sweepAt(y - 1, x + 1, sideL, mineField); // NE
		sweepAt(y, x - 1, sideL, mineField); // W
		sweepAt(y, x + 1, sideL, mineField); // E
		sweepAt(y + 1, x - 1, sideL, mineField); // SW
		sweepAt(y + 1, x, sideL, mineField); // S
		sweepAt(y + 1, x + 1, sideL, mineField); // SE

	}

	public static void sweepAt(int x, int y, int sideL, CellField[][] currentField) {
		// we need to check also that we're not out of array bounds as that would
		// be an error
		if (y >= 0 && y < sideL && x >= 0 && x < sideL && (currentField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
			if (currentField[x][y].getCellState() == InitCellState.Free) {
				sweepAndCheck(x, y, sideL, currentField);
			}
		}
	} */
}
