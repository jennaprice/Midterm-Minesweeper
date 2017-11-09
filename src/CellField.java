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
	private InitCellState cellState;

	/**
	 * cellField is an object that describes the location, and the various states of
	 * this object including COVERED, FLAGGED, UNCOVERED
	 * 
	 * @param xCordinate
	 *            the location in array along the vertical axis
	 * @param yCordintate
	 *            the location in array along the vertical axis
	 */
	public CellField(int xCordinate, int yCordintate) {
		location = new int[] { xCordinate, yCordintate };
		viewStatus = ViewState.COVERED;
		cellState = InitCellState.Free;
	}

	/**
	 * 
	 * @return
	 */
	public ViewState getViewStatus() {
		return viewStatus;
	}

	/**
	 * 
	 * @param viewStatus
	 *            gives the status of whether or not the cellLocation has been
	 *            previously views
	 */
	public void setViewStatus(ViewState viewStatus) {
		this.viewStatus = viewStatus;
	}

	/**
	 * @return location of cell
	 */
	public int[] getLocation() {
		return location;
	}

	/**
	 * Displays String representation of the cellLocation
	 * 
	 * @return String to display to user, except for bombs represented by 9 and must
	 *         be filter
	 */
	public String displayCell() {

		if (viewStatus.toString().equalsIgnoreCase("covered")) {
			return String.valueOf('\u2610');
		} else if (viewStatus.toString().equalsIgnoreCase("flagged")) {
			return "F";
		} else {
			if (cellState.ordinal() > 0) {
				return String.valueOf(cellState.ordinal());
			} else if (cellState.ordinal() == 0) {
				return " ";
			}

		}
		return "errorInDisplay";
	}

	public InitCellState getCellState() {
		return cellState;
	}

	public void setCellState(InitCellState cellState) {
		this.cellState = cellState;
	}

}
