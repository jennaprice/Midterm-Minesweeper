import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class ButtonListener extends JFrame implements ActionListener {
	private JLabel screenInstructions;
	private GameInstance runningGame;
	MineController mineField;
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
		Object[] options = { "Large", "Medium", "Small" };
		int n = JOptionPane.showOptionDialog(this, "Please choose the size of your game", ":",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
		System.out.println(" n is" + n);
		if (n == 0)
			sideLength = 20;
		else if (n == 1)
			sideLength = 15;
		else
			sideLength = 10;
		mineField = new MineController(sideLength, 15);
		runningGame = new GameInstance(mineField);
		setUpPlayfield(sideLength);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CellButton clickedButton = (CellButton) e.getSource();

		if ((e.getModifiers() & ActionEvent.SHIFT_MASK) > 0) {
			System.out.println(
					"here flagging" + " row " + clickedButton.getRow() + " column " + clickedButton.getColumn());
			mineField.processInput(clickedButton.getRow(), clickedButton.getColumn(), true, mineField.getHeight());
		} else {
			System.out.println("here" + " row " + clickedButton.getRow() + " column " + clickedButton.getColumn());
			mineField.processInput(clickedButton.getRow(), clickedButton.getColumn(), false, mineField.getHeight());
		}
		System.out.println("Processed Correctly updating buttons ");
		updateButtons();
		// at the end of every action taken by the user- check to see if they have won
		// or lost
		if (runningGame.winCondition()) {
			endGame(true);
		}
	}

	public void updateButtons() {
		int row, col;
		mineField.displayGame();
		for (row = 0; row < mineField.getGameMineField().length; row++) {
			for (col = 0; col < mineField.getGameMineField()[row].length; col++) {
				// System.out
				// .println("Location " + row + "," + col + " " +
				// mineField[row][col].getViewStatus().toString());

				if (mineField.getGameMineField()[row][col].getViewStatus() == ViewStatus.UNCOVERED) {

					String changeSymbol = mineField.getGameMineField()[row][col].displayCellGUI();
					// System.out.println(mineField[row][col].getViewStatus() + " the symb " +
					// changeSymbol);
					buttonDisplayArray[row][col].setText(changeSymbol);
					buttonDisplayArray[row][col].setEnabled(false);// disables the button
					if (changeSymbol.charAt(0) == '\u229b') {
						// end game
						// System.out.println("here");
						endGame(false);
					}
				} else {
					String textValue = mineField.getGameMineField()[row][col].displayCellGUI();
					buttonDisplayArray[row][col].setText(textValue);
				}

			}
		}

	}

	public void setUpPlayfield(int sideLength) {
		buttonDisplayArray = new JButton[sideLength][sideLength];

		// runningGame.removeCovers();
		int indexX = 100;
		int indexY = 130;

		for (int i = 0; i < mineField.getHeight(); i++) {
			for (int j = 0; j < mineField.getWidth(); j++) {
				String buttonSymbol = mineField.getGameMineField()[j][i].displayCellGUI();
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
		for (int i = 0; i < mineField.getHeight(); i++) {
			for (int j = 0; j < mineField.getWidth(); j++) {
				add(buttonDisplayArray[i][j]);
			}
		}

	}

	public void endGame(boolean won) {
		String gameEndMethod;
		if (!won) {
			mineField.removeCovers();
			gameEndMethod = "Oh No you lost";
		} else {
			gameEndMethod = "Congratulations";
		}
		for (int row = 0; row < mineField.getGameMineField().length; row++) {
			for (int col = 0; col < mineField.getGameMineField()[row].length; col++) {
				String changeSymbol = mineField.getGameMineField()[row][col].displayCellGUI();
				buttonDisplayArray[row][col].setText(changeSymbol);
				buttonDisplayArray[row][col].setEnabled(false);
			}
		}

		screenInstructions.setText(gameEndMethod);
	}

}
