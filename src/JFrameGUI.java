
/**
* Tutorial from https://www.javatpoint.com/java-swing
*@see java.lang.Object
*@author Jenna Price
*@version 1.0 
*Date: Nov 8th, 2017 
*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JFrameGUI {

	JFrame f;

	public JFrameGUI() {
		// TODO Auto-generated constructor stub
		f = new JFrame();// creating instance of JFrame
		// the display should display dynamically based on the size of the existing
		int sideLength = 10;
		GameInstance runningGame = new GameInstance(sideLength, 10);
		CellField[][] mineField = runningGame.getGameMineField();
		JButton[][] buttonDisplayArray = new JButton[sideLength][sideLength];
		// runningGame.removeCovers();
		int indexX = 100;
		int indexY = 130;

		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				String buttonSymbol = mineField[j][i].displayCell();
				// System.out.println(" button symbol " + buttonSymbol);
				buttonDisplayArray[i][j] = new JButton(buttonSymbol);
				buttonDisplayArray[i][j].setBounds(indexY, indexX, 30, 30);
				indexX += 30;
				// System.out.println("Bounds y " + indexY + " x " + indexX);
			}
			indexY += 30;
			indexX = 100;
		}
		// array
		// click event
		/*
		 * JButton b = new JButton("*");// creating instance of JButton JButton c = new
		 * JButton(" "); b.setBounds(130, 100, 20, 20); // y, x, height, width
		 * c.setBounds(130, 120, 20, 20);
		 * 
		 * f.add(b);// adding button in JFrame f.add(c);
		 */
		for (int i = 0; i < mineField.length; i++) {
			for (int j = 0; j < mineField[i].length; j++) {
				f.add(buttonDisplayArray[i][j]);
			}
		}
		f.setSize(600, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// runningGame.displayGame();
	}

}
