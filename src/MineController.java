
public class MineController {

	public static boolean processInput(int x, int y, boolean inputFlag, int sideL, CellField[][] currentField) {
		if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {
				currentField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = currentField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
					return true;
				} else if (currentInitState == InitCellState.Free) {
					// Recursive method for uncovering if you select a free square
					sweepAndCheck(x, y, sideL, currentField);
				} else {
					// If you nail a number
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
				}
			}
		} else if ((currentField[x][y].getViewStatus() == ViewStatus.FLAGGED) && inputFlag) {
			currentField[x][y].setViewState(ViewStatus.COVERED);
			// If already flagged, unflag
		}
		// else don't update board
		return false;

	}

	public static boolean processInput(int x, int y, boolean inputFlag, int height, int width,
			CellField[][] currentField) {
		if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {
				currentField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = currentField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
					System.out.println("You hit a mine");
					return true;
				} else if (currentInitState == InitCellState.Free) {
					// Recursive method for uncovering if you select a free square
					sweepAndCheck(x, y, height, width, currentField);
				} else {
					// If you nail a number
					currentField[x][y].setViewState(ViewStatus.UNCOVERED);
				}
			}
		} else if ((currentField[x][y].getViewStatus() == ViewStatus.FLAGGED) && inputFlag) {
			currentField[x][y].setViewState(ViewStatus.COVERED);
			// If already flagged, unflag
		}
		// else don't update board
		return false;

	}

	public static void sweepAndCheck(int x, int y, int sideL, CellField[][] currentField) {
		if ((currentField[x][y].getCellState() == InitCellState.Free)
				&& (currentField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			// Check every damn cell
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

	public static void sweepAndCheck(int x, int y, int height, int width, CellField[][] currentField) {
		if ((currentField[x][y].getCellState() == InitCellState.Free)
				&& (currentField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			// Check every damn cell
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
			sweepAt(y - 1, x - 1, height, width, currentField); // NW
			sweepAt(y - 1, x, height, width, currentField); // N
			sweepAt(y - 1, x + 1, height, width, currentField); // NE
			sweepAt(y, x - 1, height, width, currentField); // W
			sweepAt(y, x + 1, height, width, currentField); // E
			sweepAt(y + 1, x - 1, height, width, currentField); // SW
			sweepAt(y + 1, x, height, width, currentField); // S
			sweepAt(y + 1, x + 1, height, width, currentField); // SE

		} else {
			// Case for numbers/hints
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
		}
	}

	public static void sweepAt(int x, int y, int sideL, CellField[][] mineField) {
		// Check bounds before sweep, check if the square is free to continue sweeping,
		// else uncover the number
		if (y >= 0 && y < sideL && x >= 0 && x < sideL) {
			if (mineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(y, x, sideL, mineField);
			} else {
				mineField[y][x].setViewState(ViewStatus.UNCOVERED);
			}
		}
	}

	public static void sweepAt(int x, int y, int height, int width, CellField[][] mineField) {
		// Check bounds before sweep, check if the square is free to continue sweeping,
		// else uncover the number
		if (y >= 0 && y < height && x >= 0 && x < width) {
			if (mineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(y, x, height, width, mineField);
			} else {
				mineField[y][x].setViewState(ViewStatus.UNCOVERED);
			}
		}
	}
}