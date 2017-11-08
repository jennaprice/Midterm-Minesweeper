import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class MineDisplay {

	/**
	 * @param args
	 */
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
		System.out.println("Choose your cell in index and if you want to flag that index..." );
		System.out.println("only choose F for flagging a mine and G if not flagging at all");
		String usersChoiceLocation = Validator.getString("Use the following format 1,1,F or 1,1,G: " );
		String[] usersLoc1 = usersChoiceLocation.split(",");
		String userLoc1A = usersLoc1[0];
		String userLoc1B = usersLoc1[1];
		String userLoc1C = usersLoc1[2];
		int userLocA = Integer.parseInt(userLoc1A);
		int userLocB = Integer.parseInt(userLoc1B);
		String box = "this should never be";
		
		//the 
		
		for (int k = 0; k < userLocA; k++) {
			for (int l = 0; l < userLocB; l++) {
				if (userLoc1C == "F") {  
					if (box == "9") { //this blows up
						
					}else if (box != "9"){ // this is when user flags something other than a mine and needs to unflag it?? even if the number is 0....
						
					}
					
				else {   
					if (box == "0") {  //need to print 0 or blank box or no box in place of box
						System.out.println();
					}
					else if (box == "1" || box == "2" || box == "3" || box == "4" 
							|| box == "5" || box == "6" || box == "7" || box == "8") { // these all get the same treatment of printing the number in place of box
						
					}
				}
			}
		}
		}
		scn.close();
	}



	/**
	 * method for box display
	 * 
	 * @param makeHeight - int number of boxes going down
	 * @param makeWidth - int number of boxes going right
	 * @param makeCh - the unicode u+2610 assignment through parameter
	 */
	public static void makeDisplay(int makeHeight, int makeWidth, char makeCh) {
		for (int i = 0; i < makeWidth; i++) {
			System.out.print(i + 1);
			for (int j = 0; j< makeHeight; j++) {
				System.out.print(" " + makeCh);
			}
			System.out.println();
		}
	}
		/**
		 * 
		 * Needed to line the numbers on the left side of boxes
		 * @param makeWidth - in order to place a number in front of each line of width
		 * @param i  - is to increment on down the left of the boxes
		 */
		public static void makeOuterDisplayWidth(int makeWidth, int i) {
			//int counter;
			for (i = 0; i < makeWidth; i++) {
					//counter = i;
					System.out.print(" " + " " + (i + 1));
			}
			System.out.println();
		}
		
		
//		for (int i = 0; i < minWidth; i++) {
//		for (int j = 0; j< minHeight; j++) {
//			System.out.print("" + ch);
//		}
//		System.out.print("\n");
//	}
		
}
