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
	public static final String ThreeAllowed = "012";
	public static final String FourAllowed = "0123";
	public static final String FiveAllowed = "01234";
	public static final String SixAllowed = "012345";
	public static final String SevenAllowed = "0123456";
	public static final String EightAllowed = "01234567";
	public static final String NineAllowed = "012345678";
	public static final String TenAllowed = "0123456789";
	public static final String ElevenAllowed = "0123456789A";
	public static final String TwelveAllowed = "0123456789AB";
	public static final String ThirteenAllowed = "0123456789ABC";
	public static final String FourteenAllowed = "0123456789ABCD";
	public static final String FifteenAllowed = "0123456789ABCDE";
	public static final String SixteenAllowed = "0123456789ABCDEF";
			
	/* Notes on bases 11 through 16
	 * A = ten
	 * B = eleven
	 * C = twelve
	 * D = thirteen
	 * E = fourteen
	 * F = fifteen
	*/
	
	//I know, this will get mildly infuriating but honestly I don't know how else I can do it...

	public static void main(String[] args) {		
		System.out.println("Welcome to Base Converter, here you can convert values in different bases into other bases.\nIt currently supports all base values between 2 and 16 (inclusive)");
		
		while(true) {
			//Reset
			originalBase = 0;
			originalValue = "";
			targetBase = 0;
			targetValue = "";
			
			System.out.println("What base is the original number in?");
			while(!(originalBase >= 2 && originalBase <= 16)) {
				String originalBaseEntered = read.next();
				if(originalBaseEntered.equals("2")) {
					originalBase = 2;
				} else if(originalBaseEntered.equals("3")) {
					originalBase = 3;
				} else if(originalBaseEntered.equals("4")) {
					originalBase = 4;
				} else if(originalBaseEntered.equals("5")) {
					originalBase = 5;
				} else if(originalBaseEntered.equals("6")) {
					originalBase = 6;
				} else if(originalBaseEntered.equals("7")) {
					originalBase = 7;
				} else if(originalBaseEntered.equals("8")) {
					originalBase = 8;
				} else if(originalBaseEntered.equals("9")) {
					originalBase = 9;
				} else if(originalBaseEntered.equals("10")) {
					originalBase = 10;
				} else if(originalBaseEntered.equals("11")) {
					originalBase = 11;
				} else if(originalBaseEntered.equals("12")) {
					originalBase = 12;
				} else if(originalBaseEntered.equals("13")) {
					originalBase = 13;
				} else if(originalBaseEntered.equals("14")) {
					originalBase = 14;
				} else if(originalBaseEntered.equals("15")) {
					originalBase = 15;
				} else if(originalBaseEntered.equals("16")) {
					originalBase = 16;
				} else {
					System.out.println("This base value isn't supported. Please enter again.");
				}
			} //It's only allowed to exit when it selects a value 2~16
			
			System.out.println("You have selected a base of " + originalBase + ", now please enter the value you want to convert");
			boolean valid = false;
			int numInvalid = 0;
			originalValue = read.next();
			originalValue = originalValue.toUpperCase(); 
			while(!valid) {
				if(originalBase == 2) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TwoAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 3) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(ThreeAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 4) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(FourAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 5) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(FiveAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 6) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(SixAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 7) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(SevenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 8) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(EightAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 9) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(NineAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 10) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 11) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(ElevenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 12) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(TwelveAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 13) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(ThirteenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 14) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(FourteenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 15) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(FifteenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else if(originalBase == 16) {
					for(int i = 0; i < originalValue.length(); i++) {
						if(SixteenAllowed.indexOf(originalValue.substring(i, i+1)) == -1) {
							System.out.println(originalValue.substring(i, i+1) + " is not a valid value in base " + originalBase + ". Please enter a different value.");
							numInvalid++;
							break;
						}
					}
				} else { //This shouldn't be reached because then it didn't pass the previous step
					System.out.println("ERROR ERROR ERROR");
				}
				if(numInvalid == 0) {
					valid = true;
				} else {
					numInvalid = 0;
					originalValue = read.next();
				}
			}
			System.out.println("To which base would you like to convert the value to?");
			while(!(targetBase >= 2 && targetBase <= 16)) {
				String targetBaseEntered = read.next();
				if(targetBaseEntered.equals("2")) {
					targetBase = 2;
				} else if(targetBaseEntered.equals("3")) {
					targetBase = 3;
				} else if(targetBaseEntered.equals("4")) {
					targetBase = 4;
				} else if(targetBaseEntered.equals("5")) {
					targetBase = 5;
				} else if(targetBaseEntered.equals("6")) {
					targetBase = 6;
				} else if(targetBaseEntered.equals("7")) {
					targetBase = 7;
				} else if(targetBaseEntered.equals("8")) {
					targetBase = 8;
				} else if(targetBaseEntered.equals("9")) {
					targetBase = 9;
				} else if(targetBaseEntered.equals("10")) {
					targetBase = 10;
				} else if(targetBaseEntered.equals("11")) {
					targetBase = 11;
				} else if(targetBaseEntered.equals("12")) {
					targetBase = 12;
				} else if(targetBaseEntered.equals("13")) {
					targetBase = 13;
				} else if(targetBaseEntered.equals("14")) {
					targetBase = 14;
				} else if(targetBaseEntered.equals("15")) {
					targetBase = 15;
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
				} else if(originalBase == 3) {
					equivalentValue = ThreeAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 4) {
					equivalentValue = FourAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 5) {
					equivalentValue = FiveAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 6) {
					equivalentValue = SixAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 7) {
					equivalentValue = SevenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 8) {
					equivalentValue = EightAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 9) {
					equivalentValue = NineAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 10) {
					equivalentValue = TenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 11) {
					equivalentValue = ElevenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 12) {
					equivalentValue = TwelveAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 13) {
					equivalentValue = ThirteenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 14) {
					equivalentValue = FourteenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 15) {
					equivalentValue = FifteenAllowed.indexOf(originalValue.substring(i, i+1));
				} else if(originalBase == 16) {
					equivalentValue = SixteenAllowed.indexOf(originalValue.substring(i, i+1));
				} else { //This shouldn't be reached
					System.out.println("ERROR");
				}
				valueInBaseTen = valueInBaseTen + (int)(equivalentValue * Math.pow(originalBase, originalValue.length() - i - 1));
			}
			
			//Now we have originalValue in base-10. Now convert to other bases.
			int numDigits = 1;
			int nextChar = 0;
			String[] baseSet = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
			while(Math.pow(targetBase, numDigits + 1) < valueInBaseTen) { //These are designed to count the number of digits
				numDigits++;
			}
			//Now start converting the base 10 value into the base value
			if(targetBase == 10) { //I mean, we just calculated the value in base-10, so...
				targetValue = valueInBaseTen.toString();
			} else {
				for(int i = numDigits; i >= 0; i--) { //Work backwards by dealing with the highest place value first
					while(valueInBaseTen >= Math.pow(targetBase, i)) { //Find out the value that needed to be added
						nextChar++;
						valueInBaseTen -= (int)(Math.pow(targetBase, i));					
					}
					targetValue += baseSet[nextChar];
					nextChar = 0;
				}
			}
			
			//Print results
			System.out.println(originalValue + " in base " + originalBase + " is " + targetValue + " in base " + targetBase + ".");
		}
	}
}
