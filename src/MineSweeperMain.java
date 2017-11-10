import java.util.Scanner;

public class MineSweeperMain {

	public static void main(String[] args) {
		/*
		 * InitCellState[][] trueMF = InitMinefield.genMineFieldEnums(10, 10);
		 * 
		 * for (InitCellState[] row : trueMF) { for (int i = 0; i < row.length; i++) {
		 * System.out.print(row[i].ordinal()); } System.out.println(); }
		 */
		Scanner scn = new Scanner(System.in);
		System.out.println();
		System.out.println("How many cells wide would you like your mine?");
		int minWidth = scn.nextInt();
		System.out.println("How many cells height would you like your mine?");
		int minHeight = scn.nextInt();
		GameInstance runningGame = new GameInstance(minWidth, minHeight);
		runningGame.displayGame();
		System.out.println("Which column would you like ot choose?");
		int col = scn.nextInt();
		System.out.println("Would you like to choose?");
		int row = scn.nextInt();
		runningGame.processInput(col, row, false, 10);
		runningGame.displayGame();
		scn.close();
	}

}
