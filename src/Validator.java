import java.util.Scanner;

/**
 * @author jennaprice
 * @version 1.0
 */

public class Validator {

	static Scanner sc = new Scanner(System.in);

	public static void parseString() {
		String usersChoiceLocation = getString("Use the following format 1,1,F or 1,1,G: ");
		String[] usersLoc1 = usersChoiceLocation.split(",");
		String userLoc1A = usersLoc1[0];
		String userLoc1B = usersLoc1[1];
		String userLoc1C = usersLoc1[2];
		int userLocA = Integer.parseInt(userLoc1A);
		int userLocB = Integer.parseInt(userLoc1B);
		String box = "this should never be";
		System.out.println(userLoc1C);
		System.out.println(userLocA);
		System.out.println(userLocB);
	}
	/**
	 * This method returns a String from the User
	 * 
	 * @param prompt
	 *            - the String message you would like displayed prompting the user
	 * @return
	 */
	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

	/**
	 * This method returns a String from the choices you specify
	 * 
	 * @param prompt
	 *            - the String message you would like displayed prompting the user
	 * @param choices
	 *            - an array of the Strings you would like to accept from the user
	 * @return
	 */
	public static String getSpecificString(String prompt, String[] choices) {
		boolean validInput = false;
		String correct;
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		int i;
		for (i = 0; i < choices.length; i++) {
			if (s.equals(choices[i])) {
				validInput = true;
				break;
			}

		}

		if (validInput) {
			sc.nextLine(); // discard any other data entered on the line
			return s;
		} else {
			System.out.println("You did not enter a valid choice, please look at the prompt and try again.");
			sc.nextLine();
			correct = getSpecificString(prompt, choices);

		}

		return correct;
	}

	/**
	 * This method returns and int from user input
	 * 
	 * @param prompt
	 *            - the String message you would like displayed prompting the user
	 * @param prompt
	 * @return
	 */
	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	/**
	 * This method returns an int from user input
	 * 
	 * @param prompt
	 *            - the String message you would displayed prompting the user
	 * @param min
	 *            - min int to accept from user
	 * @param max
	 *            - min int to accept from user
	 * @return
	 */
	public static int getInt(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false) {
			i = getInt(prompt);
			if (i < min)
				System.out.println("Number must be " + min + " or greater.");
			else if (i > max)
				System.out.println("Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return i;
	}

	/**
	 * The method returns the double entered by user
	 * 
	 * @param prompt
	 *            - the String message you would displayed prompting the user
	 * @return
	 */
	public static double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid decimal value. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	/**
	 * This method returns a doubel within a set up specified parameters
	 * 
	 * @param prompt
	 *            - the String message you would displayed prompting the user
	 * @param min
	 *            - min double you would like to accept
	 * @param max
	 *            - max double you would like to accept
	 * @return
	 */
	public static double getDouble(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (isValid == false) {
			d = getDouble(prompt);
			if (d < min)
				System.out.println("Error! Number must be " + min + " or greater.");
			else if (d > max)
				System.out.println("Error! Number must be " + max + " or less.");
			else
				isValid = true;
		}
		return d;
	}

	/**
	 * A method that handles the logic for a loop that has to run once before it
	 * prompts the user
	 * 
	 * @param runTimes
	 *            - how many times this loop has run, you need to update in the
	 *            while loop, or this will cause your loop to never ask the user the
	 *            prompt
	 * @param prompt
	 *            - String you would like displayed to the user
	 * @param continuance
	 *            - the String they would need to enter to continue the program
	 * @return
	 */
	public static boolean doOnceContinueProgram(int runTimes, String prompt, String continuance) {
		boolean contBoolean = false;

		if (runTimes != 0) {
			String cont = getString(prompt);
			contBoolean = cont.equalsIgnoreCase(continuance);
		} else {
			contBoolean = true;
		}
		return contBoolean;
	}

	/**
	 * This method has the logic for continuing a while loop on the users input
	 * 
	 * @param prompt
	 *            - String you would like displayed to the user
	 * @param continuance
	 *            - the String they would need to enter to continue the program
	 * @return
	 */
	public static boolean continueProgram(String prompt, String continuance) {
		boolean contBoolean = false;

		String cont = getString(prompt);

		contBoolean = cont.equalsIgnoreCase(continuance);
		return contBoolean;
	}

	/**
	 * Because this class has an embedded Scanner object, at the end of any method
	 * that uses this class we need to call this method to close the scanner
	 * 
	 */
	public static void closeScanner() {
		sc.close();
	}

}