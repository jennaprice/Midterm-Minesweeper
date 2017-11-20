/**
 * The object that contains the information about the cell
 * 
 * @see java.lang.Object
 * @author Jenna Price
 * @version Date:
 */

public class CellField {
	private final int[] location;
	private ViewStatus viewState;
	private InitCellState initState;

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
		viewState = ViewStatus.COVERED;
		initState = InitCellState.Free;
	}

	/**
	 * 
	 * @return
	 */
	public ViewStatus getViewStatus() {
		return viewState;
	}

	/**
	 * 
	 * @param viewStatus
	 *            gives the status of whether or not the cellLocation has been
	 *            previously views
	 */
	public void setViewStatus(ViewStatus viewState) {
		this.viewState = viewState;
	}

	/**
	 * @return location of cell
	 */
	public int[] getLocation() {
		return location;
	}

	public boolean checkLocation() {
		boolean explosion = true;
		if (initState == InitCellState.Mine) {
			explosion = false;
		}
		return explosion;
	}

	/**
	 * Displays String representation of the cellLocation
	 * 
	 * @return String to display to user, except for bombs represented by 9 and must
	 *         be filter
	 */
	public String displayCellText() {
		if (viewState.toString().equalsIgnoreCase("covered")) {
			return String.valueOf('\u2588');
			// return " ";-- gui
		} else if (viewState.toString().equalsIgnoreCase("flagged")) {
			return String.valueOf('\u2691');
		} else if (initState.ordinal() == 9) { // bombs
			return String.valueOf('\u229b');
		} else if (initState.ordinal() == 0) {
			return String.valueOf('\u25a1');
		} else {
			if (initState.ordinal() > 0) {
				return String.valueOf(initState.ordinal());
			}

		}
		return "errorInDisplay";
	}

	public String displayCellGUI() {
		if (viewState.toString().equalsIgnoreCase("covered")) {
			// return String.valueOf('\u2588');
			return " ";
		} else if (viewState.toString().equalsIgnoreCase("flagged")) {
			return String.valueOf('\u2691');
		} else if (initState.ordinal() == 9) { // bombs
			return String.valueOf('\u229b');
		} else if (initState.ordinal() == 0) {
			return String.valueOf('\u25a1');
		} else {
			if (initState.ordinal() > 0) {
				return String.valueOf(initState.ordinal());
			}

		}
		return "errorInDisplay";
	}

	public InitCellState getCellState() {
		return initState;
	}

	public void setCellState(InitCellState initState) {
		this.initState = initState;
	}

	public void chooseCell() {
		viewState = ViewStatus.UNCOVERED;
	}

}
