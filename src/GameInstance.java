
public class GameInstance {
	CellField[][] gameMineField;
	int remainingSquaresCounter;

	/**
	 * @param width
	 * @param height
	 */
	public GameInstance(int sideLength, int mineCount) {
		gameMineField = InitMinefield.genMineFieldObjects(sideLength, mineCount);
		remainingSquaresCounter = (sideLength * sideLength) - mineCount;
	}
	
	public GameInstance(int width, int height, int mineCount) {
		gameMineField = InitMinefield.genMineFieldObjects(width, height, mineCount);
		remainingSquaresCounter = (width * height) - mineCount;
	}

	public CellField[][] getGameMineField() {
		return gameMineField;
	}

	public void setGameMineField(CellField[][] gameMineField) {
		this.gameMineField = gameMineField;
	}

	// public checkChosenLocation(int width, int height, String )
	public void displayGame() {
		int k = 1;
		// System.out.println("0 1 2 3 4 5 6 7 8 9 10");
		for (int r = 0; r <= gameMineField.length; r++) {

			System.out.print(r + " ");
			if (r == 0) {
				System.out.print(" ");
			}
		}
		System.out.println();
		for (CellField[] row : gameMineField) {
			if (k < 10) {
				System.out.print(k + " ");
			} else {
				System.out.print(k);
			}
			for (int i = 0; i < row.length; i++) {
				System.out.print(" " + row[i].displayCell());

			}
			k++;
			System.out.println();
		}

	}

	public boolean winCondition() {
		int uncoveredPoints = 0;
		for (int i = 0; i < gameMineField.length; i++) {
			for (int j = 0; j < gameMineField[i].length; j++) {
				if (gameMineField[i][j].getViewStatus() == ViewStatus.UNCOVERED) {
					uncoveredPoints++;
				}
			}
		}
		if (uncoveredPoints == remainingSquaresCounter) {
			return true;
		} else {
			return false;
		}

	}

	public void processInput(int x, int y, boolean flag, int sideL) {
		if (gameMineField[x][y].getViewStatus() == ViewStatus.COVERED) {
			if (flag) {
				gameMineField[x][y].setViewState(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = gameMineField[x][y].getCellState();
				if (currentInitState == InitCellState.Mine) {
					// you lose - please add a you lose method
				} else {
					// Recursive method for uncovering
					sweepAndCheck(x, y, sideL);
				}
			}
		} else {
			// Don't update board
		}

	}

	public void sweepAndCheck(int x, int y, int sideL) {
		if (gameMineField[x][y].getCellState() == InitCellState.Free) {
			// Nested/repeated if so we don't run check neighbors for uncovered free cells
			if (gameMineField[x][y].getViewStatus() == ViewStatus.COVERED) {
				sweepNear(x, y, sideL);
			}
		} else {
			// Case for numbers
			gameMineField[x][y].setViewState(ViewStatus.UNCOVERED);
		}
	}

	public void sweepNear(int x, int y, int sideL) {
		// check cells in all directions, increment for each mine found starting
		sweepAt(y - 1, x - 1, sideL); // NW
		sweepAt(y - 1, x, sideL); // N
		sweepAt(y - 1, x + 1, sideL); // NE
		sweepAt(y, x - 1, sideL); // W
		sweepAt(y, x + 1, sideL); // E
		sweepAt(y + 1, x - 1, sideL); // SW
		sweepAt(y + 1, x, sideL); // S
		sweepAt(y + 1, x + 1, sideL); // SE

	}

	public void sweepAt(int x, int y, int sideL) {
		// we need to check also that we're not out of array bounds as that would
		// be an error
		if (y >= 0 && y < sideL && x >= 0 && x < sideL && (gameMineField[x][y].getViewStatus() == ViewStatus.COVERED)) {
			gameMineField[x][y].setViewState(ViewStatus.UNCOVERED);
			if (gameMineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(x, y, sideL);
			}
		}
	}
}
