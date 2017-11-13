import java.util.ArrayList;
import java.util.Scanner;

public class MineDisplay {
	static int inputSideHeight;
	static int inputSideWidth;
	static int numMines;

	public static void determineSizeAndDifficulty(String mineFieldSize, String mineFieldDiff) {

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
		} else if (mineFieldSize.equals("custom")) {
			inputSideHeight = Validator.getInt("Enter the height you want your custom Minefield: ");
			inputSideWidth = Validator.getInt("Enter the width you want your custom Minefield: ");
			numMines = Validator.getInt("How many mines would you like for your custom Minefield? ", 1,
					((inputSideHeight * inputSideWidth) - 1));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// user choosing size of mine

		determineSizeAndDifficulty(
				Validator.getStringSize("Please enter the size (Small, Medium, Large, Custom) of the Mine Field: "),
				Validator.getStringDifficulty(
						"Please enter the difficulty (# of mines: Easy, Medium, Hard, Custom) of your MineField? "));

		// int inputSideLength = Validator.getInt("How big would you want the side
		// length of the Minefield? ");
		// int inputSideHeight = Validator.getInt("How heigh would you want your
		// Minefield? ");
		// int inputSideWidth = Validator.getInt("How wide would you want your
		// Minefield? ");
		// int inputNumMines = Validator.getInt("How many mines do you want to test
		// yourself against?", 1,
		// (inputSideLength * inputSideLength));
		// String sizeOfMineField= Validator.getStringSize("Please enter the size
		// (Small, Medium, Large, Custom) of the Mine Field: ");
		// String difficultyOfMineField = Validator.getStringDifficulty("Please enter
		// the difficulty (# of mines: Easy, Medium, Hard, Custom) of your MineField?
		// ");

		// int minWidth = scn.nextInt();
		// System.out.println("How many cells height would you like your mine?");
		// int minHeight = scn.nextInt();

		// original display
		// makeOuterDisplayWidth(minWidth, 0);
		// makeDisplay(minHeight, minWidth, ch);

		// user chooses a cell and if they want to flag it
		// System.out.println("Choose your cell in index format and if you want to flag
		// that index:");
		// 2,5 6,7
		GameInstance runningGame = new GameInstance(inputSideHeight, numMines);
		runningGame.displayGame();

		boolean loseCondition = false;
		while (!loseCondition && !(runningGame.winCondition())) {
			// while()
			int xInput = Validator.getInt("Enter horizontal index of cell you want to flag or check: ", 1,
					inputSideWidth);
			int yInput = Validator.getInt("Enter vertical index of cell you want to flag or check: ", 1,
					inputSideHeight);
			boolean trueFlag = getFlagOrUncover(scn);
			loseCondition = MineController.processInput(yInput - 1, xInput - 1, trueFlag, inputSideWidth,
					runningGame.getGameMineField());
			runningGame.displayGame();
			System.out.println();
		}

		scn.close();
		Validator.closeScanner();
	}

	public static boolean getFlagOrUncover(Scanner sc) {
		System.out.print("Enter F/f for marking the cell with a flag or U/u for uncovering cell. ");
		ArrayList<String> validOptions = new ArrayList<>();
		validOptions.add("f");
		validOptions.add("u");
		validOptions.add("F");
		validOptions.add("U");
		String inputString = sc.next(); // read user entry
		while (!validOptions.contains(inputString)) {
			System.out.println("Please enter one of the following options: " + validOptions.toString());
			inputString = sc.next();
		}
		sc.nextLine(); // discard any other data entered on the line
		if (inputString.equalsIgnoreCase("F")) {
			// System.out.println("true");
			return true;
		} else {
			// System.out.println("false");
			return false;
		}
	}

	/**
	 * method for box display
	 * 
	 * @param makeHeight
	 *            - int number of boxes going down
	 * @param makeWidth
	 *            - int number of boxes going right
	 * @param makeCh
	 *            - the unicode u+2610 assignment through parameter
	 */
	public static void makeDisplay(int makeHeight, int makeWidth, char makeCh) {
		for (int i = 0; i < makeWidth; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < makeHeight; j++) {
				System.out.print(" " + makeCh);
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * Needed to line the numbers on the left side of boxes
	 * 
	 * @param makeWidth
	 *            - in order to place a number in front of each line of width
	 * @param i
	 *            - is to increment on down the left of the boxes
	 */
	public static void makeOuterDisplayWidth(int makeWidth, int i) {
		// int counter;
		for (i = 0; i < makeWidth; i++) {
			// counter = i;
			System.out.print(" " + " " + (i + 1));
		}
		System.out.println();
	}

	// for (int i = 0; i < minWidth; i++) {
	// for (int j = 0; j< minHeight; j++) {
	// System.out.print("" + ch);
	// }
	// System.out.print("\n");
	// }

}
