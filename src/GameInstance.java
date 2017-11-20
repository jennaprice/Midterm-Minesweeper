public class GameInstance {
	// CellField[][] gameMineField;
	MineController gameMineField;
	int remainingSquaresCounter;

	/**
	 * @param width
	 * @param height
	 */
	public GameInstance(MineController gameMineField) {
		this.gameMineField = gameMineField;
		remainingSquaresCounter = gameMineField.area - gameMineField.mines;
	}

	public MineController getGameMineField() {
		return gameMineField;
	}

	public void setGameMineField(MineController gameMineField) {
		this.gameMineField = gameMineField;
	}

	public boolean winCondition() {
		CellField[][] gameField = gameMineField.getGameMineField();
		int uncoveredPoints = 0;
		for (int i = 0; i < gameField.length; i++) {
			for (int j = 0; j < gameField[i].length; j++) {
				if (gameField[i][j].getViewStatus() == ViewStatus.UNCOVERED) {
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

	public void playGame() {
		boolean loseCondition = false;
		gameMineField.displayGame();
		while (!loseCondition && !(winCondition())) {
			// while()
			int yInput = Validator.getInt("Enter horizontal index of cell you want to flag or check: ", 1,
					gameMineField.getWidth());
			int xInput = Validator.getInt("Enter vertical index of cell you want to flag or check: ", 1,
					gameMineField.getHeight());
			boolean trueFlag = getFlagOrUncover();
			loseCondition = gameMineField.processInput(yInput - 1, xInput - 1, trueFlag, gameMineField.getWidth());
			gameMineField.displayGame();
			System.out.println();
		}
		Validator.closeScanner();
	}

	public static boolean getFlagOrUncover() {
		String[] validOptions = new String[] { "u", "f" };
		String inputString = Validator
				.getSpecificString("Enter F for marking the cell with a flag or U for uncovering cell. ", validOptions);

		if (inputString.equalsIgnoreCase("F")) {
			return true;
		} else {
			return false;
		}
	}
}
