
public class MineSweeperMain {
	public static void main(String[] args) {
		InitCellState[][] trueMF = InitMinefield.genMineField(10, 10);
		for (InitCellState[] row : trueMF) {
			for (int i = 0; i < row.length; i++) {
				System.out.print(row[i].ordinal());
			}
			System.out.println();
		}
	}
}
