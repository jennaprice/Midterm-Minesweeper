import javax.swing.JButton;

public class CellButton extends JButton {
	final int col;
	final int row;

	public CellButton(int i, int j, String symbol) {

		super(symbol);

		row = i;
		col = j;
	}

	public String toString() {
		return ("Location row " + row + " column " + col + " sym " + super.getText());
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return col;
	}
}
