import java.util.Scanner;

public class MineDisplay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("How many cells height would you like your mine?");
		int minHeight = scn.nextInt();
		System.out.println("How many cells wide would you like your mine?");
		int minWidth = scn.nextInt();
		//char[] chHeight = new char[mineHeight];
		char ch = '\u2610';
		for (int i = 0; i < minWidth; i++) {
			for (int j = 0; j< minHeight; j++) {
				System.out.print("" + ch);
			}
			System.out.print("\n");
		}
		
//		System.out.println(ch);
//		System.out.println(char[].class);

		scn.close();
	}

}
