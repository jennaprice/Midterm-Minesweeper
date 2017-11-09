
public class MineSweeperMain {
	public static void main(String[] args) {
		InitCellState[][] trueMF = InitMinefield.genMineFieldEnums(3, 3);
		for (InitCellState[] row : trueMF) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i].ordinal());
			}
			System.out.println();
		}

		System.out.println();
		CellField[][] mineSweeperField = InitMinefield.genMineFieldObjects(3, 3);
		for (CellField[] row : mineSweeperField) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i].displayCell());
			}
			System.out.println();
		}
		// here I will pick a spot
		int row = Validator.getInt("Please choose a row (0-9)", 0, 9);
		int column = Validator.getInt("Please choose a column (0-9", 0, 9);
		mineSweeperField[row][column].chooseCell();
		displayGame(mineSweeperField);
	}

	public static void displayGame(CellField[][] mineSweeperField) {
		for (CellField[] row : mineSweeperField) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i].displayCell());
			}
			System.out.println();
		}

	}
}
