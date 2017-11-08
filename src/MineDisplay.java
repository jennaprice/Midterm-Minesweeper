import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MineDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
	//user choosing size of mine
		System.out.println("How many cells height would you like your mine?");
		int minHeight = scn.nextInt();
		System.out.println("How many cells wide would you like your mine?");
		int minWidth = scn.nextInt();
		//char[] chHeight = new char[mineHeight];
		char ch = '\u2610';
		
		makeOuterDisplayWidth(minWidth, 0);
		makeDisplay(minHeight, minWidth, ch);
		
		
	// user chooses a cell and if they want to flag it
		//System.out.println("Choose your cell in index format and if you want to flag that index:");
		String usersChoiceLocation = Validator.getString("Choose your cell in index format and if you want to flag that index: " );
		



		scn.close();
	}

	public static void makeDisplay(int makeHeight, int makeWidth, char makeCh) {
		for (int i = 0; i < makeWidth; i++) {
			System.out.print(i + 1);
			for (int j = 0; j< makeHeight; j++) {
				System.out.print(" " + makeCh);
			}
			System.out.println();
		}
	}
		public static void makeOuterDisplayWidth(int makeWidth, int i) {
			//int counter;
			for (i = 0; i < makeWidth; i++) {
					//counter = i;
					System.out.print(" " + " " + (i + 1));
			}
			System.out.println();
		}
		public static void makeOuterDisplayHeight(int makeWidht, int makeHeight, int i) {
			
			
		}
//		for (int i = 0; i < minWidth; i++) {
//		for (int j = 0; j< minHeight; j++) {
//			System.out.print("" + ch);
//		}
//		System.out.print("\n");
//	}
		
}
