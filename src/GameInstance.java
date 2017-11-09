
public class GameInstance {
	CellField[][] gameMineField;

	/**
	 * @param width
	 * @param height
	 */
	public GameInstance(int width, int height) {
		gameMineField = InitMinefield.genMineFieldObjects(height, width);
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
		// System.out.println("0 1 2 3 4 5 6 7 8 9 10");
		for (int r = 0; r <= gameMineField.length; r++) {

			System.out.print(r + " ");
			if (r == 0) {
				System.out.print(" ");
			}
		}
		System.out.println();
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
}
