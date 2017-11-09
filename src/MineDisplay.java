import java.util.Scanner;

// import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MineDisplay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		// user choosing size of mine
		System.out.println("How many cells wide would you like your mine?");
		int minWidth = scn.nextInt();
		System.out.println("How many cells height would you like your mine?");
		int minHeight = scn.nextInt();
		GameInstance runningGame = new GameInstance(minWidth, minHeight);
		runningGame.displayGame();
		// original display
		// makeOuterDisplayWidth(minWidth, 0);
		// makeDisplay(minHeight, minWidth, ch);

		// user chooses a cell and if they want to flag it
		// System.out.println("Choose your cell in index format and if you want to flag
		// that index:");

		while (Validator.parseStringCellLocation(runningGame.getGameMineField())) {
			runningGame.displayGame();
		}

		System.out.println("You Exploded!");
		runningGame.displayGame();

		// String usersChoiceLocation = Validator.getString("Use the following format
		// 1,1,F or 1,1,G: ");
		// String[] usersLoc1 = usersChoiceLocation.split(",");
		// String userLoc1A = usersLoc1[0];
		// String userLoc1B = usersLoc1[1];
		// String userLoc1C = usersLoc1[2];
		// int userLocA = Integer.parseInt(userLoc1A);
		// int userLocB = Integer.parseInt(userLoc1B);
		// String box = "this should never be";
		// System.out.println(userLoc1C);
		// System.out.println(userLocA);
		// System.out.println(userLocB);

		/****
		 * verification variables: box
		 * 
		 */

		/*
		 * System.out.println(" Please provide number in box: "); box = scn.nextLine();
		 * 
		 * if (userLoc1C.equalsIgnoreCase("F")) { for (int k = 0; k < userLocA; k++) {
		 * for (int l = 0; l < userLocB; l++) { }
		 * 
		 * } //change state at x,y // displayMinefield or printMinefield method
		 * System.out.println(fl + " @ k,l"); }
		 * 
		 * if (box.equalsIgnoreCase("0") && !(userLoc1C.equalsIgnoreCase("F"))) { //
		 * need to print 0 or blank box or no box in place of box
		 * System.out.println("0 @"); } else if ((box.equalsIgnoreCase("1") ||
		 * box.equalsIgnoreCase("2") || box.equalsIgnoreCase("3") ||
		 * box.equalsIgnoreCase("4") || box.equalsIgnoreCase("5") ||
		 * box.equalsIgnoreCase("6") || box.equalsIgnoreCase("7") ||
		 * box.equalsIgnoreCase("8")) && !(userLoc1C.equalsIgnoreCase("F"))) { // these
		 * all get the same treatment of // printing the // number in place of box
		 * System.out.println("# other than 0 and 9"); } else if
		 * (box.equalsIgnoreCase("9") && !(userLoc1C.equalsIgnoreCase("F"))) {
		 * System.out.println(as + "GameOver"); }
		 * 
		 * else { System.out.println(); }
		 */

		scn.close();
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
