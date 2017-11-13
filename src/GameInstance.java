
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
		for (int r = 0; r <= gameMineField.length; r++) {
			System.out.print(r + " ");
			if (r == 0) {
				System.out.print(" ");
			}
			System.out.println();
		}
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

	public void removeCovers() {
		for (int i = 0; i < gameMineField.length; i++) {
			for (int j = 0; j < gameMineField[i].length; j++) {
				gameMineField[i][j].setViewState(ViewStatus.UNCOVERED);
			}
		}
	}
}
