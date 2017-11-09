
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
				System.out.print(row[i].getCellState().ordinal());
			}
			System.out.println();
		}
	}
}
