public class MineSweeperMain {

	public static void main(String[] args) {

		InitCellState[][] trueMF = InitMinefield.genMineFieldEnums(10, 10);

		for (InitCellState[] row : trueMF) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i].ordinal());
			}
			System.out.println();
		}

		System.out.println();
		CellField[][] mineSweeperField = InitMinefield.genMineFieldObjects(10, 10);

		mineSweeperField[7][5].setViewState(ViewStatus.UNCOVERED);
		displayGame(mineSweeperField);
		mineSweeperField[5][7].setViewState(ViewStatus.UNCOVERED);
		displayGame(mineSweeperField);
	}

	public static void displayGame(CellField[][] mineSweeperField) {
		int k = 1;
		System.out.println("0 1 2 3 4 5 6 7 8 9 10");

		for (CellField[] row : mineSweeperField) {
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
}
