import java.util.Scanner;

public class Validator {

	static Scanner sc = new Scanner(System.in);

	public static String getString(String prompt) {
		System.out.print(prompt);
		String s = sc.next(); // read user entry
		sc.nextLine(); // discard any other data entered on the line
		return s;
	}

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

	public static int getInt(Scanner sc, String prompt, int min, int max) {
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

	// you have to initialize and update a count or your for loop will run forever
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

	public static boolean continueProgram(String prompt, String continuance) {
		boolean contBoolean = false;

		String cont = getString(prompt);

		contBoolean = cont.equalsIgnoreCase(continuance);
		return contBoolean;
	}

	public static boolean continueProgram(int runTimes, String prompt) {
		boolean contBoolean = false;

		if (runTimes != 0) {
			String cont = getString(prompt);
			contBoolean = cont.equalsIgnoreCase("y");
		} else {
			contBoolean = true;
		}
		return contBoolean;
	}

	public static void closeScanner() {
		sc.close();
	}

}