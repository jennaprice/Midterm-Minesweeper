/**
 * The object that contains the information about the cell
 * 
 * @see java.lang.Object
 * @author Jenna Price
 * @version Date:
 */

public class CellField {
	private final int[] location;
	private ViewState viewStatus;
	// private InitCellState cellState;

	/**
	 * @param xCordinate
	 *            the location in array along the vertical axis
	 * @param yCordintate
	 *            the location in array along the vertical axis
	 */
	public CellField(int xCordinate, int yCordintate) {
		location = new int[] { xCordinate, yCordintate };
		viewStatus = ViewState.COVERED;
	}
}
