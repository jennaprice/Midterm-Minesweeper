public class MineDisplay {
	static int inputSideHeight;
	static int inputSideWidth;
	static int numMines;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// user choosing size of mine
		GameInstance runningGame = new GameInstance(determineSizeAndDifficulty());
		runningGame.playGame();
	}

	public static MineController determineSizeAndDifficulty() {
		int numMines = 0;
		int inputSideHeight;
		int inputSideWidth;
		MineController gameMineField = new MineController();
		String mineFieldSize = Validator.getStringSize("Please enter the size (small, medium, large, custom): ");
		String mineFieldDiff = Validator
				.getStringDifficulty("Please enter the difficulty (easy, medium, hard, custom):");
		if (mineFieldSize.equals("small")) {
			inputSideHeight = 10;
			inputSideWidth = 10;
			if (mineFieldDiff.equals("easy")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (10.0 / 100.0));
			} else if (mineFieldDiff.equals("medium")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (25.0 / 100.0));
			} else if (mineFieldDiff.equals("Hard")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (40.0 / 100.0));
			} else if (mineFieldDiff.equals("Custom")) {
				numMines = Validator.getInt("How many mines do you want to test yourself against?", 1, 99);

			}
			gameMineField = new MineController(inputSideHeight, numMines);
		} else if (mineFieldSize.equals("medium")) {
			inputSideHeight = 50;
			inputSideWidth = 50;
			if (mineFieldDiff.equals("easy")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (10.0 / 100.0));
			} else if (mineFieldDiff.equals("medium")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (25.0 / 100.0));
			} else if (mineFieldDiff.equals("Hard")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (40.0 / 100.0));
			} else if (mineFieldDiff.equals("Custom")) {
				numMines = Validator.getInt("How many mines do you want to test yourself against?", 1, 199);
			}
			gameMineField = new MineController(inputSideHeight, numMines);
		} else if (mineFieldSize.equals("large")) {
			inputSideHeight = 100;
			inputSideWidth = 100;
			if (mineFieldDiff.equals("easy")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (10.0 / 100.0));
			} else if (mineFieldDiff.equals("medium")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (25.0 / 100.0));
			} else if (mineFieldDiff.equals("Hard")) {
				numMines = (int) ((double) ((inputSideHeight * inputSideWidth)) * (40.0 / 100.0));
			} else if (mineFieldDiff.equals("Custom")) {
				numMines = Validator.getInt("How many mines do you want to test yourself against?", 1, 999);
			}
			gameMineField = new MineController(inputSideHeight, numMines);
		} else if (mineFieldSize.equals("custom")) {
			inputSideHeight = Validator.getInt("Enter the height you want your custom Minefield: ");
			inputSideWidth = Validator.getInt("Enter the width you want your custom Minefield: ");
			numMines = Validator.getInt("How many mines would you like for your custom Minefield? ", 1,
					((inputSideHeight * inputSideWidth) - 1));
			gameMineField = new MineController(inputSideHeight, inputSideWidth, numMines);
		}
		return gameMineField;
	}

}
