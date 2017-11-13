import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class ButtonListener extends JFrame implements ActionListener {
	private JLabel screenInstructions;
	private GameInstance runningGame;
	CellField[][] mineField;
	JButton[][] buttonDisplayArray;

	public ButtonListener() {
		// TODO Auto-generated constructor stub
		setSize(600, 500);// 400 width and 500 height
		setLayout(null);// using no layout managers
		// setVisible(true);// making the frame visible
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("MineSweeper");
		screenInstructions = new JLabel("Please click on any box to view, shift click to flag");
		screenInstructions.setBounds(100, 50, 500, 50);
		add(screenInstructions);
		int sideLength = 10;
		runningGame = new GameInstance(sideLength, 10);
		mineField = runningGame.getGameMineField();
		buttonDisplayArray = new JButton[sideLength][sideLength];
		// runningGame.removeCovers();
		int indexX = 100;
		int indexY = 130;

		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				String buttonSymbol = mineField[j][i].displayCell();
				// System.out.println(" button symbol " + buttonSymbol);
				buttonDisplayArray[i][j] = new CellButton(i, j, buttonSymbol);
				buttonDisplayArray[i][j].setBounds(indexY, indexX, 30, 30);
				buttonDisplayArray[i][j].addActionListener(this);
				indexX += 30;
				// System.out.println("Bounds y " + indexY + " x " + indexX);
			}
			indexY += 30;
			indexX = 100;
		}
		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				add(buttonDisplayArray[i][j]);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CellButton clickedButton = (CellButton) e.getSource();
		// System.out.println("You clicked!" + clickedButton.toString());
		// System.out.println("Action event " + (e.getModifiers() &
		// ActionEvent.SHIFT_MASK));
		if ((e.getModifiers() & ActionEvent.SHIFT_MASK) > 0) {
			// System.out.println("here");
			MineController.processInput(clickedButton.getRow(), clickedButton.getColumn(), true,
					runningGame.gameMineField.length, runningGame.gameMineField);
		} else {
			MineController.processInput(clickedButton.getRow(), clickedButton.getColumn(), false,
					runningGame.gameMineField.length, runningGame.gameMineField);
		}
		// System.out.println("Processed Correctly " + contGame);
		updateButtons();
		// at the end of every action taken by the user- check to see if they have won
		// or lost
		if (runningGame.winCondition()) {
			endGame(true);
		}
	}

	public void updateButtons() {
		int row, col;
		for (row = 0; row < mineField.length; row++) {
			for (col = 0; col < mineField[row].length; col++) {
				// System.out
				// .println("Location " + row + "," + col + " " +
				// mineField[row][col].getViewStatus().toString());

				if (mineField[row][col].getViewStatus() == ViewStatus.UNCOVERED) {

					String changeSymbol = mineField[row][col].displayCell();
					// System.out.println(mineField[row][col].getViewStatus() + " the symb " +
					// changeSymbol);
					buttonDisplayArray[row][col].setText(changeSymbol);
					buttonDisplayArray[row][col].setEnabled(false);// disables the button
					if (changeSymbol.charAt(0) == '\u229b') {
						// end game
						// System.out.println("here");
						endGame(false);
					}
				} else if (mineField[row][col].getViewStatus().toString().equalsIgnoreCase("flagged")) {
					String flagSymbol = mineField[row][col].displayCell();
					buttonDisplayArray[row][col].setText(flagSymbol);
				}

			}
		}

	}

	public void endGame(boolean won) {
		String gameEndMethod;
		if (!won) {
			runningGame.removeCovers();
			gameEndMethod = "Oh No you lost";
		} else {
			gameEndMethod = "Congratulations";
		}
		for (int row = 0; row < mineField.length; row++) {
			for (int col = 0; col < mineField[row].length; col++) {
				String changeSymbol = mineField[row][col].displayCell();
				buttonDisplayArray[row][col].setText(changeSymbol);
				buttonDisplayArray[row][col].setEnabled(false);
			}
		}

		screenInstructions.setText(gameEndMethod);
	}

}
