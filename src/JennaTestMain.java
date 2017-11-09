
public class JennaTestMain {

	public static void main(String[] args) {
		CellField zeroZero = new CellField(0, 0);

		System.out.println(zeroZero.displayCell());
		zeroZero.setCellState(InitCellState.Three);
		zeroZero.setViewStatus(ViewState.FLAGGED);

		System.out.println(zeroZero.displayCell());

		new JFrameGUI();

	}

}
