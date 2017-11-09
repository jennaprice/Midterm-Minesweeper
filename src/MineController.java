
public class MineController {

	public static void processInput(int x, int y, boolean flag, int sideL, CellField[][] currentField) {
		if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (flag) {
				currentField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = currentField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					// you lose - please add a you lose method
				} else {
					//Recursive method for uncovering
					sweepAndCheck(x, y, sideL, currentField);
				}
			}
		} else {
			// Don't update board
		}

	}

	public static void sweepAndCheck(int x, int y, int sideL, CellField[][] currentField) {
		if (currentField[x][y].getCellState() == InitCellState.Free) {
			// Nested/repeated if so we don't run check neighbors for uncovered free cells
			if (currentField[x][y].getViewStatus() == ViewStatus.COVERED) {
				sweepNear(x, y, sideL, currentField);
			}
		} else {
			// Case for numbers
			currentField[x][y].setViewState(ViewStatus.UNCOVERED);
		}
	}

	public static void sweepNear(int x, int y, int sideL, CellField[][] mineField) {
		// check cells in all directions, increment for each mine found starting
		sweepAt(y - 1, x - 1, sideL, mineField); // NW
		sweepAt(y - 1, x, sideL, mineField); // N
		sweepAt(y - 1, x + 1, sideL, mineField); // NE
		sweepAt(y, x - 1, sideL, mineField); // W
		sweepAt(y, x + 1, sideL, mineField); // E
		sweepAt(y + 1, x - 1, sideL, mineField); // SW
		sweepAt(y + 1, x, sideL, mineField); // S
		sweepAt(y + 1, x + 1, sideL, mineField); // SE

	}

	public static void sweepAt(int x, int y, int sideL, CellField[][] mineField) {
		// we need to check also that we're not out of array bounds as that would
		// be an error
		if (y >= 0 && y < sideL && x >= 0 && x < sideL && (mineField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			mineField[x][y].setViewState(ViewStatus.UNCOVERED);
			if (mineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(x, y, sideL, mineField);
			}
		}
	}
}
