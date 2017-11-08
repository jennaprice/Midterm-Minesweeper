import java.util.Random;

public class InitMinefield {

	/**
	 * @param sideLength Number of mines we want to distribute to the mine
	 * @param mineCount Side length of minefield
	 * @return The true minefield which we're initializing 
	 */
	public static InitCellState[][] genMineField(int sideLength, int mineCount) {
		InitCellState[][] trueMineField = new InitCellState[sideLength][sideLength];
		distributeMines(mineCount, sideLength, trueMineField);
		calculateNeighbors(sideLength, trueMineField);
		return trueMineField;
	}

	/**
	 * @param mineC Number of mines we want to distribute to the mine
	 * @param sideL Side length of minefield
	 * @param trueMF Minefield we want to distribute mines into
	 */
	public static void distributeMines(int mineC, int sideL, InitCellState[][] trueMF) {
		// Initially populate each cell in true minefield with free spaces
		for (InitCellState[] row : trueMF) {
			for (int i = 0; i < row.length; i++) {
				row[i] = InitCellState.Free;
			}
		}

		// Randomly populate true minefield with mines
		Random r = new Random();
		int minesPlacedSoFar = 0;
		while (minesPlacedSoFar < mineC) {
			int x = r.nextInt(sideL);
			int y = r.nextInt(sideL);
			if (trueMF[x][y] == InitCellState.Free) {
				trueMF[x][y] = InitCellState.Mine;
				minesPlacedSoFar++;
			}
		}

	}

	/**
	 * @param sideL Size in int of width and height of minefield 
	 * @param trueMF The minefield for which we want to calculate neighbors
	 */
	public static void calculateNeighbors(int sideL, InitCellState[][] trueMF) {
		//For each value in the array, determine every mine that is nearby if it's not a mine 
		for (int y = 0; y < sideL; y++) {
			for (int x = 0; x < sideL; x++) {
				if (trueMF[y][x] != InitCellState.Mine) {
					//If not a mine, check nearby mines
					trueMF[y][x] = minesNear(y, x, sideL, trueMF);
				}
			}
		}
	}

	/**
	 * @param y Integer height coordinate of cell
	 * @param x Integer height coordinate of cell
	 * @param sideL Length of array for bounds for both x and y coordinate search
	 * @param trueMF The hint or count of mine neighbors that will be displayed on the true minefield
	 * @return Whether or not there is a mine at the state we're searching so that we can add to the neighbor mine count
	 */
	public static int mineAt(int y, int x, int sideL, InitCellState[][] trueMF) {
	    // we need to check also that we're not out of array bounds as that would
	    // be an error
	    if(y >= 0 && y < sideL && x >= 0 && x < sideL && trueMF[y][x] == InitCellState.Mine) {
	      return 1;
	    } else {
	      return 0;
	    }
	  }

	/**
	 * @param y Integer height coordinate of cell
	 * @param x Integer height coordinate of cell
	 * @param sideL Length of array for bounds for both x and y coordinate search
	 * @param trueMF Input enum array we want to count cells from
	 * @return The hint or count of mine neighbors that will be displayed on the true minefield
	 */
	public static InitCellState minesNear(int y, int x, int sideL, InitCellState[][] trueMF) {
		int countOfNeighborMines = 0;
		// check mines in all directions, increment for each mine found starting on the NW side
		countOfNeighborMines += mineAt(y - 1, x - 1, sideL, trueMF); // NW
		countOfNeighborMines += mineAt(y - 1, x, sideL, trueMF); // N
		countOfNeighborMines += mineAt(y - 1, x + 1, sideL, trueMF); // NE
		countOfNeighborMines += mineAt(y, x - 1, sideL, trueMF); // W
		countOfNeighborMines += mineAt(y, x + 1, sideL, trueMF); // E
		countOfNeighborMines += mineAt(y + 1, x - 1, sideL, trueMF); // SW
		countOfNeighborMines += mineAt(y + 1, x, sideL, trueMF); // S
		countOfNeighborMines += mineAt(y + 1, x + 1, sideL, trueMF); // SE
		if (countOfNeighborMines > 0) {
			return InitCellState.fromOrdinal(countOfNeighborMines);
		} else {
			return InitCellState.Free;
		}

	}

}