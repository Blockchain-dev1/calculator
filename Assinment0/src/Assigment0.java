import java.util.ArrayList;
import java.util.Scanner;

public class Assigment0 {

	public static void main(String args[])

	{

		Calculator();

	}



	private static void Calculator() {
		// TODO Auto-generated method stub
		System.out.println("=================================");
		System.out.println("Welcome to the 47 calculator!");
		System.out.println("_________________________________");
		System.out.println("Please select an option:");
		System.out.println(" 1)  Basic operations");
		System.out.println(" 2)  Prime Number Checker");
		System.out.println(" 3)  Decimal To Binary");
		System.out.println(" 4)  Binary To Decimal");
		System.out.println(" 5)  Decimal to Hex");
		System.out.println(" 6)  Hex to Decimal"); // not yet done
		System.out.println(" 7)  Factorial Calculator");
		System.out.println(" 8)  Prime Number Checker");
		System.out.println(" 9)  Celsius To Fahrenheit ");
		System.out.println("10)  Fahrenheit to Celsius");
		System.out.println("11)  Oz to Gram ");
		System.out.println("12)  Grams to Gz ");
		System.out.println("13)  Inches to Cm");
		System.out.println("14)  Cm to Inches");
		System.out.println("=================================");
		System.out.println("");
		Scanner o = new Scanner(System.in);
		int option = o.nextInt();

		switch(option)
		{
		case 1: T1("1");
		break;
		case 2: T2("2");
		break;
		case 3: T3("3");
		break;
		case 4: T4("4");
		break;
		case 5: T5("5");
		break;
		case 6: T6("6"); //NOT YET DONE 
		break;
		case 7: T7("7");
		break;
		case 8: T8("8");
		break;
		case 9: T9("9");
		break;
		case 10: T10("10");
		break;
		case 11: T11("11");
		break;
		case 12: T12("12");
		break;
		case 13: T13("13");
		break;
		case 14: T14("14");
		break;
		default :
			if ( 1> 0)
			{
				System.out.println(""); 
				System.out.println("Invalid input please select a valid choice");  
				Calculator();

			}
		}
	}



	private static void T1(String Cycler) {
		// TODO Auto-generated method stub
	     return;
	}




	private static void T14(String string) {
		// TODO Auto-generated method stub
		double one_cm = 0.393701;
		double length_in_cm = 0;
		Scanner LenInches = new Scanner(System.in);
		System.out.println("Enter length in inches");
		double Inches = LenInches.nextInt();
		System.out.println("blah" + Inches);
		length_in_cm = (Inches/one_cm);
		System.out.println("Length in centimetres is " + length_in_cm +"cm.");
		System.out.println();
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method,");
		System.out.println(" 2) Inches to Cm");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = LenInches.nextInt();;
		switch(q) {
		case 1:T14("1");
		break;
		case 2:T13("2");
		break;
		default:
			Calculator();
		
		}
	}


	private static void T13(String string) {
		// TODO Auto-generated method stub
		double one_inch = 2.54;
		double length_in_inch = 0;
		Scanner LenInCm = new Scanner(System.in);
		System.out.println("Enter length in cm");
		double num_cm= LenInCm.nextInt();

		length_in_inch = (num_cm/one_inch);
		System.out.println("Length in inches is " + length_in_inch +" inches.");
		System.out.println();
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method,");
		System.out.println(" 2) Cm to inches");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = LenInCm.nextInt();;
		switch(q) {
		case 1:T13("1");
		break;
		case 2:T14("2");
		break;
		default:
			Calculator();
		}
	}


	private static void T12(String string) {
		// TODO Auto-generated method stub
		double one_ounce = 28.3495;
		Scanner inputMass = new Scanner(System.in);
		System.out.println("Enter weight in grams");
		double Grams = inputMass.nextDouble();
		System.out.println("Weight in ounces is" + (Grams/one_ounce));
		System.out.println();
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method,");
		System.out.println(" 2) Ounces to grams");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = inputMass.nextInt();;
		switch(q) {
		case 1:T12("1");
		break;
		case 2:T11("2");
		break;
		default:
			Calculator();
		}
	}



	private static void T11(String string) {
		// TODO Auto-generated method stub
		double one_gram = 0.035274;
		Scanner inputMass = new Scanner(System.in);
		System.out.println("Enter weight in ounces");
		double Ounces = inputMass.nextDouble();
		System.out.println("Weight in grams is:" + (Ounces/one_gram));
		int F = 0 ;
		int C =0;
		System.out.println(F + " degree Fahrenheit is equal to " + C + " degree Celsius.");
		System.out.println();
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method,");
		System.out.println(" 2) Grams to Ounces");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = inputMass.nextInt();;
		switch(q) {
		case 1:T11("1");
		break;
		case 2:T12("2");
		break;
		default:
			Calculator();
		}

	}


	private static void T10(String string) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); // here we are importing a scanner 

		// here we are asking the user to put in the input which thye would like to convert 
		System.out.print("Enter temperature in Fahrenheit: ");
		float F = in.nextFloat(); // this will be stored as f for Fahrenheit

		// this is the formula for converstion which i found online
		double C = (F - 32) / 1.8;


		// this is simply asking it to print it out
		System.out.println(F + " degree Fahrenheit is equal to " + C + " degree Celsius.");
		System.out.println("");
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method,");
		System.out.println(" 2) Celsius to Fahrenheiet");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = in.nextInt();;
		switch(q) {
		case 1:T10("1");
		break;
		case 2:T9("2");
		break;
		default:
			Calculator();
		}
	}



	private static void T9(String string) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		/* This code is asking you to enter temperature in Celsius from user and is being stored in C ( for Celcsius) */
		System.out.print("Enter temperature in Celsius: ");
		float C = in.nextFloat();

		/* Convert Celsius to Fahrenheit as the formula for this is F = C * (9/5) + 32*/
		double F = C * 1.8 + 32;

		/* Print result after the above equation is done  */
		System.out.println(C + " degree Celsius is equal to " + F +" degree Fahrenheit.");
		System.out.println("");
		System.out.println("=================================");
		System.out.println(" Please chose");
		System.out.println(" 1) For the same method");
		System.out.println(" 2) Fahrenheit to Celsius");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = in.nextInt();;
		switch(q) {
		case 1:T9("1");
		break;
		case 2:T10("2");
		break;
		default:
			Calculator();
		}
	}



	private static void T6(String string) {                                                                                                 // HEX to dec
		// TODO Auto-generated method stub
		
			Scanner HexIn = new Scanner(System.in); //Input hex num
			System.out.println("Enter hexadecimal num");
			String HexaInput = HexIn.nextLine();	
			String hex = "0123456789ABCDEF"; //String with every possible Hexadecimal Character
			int decimal = 0; //To store the result
			for (int i = 0; i < HexaInput.length(); i++) //Runs the loop until i is greater than the length of the input so it works for more than just 2 digit hex numbers
			{
			char ch = HexaInput.charAt(i); //Reads the characters from right to left
			
			int in= hex.indexOf(ch); //Gets the position of the char in the string hex e.g. A would be in the 10th position
			decimal = 16*decimal + in; //Adds the result 
			
			}
			System.out.println("The decimal equivalent of " + HexaInput + " is: "+decimal);
			System.out.print("");
			System.out.println("=================================");
			System.out.println(" Please chose");
			System.out.println(" 1) For the same method");
			System.out.println(" 2) Decimal to Hex");
			System.out.println(" 3) Differnt method");
			System.out.println("=================================");
			int q = HexIn.nextInt();;
			switch(q) {
			case 1:T6("1");
			break;
			case 2:T5("2");
			break;
			default:
				Calculator();
	}
	
	}

	private static void T8(String string) {                                                                                                 //prime number Checker 
		// TODO Auto-generated method stub
		/*Every prime number except 2 is odd
		 A prime number can only be divided by itself and 1
		 To check this we can divide the number by every number up until itself.
		 If the mod of this number returns 0 for any number other than itself or 1, it is not prime.
		 */
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter a number to check if it is a prime number");
		int isPrime = scan1.nextInt();
		int i;
		boolean temp = false;
		if (isPrime==0||isPrime==1){  
			System.out.println(isPrime +" is not prime number");
		}
		else {
			for (i=2; i<=isPrime/2; i++) { //isPrime is being divided by 2 because no number is divisible by more than its half.
				if (isPrime%i == 0) {
					temp = true;
					break;
				}
			}
			if (temp=true) {
				System.out.println(isPrime + " is a prime number");
			}
			else {
				System.out.println(isPrime + " is not a prime number");
			}
			System.out.println("");
			System.out.println("=================================");
			System.out.println(" Please chose");
			System.out.println("1) Same method ");
			System.out.println("2) Differnt method ");
			System.out.println("=================================");
			int q = scan1.nextInt();;
			switch(q) {
			case 1:T8("1");
			break;
			default:
				Calculator();
			}
		}
	}

	private static void T7(String string) {                                                                                                             //Factorial calculator
		// TODO Auto-generated method stub 
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to find factorial of");
		int Factorial = scan.nextInt();
		int result = 1;
		int i;
		for (i=1; i<=Factorial; i++) {
			result =+ (result * i);
		}
		System.out.println("The result is " + result);
		System.out.println("");
		System.out.println("=================================");
		System.out.println(" Please chose ");
		System.out.println("1) For the same method ");
		System.out.println("2) Differnt method");
		System.out.println("=================================");
		int q = scan.nextInt();;
		switch(q) {
		case 1:T7("1");
		break;
		default:
			Calculator();
		}
	}

	private static void T5(String string) {                                                                                                              //Decimal to hex
		// TODO Auto-generated method stub
		char Hex_Characters[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		System.out.println("Enter the base 10 number");
		Scanner Dec_Input = new Scanner(System.in);
		int Decimal_Input = Dec_Input.nextInt();

		while (Decimal_Input>0) //Runs as long as input greater than 0
		{
			if (Decimal_Input < 0) {
				System.out.println("Invalid input");
				break;

			}
			else {
				System.out.print("Hex number is");
			}

			int temp = 0;
			String Hex = "" ; //Empty string
			while (Decimal_Input != 0) { //Eventually will reach 0 as Decimal_Input is being updated in the loop
				temp = Decimal_Input % 16; //Temp becomes the remainder of decimal input divided by 16, which should always be between 0-15
				Decimal_Input/=16; //Dividing input by 16
				Hex = Hex_Characters[temp] + Hex; //Adding the value of Hex_Characters[temp] to the empty string Hex.
			}
			System.out.println(" " + Hex); //Printing
			int q;
			System.out.println("");
			System.out.println("=================================");
			System.out.println("Please chose");
			System.out.println("1) Same method ");
			System.out.println("2) Hex to Decimal");
			System.out.println("3) Differnt method");
			System.out.println("=================================");


			q = Dec_Input.nextInt();;
			switch(q) {
			case 1:T5("1");
			break;
			case 2:T6("2");
			break;
			default:
				Calculator();
			}
		}

	}

	private static void T4(String string) {                                                                                                                   //Binary to decimal
		// TODO Auto-generated method stub
		Scanner Number = new Scanner(System.in); // I am using this code to call the scanner 
		long binaryNumber, decimalNumber = 0, D = 1, remainder; // im using this code putting the variables 
		System.out.print("Input a binary number: "); // here asking 4 input
		binaryNumber = Number.nextLong();//Stored here

		while (binaryNumber != 0) // pushing it into the while loop
		{
			remainder = binaryNumber % 10;
			decimalNumber = decimalNumber + remainder * D; // this is the formula i found online
			D = D * 2; 
			binaryNumber = binaryNumber / 10;
		}
		System.out.println("Decimal Number: " + decimalNumber);
		System.out.println();
		System.out.println("=================================");
		System.out.println(" please chose");
		System.out.println(" 1) For the same method");
		System.out.println(" 2) Decimal to Binary");
		System.out.println(" 3) Differnt method");
		System.out.println("=================================");
		int q = Number.nextInt();;
		switch(q) {
		case 1:T4("1");
		break;
		case 2:T3("2");
		break;
		default:
			Calculator();
		}
	}


	private static void T3(String string) {                                                                                                                //Decimal to Binary
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		while (true) //runs through the loop no matter what
		{

			System.out.print("Enter a decimal number"); //Takes user input
			int input = scan.nextInt(); //Stores input as int variable

			if (input < 0) { //if loop to check if input is less than 0 which would be invalid
				System.out.println("Goodbye!");
				break;
			} else { //if not 0
				System.out.print("Binary number is "); 

				int binary[] = new int[16];  // ------> stores the binary in an array, sets limit to 16 bit binary numbers
				int count = 0; //counter
				while( input != 0 ) { // While the input is not 0
					binary[count++] = input % 2;//--> this code is equivalent to: 
					input = input / 2;          //    binary[count] = input % 2;
				}                               //    count++
				for (int i = 15; i >= 0; i--) {  // printing the binary array backwards
					System.out.print(binary[i]);
				}
			}
			System.out.print("\n\n"); //to print on same line as "Binary number is" 
			System.out.println("");
			System.out.println("=================================");
			System.out.println("Please chose");
			System.out.println("1) Same method ");
			System.out.println("2) Binary to decimal");
			System.out.println("3) Differnt method");
			System.out.println("=================================");

			

			int q = scan.nextInt();;
			switch(q) {
			case 1:T3("1");
			break;
			case 2:T4("2");
			break;
			default:
				Calculator();
			}
		}





	}


	private static void T2(String string) {                                                                                                             //prime factore 
		// TODO Auto-generated method stub
		/*Every prime number except 2 is odd
		 A prime number can only be divided by itself and 1
		 To check this we can divide the number by every number up until itself.
		 If the mod of this number returns 0 for any number other than itself or 1, it is not prime.
		 */
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter a number to check if it is a prime number");
		int isPrime = scan1.nextInt();
		int i;
		boolean temp = false;
		if (isPrime==0||isPrime==1){  
			System.out.println(isPrime +" is not prime number");
		}
		else {
			for (i=2; i<=isPrime/2; i++) { //isPrime is being divided by 2 because no number is divisible by more than its half.
				if (isPrime%i == 0) {
					temp = true;
					break;
				}
			}
			if (temp=true) 
			{
				System.out.println(isPrime + " is a prime number");
			}
			else 
			{
				System.out.println(isPrime + " is not a prime number");
			}

		}
		int q;
		System.out.println("");
		System.out.println("=================================");
		System.out.println(" please chose");
		System.out.println(" 1) For the same ");
		System.out.println(" 2)Differnt method");
		System.out.println("=================================");
		q = scan1.nextInt();
		switch(q) {
		case 1:T2("1");
		break;
		default:
			Calculator();
		}


	}

}	



	