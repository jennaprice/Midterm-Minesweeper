
public class MineController {
	CellField[][] gameMineField;
	int mines;
	int area;

	public MineController() {

	}

	public MineController(int width, int height, int mineCount) {
		gameMineField = InitMinefield.genMineFieldObjects(width, height, mineCount);
		mines = mineCount;
		area = width * height;
	}

	public MineController(int sideLength, int mineCount) {
		gameMineField = InitMinefield.genMineFieldObjects(sideLength, mineCount);
		area = sideLength * sideLength;
	}

	public int getHeight() {
		return gameMineField.length;
	}

	public int getWidth() {
		return gameMineField[0].length;
	}

	public boolean processInput(int row, int column, boolean inputFlag, int sideL) {
		if (gameMineField[row][column].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {// if we have chosen he flagging option
				gameMineField[row][column].setViewStatus(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = gameMineField[row][column].getCellState();
				if (currentInitState == InitCellState.Mine) {
					gameMineField[row][column].setViewStatus(ViewStatus.UNCOVERED);
					return true;
				} else if (currentInitState == InitCellState.Free) {
					// Recursive method for uncovering if you select a free square
					sweepAndCheck(row, column, sideL);
				} else {
					// If you nail a number
					gameMineField[row][column].setViewStatus(ViewStatus.UNCOVERED);
				}
			}
		} else if ((gameMineField[row][column].getViewStatus() == ViewStatus.FLAGGED) && inputFlag) {

			gameMineField[row][column].setViewStatus(ViewStatus.COVERED);
			System.out.println("True and unflag row " + row + " column " + column);
			System.out.println(" state is " + gameMineField[row][column].getViewStatus());

			// If already flagged, unflag - we need to redraw
		}
		// else don't update board
		return false;

	}

	public boolean processInput(int y, int x, boolean inputFlag, int height, int width) {
		if (gameMineField[y][x].getViewStatus() == ViewStatus.COVERED) {
			if (inputFlag) {
				gameMineField[y][x].setViewStatus(ViewStatus.FLAGGED);
			} else {
				InitCellState currentInitState = gameMineField[y][x].getCellState();
				if (currentInitState == InitCellState.Mine) {
					gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
					System.out.println("You hit a mine");
					return true;
				} else if (currentInitState == InitCellState.Free) {
					// Recursive method for uncovering if you select a free square
					sweepAndCheck(y, x, height, width);
				} else {
					// If you nail a number
					gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
				}
			}
		} else if ((gameMineField[y][x].getViewStatus() == ViewStatus.FLAGGED) && inputFlag) {
			gameMineField[y][x].setViewStatus(ViewStatus.COVERED);
			// If already flagged, unflag
		}
		// else don't update board
		return false;

	}

	public void sweepAndCheck(int y, int x, int sideL) {
		if ((gameMineField[y][x].getCellState() == InitCellState.Free)
				&& (gameMineField[y][x].getViewStatus() == ViewStatus.COVERED)) {
			// Check every damn cell
			gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
			sweepAt(y - 1, x - 1, sideL); // NW
			sweepAt(y - 1, x, sideL); // N
			sweepAt(y - 1, x + 1, sideL); // NE
			sweepAt(y, x - 1, sideL); // W
			sweepAt(y, x + 1, sideL); // E
			sweepAt(y + 1, x - 1, sideL); // SW
			sweepAt(y + 1, x, sideL); // S
			sweepAt(y + 1, x + 1, sideL); // SE

		} else {
			// Case for numbers/hints
			gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
		}
	}

	public void sweepAndCheck(int y, int x, int height, int width) {
		if ((gameMineField[y][x].getCellState() == InitCellState.Free)
				&& (gameMineField[y][x].getViewStatus() == ViewStatus.COVERED)) {
			// Check every damn cell
			gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
			sweepAt(y - 1, x - 1, height, width); // NW
			sweepAt(y - 1, x, height, width); // N
			sweepAt(y - 1, x + 1, height, width); // NE
			sweepAt(y, x - 1, height, width); // W
			sweepAt(y, x + 1, height, width); // E
			sweepAt(y + 1, x - 1, height, width); // SW
			sweepAt(y + 1, x, height, width); // S
			sweepAt(y + 1, x + 1, height, width); // SE

		} else {
			// Case for numbers/hints
			gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
		}
	}

	public void sweepAt(int x, int y, int sideL) {
		// Check bounds before sweep, check if the square is free to continue sweeping,
		// else uncover the number
		if (y >= 0 && y < sideL && x >= 0 && x < sideL) {
			if (gameMineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(y, x, sideL);
			} else {
				gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
			}
		}
	}

	public void sweepAt(int x, int y, int height, int width) {
		// Check bounds before sweep, check if the square is free to continue sweeping,
		// else uncover the number
		if (y >= 0 && y < height && x >= 0 && x < width) {
			if (gameMineField[y][x].getCellState() == InitCellState.Free) {
				sweepAndCheck(y, x, height, width);
			} else {
				gameMineField[y][x].setViewStatus(ViewStatus.UNCOVERED);
			}
		}
	}

	public CellField[][] getGameMineField() {
		return gameMineField;
	}

	public void setGameMineField(CellField[][] gameMineField) {
		this.gameMineField = gameMineField;
	}

	public void displayGame() {

		int k = 1;
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
				System.out.print(" " + row[i].displayCellText());
			}
			k++;
			System.out.println();
		}
	}

	public void removeCovers() {
		for (int i = 0; i < gameMineField.length; i++) {
			for (int j = 0; j < gameMineField[i].length; j++) {
				gameMineField[i][j].setViewStatus(ViewStatus.UNCOVERED);
			}
		}
	}

}