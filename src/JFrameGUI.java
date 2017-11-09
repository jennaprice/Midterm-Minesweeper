
/**
* Tutorial from https://www.javatpoint.com/java-swing
*@see java.lang.Object
*@author Jenna Price
*@version 1.0 
*Date: Nov 8th, 2017 
*/

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameGUI {

	JFrame f;

	public JFrameGUI() {
		// TODO Auto-generated constructor stub
		f = new JFrame();// creating instance of JFrame
		// the display should display dynamically based on the size of the existing
		// array
		// click event
		JButton b = new JButton("*");// creating instance of JButton
		JButton c = new JButton(" ");
		b.setBounds(130, 100, 20, 20); // y, x, height, width
		c.setBounds(130, 120, 20, 20);

		f.add(b);// adding button in JFrame
		f.add(c);

		f.setSize(400, 500);// 400 width and 500 height
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible
	}

}
