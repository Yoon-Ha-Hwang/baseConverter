package baseConverter;

import java.util.Scanner;

public class BaseConverter {
	static Scanner read = new Scanner(System.in);
	
	public static int originalBase;
	public static String originalValue;
	public static int targetBase;
	public static String targetValue;
	
	//These are to check whether the user is entering values specific to the base. 
	//If anything gets .indexOf == -1ed then that means they entered something that doesn't belong in the base.
	public static final String TwoAllowed = "01";
	public static final String EightAllowed = "01234567";
	public static final String TenAllowed = "0123456789";
	public static final String TwelveAllowed = "0123456789AB";
	public static final String SixteenAllowed = "0123456789ABCDEF";
			
	/* Notes on base-12 and base-16
	 * A = ten
	 * B = eleven
	 * C = twelve
	 * D = thirteen
	 * E = fourteen
	 * F = fifteen
	*/

	
	public static void main(String[] args) {		
		System.out.println("Welcome to Base Converter, here you can convert values in different bases into other bases.\nIt currently supports base-2, 8, 10, 12, and 16.");
		
		while(true) {
			//Reset
			originalBase = 0;
			originalValue = "";
			targetBase = 0;
			targetValue = "";
			
			System.out.println("What base is the original number in (enter 2, 8, 10, 12, and 16 only)?");
			while(!(originalBase == 2 || originalBase == 8 || originalBase == 10 || originalBase == 12 || originalBase == 16)) {
				String originalBaseEntered = read.next();
				if(originalBaseEntered.equals("2")) {
					originalBase = 2;
				} else if(originalBaseEntered.equals("8")) {
					originalBase = 8;
				} else if(originalBaseEntered.equals("10")) {
					originalBase = 10;
				} else if(originalBaseEntered.equals("12")) {
					originalBase = 12;
				} else if(originalBaseEntered.equals("16")) {
					originalBase = 16;
				} else {
					System.out.println("This base value isn't supported. Please enter again.");
				}
			} //When it exits this loop it has chosen 2, 8, 10, 12, or 16
			
			System.out.println("You have selected a base of " + originalBase + ", now please enter the value you want to convert");
			boolean valid = false;
			while(!valid) {
				originalValue = read.next();
				originalValue.toUpperCase(); //Not sure if a != A, but let's do it just in case
				if(originalBase == 2) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TwoAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							break;
						}
					}
					valid = true;
				} else if(originalBase == 8) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(EightAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							break;
						}
					}
					valid = true;
				} else if(originalBase == 10) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							break;
						}
					}
					valid = true;
				} else if(originalBase == 12) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TwelveAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							break;
						}
					}
					valid = true;
				} else if(originalBase == 16) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(SixteenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							break;
						}
					}
					valid = true;
				} else { //This shouldn't be reached because then it didn't pass the previous step
					System.out.println("ERROR ERROR ERROR");
				}
			}
			System.out.println("To which base would you like to convert the value to? (enter 2, 8, 10, 12, and 16 only)");
			while(!(targetBase == 2 || targetBase == 8 || targetBase == 10 || targetBase == 12 || targetBase == 16)) {
				String targetBaseEntered = read.next();
				if(targetBaseEntered.equals("2")) {
					targetBase = 2;
				} else if(targetBaseEntered.equals("8")) {
					targetBase = 8;
				} else if(targetBaseEntered.equals("10")) {
					targetBase = 10;
				} else if(targetBaseEntered.equals("12")) {
					targetBase = 12;
				} else if(targetBaseEntered.equals("16")) {
					targetBase = 16;
				} else {
					System.out.println("This base value isn't supported. Please enter again.");
				}
			}
			//Start the conversion process
			Integer valueInBaseTen = 0;
			
			//First, convert the originalValue into base-10
			for(int i = 0; i < originalValue.length(); i++) { //Note that index 0 has the greatest place value
				int equivalentValue = 0;
				if(originalBase == 2) {
					equivalentValue = TwoAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 8) {
					equivalentValue = EightAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 10) {
					equivalentValue = TenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 12) {
					equivalentValue = TwelveAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 16) {
					equivalentValue = SixteenAllowed.indexOf(originalValue.substring(i, i+1));
				} else { //This shouldn't be reached
					System.out.println("ERROR");
				}
				valueInBaseTen = valueInBaseTen + (int)(equivalentValue * Math.pow(originalBase, originalValue.length() - i - 1));
			}
			
			//Now we have originalValue in base-10. Now convert to other bases.
			int numDigits; //This is the number of digits targetBase would have (i.e. targetBase.length())
			if(targetBase == 2) {
				numDigits = (int)(Math.log(valueInBaseTen) / Math.log(2)) + 1;
				for(int i = 0; i < numDigits; i++) {
					targetValue += TwoAllowed.indexOf(valueInBaseTen / (int)(Math.pow(targetBase, i)));
					valueInBaseTen -= (valueInBaseTen / (int)(Math.pow(targetBase, i))) * (int)(Math.pow(targetBase, i));
				}
			} else if(targetBase == 8) {
				numDigits = (int)(Math.log(valueInBaseTen) / Math.log(8)) + 1;
				for(int i = 0; i < numDigits; i++) {
					targetValue += EightAllowed.indexOf(valueInBaseTen / (int)(Math.pow(targetBase, i)));
					valueInBaseTen -= (valueInBaseTen / (int)(Math.pow(targetBase, i))) * (int)(Math.pow(targetBase, i));
				}
			} else if(targetBase == 12) {
				numDigits = (int)(Math.log(valueInBaseTen) / Math.log(12)) + 1;
				for(int i = 0; i < numDigits; i++) {
					targetValue += TwelveAllowed.indexOf(valueInBaseTen / (int)(Math.pow(targetBase, i)));
					valueInBaseTen -= (valueInBaseTen / (int)(Math.pow(targetBase, i))) * (int)(Math.pow(targetBase, i));
				}
			} else if(targetBase == 16) {
				numDigits = (int)(Math.log(valueInBaseTen) / Math.log(16)) + 1;
				for(int i = 0; i < numDigits; i++) {
					targetValue += SixteenAllowed.indexOf(valueInBaseTen / (int)(Math.pow(targetBase, i)));
					valueInBaseTen -= (valueInBaseTen / (int)(Math.pow(targetBase, i))) * (int)(Math.pow(targetBase, i));
				}
			} else if(targetBase == 10) { //I mean, we just calculated the value in base-10, so...
				targetValue = valueInBaseTen.toString();
			} else { //This shouldn't be reached
				System.out.println("ERROR ERROR");
			}
			
			//Print results
			System.out.println(originalValue + " in base " + originalBase + " is " + targetValue + " in base " + targetBase + ".");
		}
	}
}
