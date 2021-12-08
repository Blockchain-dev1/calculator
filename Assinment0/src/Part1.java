
import java.util.Scanner;

public class Part1 
{	
	public static void main(String args[])
	{
		// Call the cycle method, which will continue prompting user for input and solving equations
		// The 0 is passed because there was no previous answer
		// The true value is passed for FirstTime boolean, which checks if cycler has run before
		
		Cycler(0, true);
	}
	
	// This method calls all other methods, and restarts itself when done	
	public static void Cycler(double PreviousAns, boolean FirstTime)
	{
		// If cycler has run before
		if (!FirstTime)
		{
			System.out.println("\nPress 1 to continue with same number");
			System.out.println("Press 2 restart");
			System.out.println("Press 3 to exit");
				
			Scanner input = new Scanner(System.in);
			
			// Ask for input and check
			switch(input.nextInt())
			{
				case 1:
					// Nothing needs to be done, the previous answer has already been passed
					break;
				case 2:
					// Reset previous answer
					PreviousAns = 0;
					break;
				case 3:
					// Exit to main menu
					// For now
					System.exit(0);
					break;
				default:
					// Input Error
					System.out.println("\nInput error:\nInvlalid input\n");
					Cycler(PreviousAns, false);
					break;
			}
		}
		
		// Scan user input and put it into a string array
		String[] Equation = ReadInput(PreviousAns);
				
		// Do main calculation, by calling the Solver method
		double Answer = Solver(Equation);
				
		// A quick check whether the answer is a whole number.
		// This is done so e.g. 2 + 2 would return 4, not 4.00
		if (Answer == Math.floor(Answer))
		{
			System.out.println("The answer is: " + (int) Math.floor(Answer));
		}
		else
		{
			System.out.println("The answer is: " + Answer);
		}
		
		// Cycler calls itself again, thus the name
		Cycler(Answer, false);
	}
	
	// Scan user input and put it into a string array
	public static String[] ReadInput(double PreviousAns)
	{
		
		// Take user input
		Scanner input = new Scanner(System.in);
		System.out.println("\nInput your operation to be calculated");
		System.out.println("Please maintain spaces between all elements");
		
		// If a previous answer was selected, or it was equal to 0, in which case we treat it as if it wasn't selected
		if (PreviousAns != 0)
		{
			// Just like in Cycler, check if we can floor the previous answer without losing value
			if (PreviousAns == Math.floor(PreviousAns))
			{
				System.out.print(Integer.toString((int)Math.floor(PreviousAns)));
			}
			else
			{
				System.out.print(PreviousAns);
			}
		}
		
		// Take the whole input
		String FullLine = input.nextLine(); // "2 + 2"
		
		// Check whether blank
		if (FullLine.isBlank())
		{
			System.out.println("\nInput error:\nNo input detected");
			Cycler(PreviousAns, true);
		}	
		
		// Split it into small strings by spaces, e.g. 2 + 2 becomes {2,+,2}
		FullLine.trim();
		String[] Equation = FullLine.split(" ");
		
		
		// The following code puts the whole equation into another pair of parentheses
		// This is done because SolveParenth breaks otherwise, TODO fix
		String[] EqOutput = new String[1000];
		EqOutput[0] = "(";
		EqOutput[Equation.length+1] = ")";
		
		// If we have an answer to put as the first element, do so
		if (PreviousAns != 0)
		{
			EqOutput[1] = Double.toString(PreviousAns);
			for (int i = 1; i < Equation.length; i++)
			{
				EqOutput[i+1] = Equation[i];
			}
		}
		else
		{
			for (int i = 0; i < Equation.length; i++)
			{
				EqOutput[i+1] = Equation[i];
			}
		}
		
		// Check for errors
		ErrorCheck(EqOutput, PreviousAns);
		
		return EqOutput;
	}
	
	// This method looks for errors in user input and calls Cycler again if found
	public static void ErrorCheck(String[] Equation, double PreviousAns)
	{
		boolean LastWasNumber = false;
		// Check if first element in equation is an operator
		switch (Equation[1])
		{
			case "*":
			case "/":
			case "+":
			case "-":
			case "^":
				System.out.println("\nInput error:\nAn equation cannot start with an operator");
				Cycler(PreviousAns, true);
				break;
		}
		
		// Go through the entire equation
		for (int i = 1; i < Equation.length; i++)
		{
			// Stop if end found
			if (Equation[i] == null)
			{
				break;
			}
			
			boolean IsNumber = false;
			boolean IsOperator = false;
			
			// Call IsElementDigit method and return answer into boolean IsNumber
			IsNumber = IsElementNumber(Equation[i]);
			
			if (IsNumber == true)
			{
				// If two number, separated by a space found in a row
				if (LastWasNumber == true)
				{
					System.out.println("\nInput error:\nTwo numbers in a row");
					Cycler(PreviousAns, true);
				}
				LastWasNumber = true;
			}
			
			switch (Equation[i])
			{
				case "*":
				case "/":
				case "+":
				case "-":
				case "^":
				case "%":
					IsOperator = true;
					// If two operators, separated by a space found in a row
					if (!LastWasNumber)
					{
						System.out.println("\nInput error:\nTwo operators in a row");
						Cycler(PreviousAns, true);
					}
					LastWasNumber = false;
					break;
				case "sqrt":
				case "cbrt":
				case "(":
				case ")":
					IsOperator = true;	
					break;
			}
			
			// An number is neither number nor operator
			if (!IsNumber && !IsOperator && Equation[i] != null)
			{
				System.out.println("\nInput error:\nInvalid element found: " + Equation[i]);
				Cycler(PreviousAns, true);
			}
			else if (IsNumber == true && IsOperator == true)
			{
				System.out.println("\\nInput error:\\nBug in error catching");
			}
		}
		
		// Last element was not a number
		if (!LastWasNumber)
		{
			System.out.println("\nInput error:\nLast element was not a number");
			Cycler(PreviousAns, true);
		}
		
	}
	
	public static boolean IsElementNumber(String Element)
	{
		if (Element == null)
		{
			return false;
		}
		
		// Element is not a number
		try 
		{
			// Throws false if cannot convert
			double number = Double.parseDouble(Element);
		} 
		catch (NumberFormatException nfe) 
		{
			return false;
		}
		
		// Element is a number
		return true;
	}
	
	// This is separated from main for use in recursion, only calls other methods
	public static Double Solver(String[] Equation)
	{
		// Check for parentheses and solve them if found, return equation without them
		Equation = SolveParenth(Equation);
		// Perform exponent solving
		Equation = PowRoot(Equation);
		// Perform multiplication and division, and check for parentheses
		Equation = MultiDiv(Equation);
		// Perform addition and subtraction, return the finished answer
		double Answer = AddSubtr(Equation);
		return Answer;
	}    
	
	// Separates each set of parentheses as its own equation and solves them
	public static String[] SolveParenth(String[] Equation)
	{
		String[] EqOutput = new String[1000];
		
		// Counter to keep track of the index for output array
		int cntr = 0;
		
		// Number of Left Parentheses '('
		int LParenth = 0;
		// Number of Right Parentheses ')'
		int RParenth = 0;
		
		// Index of the first parenthesis you find
		int FirstParenth = -1;
		// Index of the last parenthesis you find
		int LastParenth = -1;
			
		int i = 0;
		
		do
		{
			switch (Equation[i])
			{
			case "(":
				// Should only run once per pair of parentheses
				if (LParenth == 0)
				{
					FirstParenth = i;
				}
				LParenth++;
				break;
			case ")":
				LastParenth = i;
				RParenth++;
				break;
			}
			// Stops if a full set is reached, so parentheses on same level work i.e. (2+2)+(1+1), then resets and continues code above
			if (LParenth != 0 && RParenth != 0 && LParenth == RParenth)
			{
				// Reset counter
				cntr = 0;
				// Record everything between the first and last parentheses into new array
				for (int j = FirstParenth+1; j < LastParenth ; j++)
				{
					EqOutput[cntr] = Equation[j];
					cntr++;
				}
				
				// Solve the new array
				double Replacer = Solver(EqOutput);
				// Replace value at index of the first parenthesis with the solved answer
				Equation[FirstParenth] = Double.toString(Replacer); // ( 2 + 2 ) + 1 into 4 + 1
				
				
				// Move everything in array after the parentheses by their length 
				// j is one so the answer itself isn't replaced
				for (int j = 1; j <= Equation.length; j++)
				{
					// Stop if end reached
					if (Equation[FirstParenth + j] == null)
					{
						break;
					}
					// Move everything after the answer by the length of the parentheses
					Equation[FirstParenth+j] = Equation[LastParenth+j];
				}
				// Reset variables in case of another set of parentheses, cntr reset earlier
				LParenth = 0;
				RParenth = 0;
				FirstParenth = -1;
				LastParenth = -1;
				i=0;
			}
			i++;
		// Found an odd number of parentheses
		} while (Equation[i] != null);
		
		return Equation;
	}
	
	public static String[] PowRoot(String[] Equation)
	{
		// Two arrays are used, with EqOutput being identical to Equation except all * or / are executed
		String[] EqOutput = new String[1000];
				
		// Counter to keep track of the index for output array
		int cntr = 0;
					
		// First pass, power or root
		for (int i = 0; i < Equation.length; i++)
		{
			if (Equation[i] == null)
			{
				break;
			}
			switch (Equation[i])
			{
				case "^":
					double base = Double.parseDouble(EqOutput[cntr-1]);
					double power = Double.parseDouble(Equation[i+1]);

					double result = base;
						
					for( int j = 1; j < power; j++)
					{
						result = result*base;
					}
					EqOutput[cntr-1] = Double.toString(result);
					break;
				case "sqrt":
					EqOutput[cntr] = Double.toString(Math.sqrt(Double.parseDouble(Equation[i+1])));
					i++;
					cntr++;
					break;
				case "cbrt":
					EqOutput[cntr] = Double.toString(Math.cbrt(Double.parseDouble(Equation[i+1])));
					i++;
					cntr++;
					break;
			default:
				// Read values without multiplication or division and save them to the second array
				EqOutput[cntr] = Equation[i];
				cntr++;
				break;
			}
		}
		return EqOutput;
	}
	
	// Perform multiplication and division (and modulo)
	public static String[] MultiDiv(String[] Equation)
	{
		// Two arrays are used, with EqOutput being identical to Equation except all * or / are executed
		String[] EqOutput = new String[1000];
		
		// Counter to keep track of the index for output array
		int cntr = 0;
			
		// Second pass, multiplication and/or division
		for (int i = 0; i < Equation.length; i++)
		{
			if (Equation[i] == null)
			{
				break;
			}
			switch (Equation[i])
			{
			case "*":
				// When you find a multiplication or division symbol you do the operation to the numbers preceding and following it
				// You need to cast the string to an double to make math work
				double temp = Double.parseDouble(EqOutput[cntr-1]) * Double.parseDouble(Equation[i+1]);
				// And change the value of the preceding number
				EqOutput[cntr-1] = Double.toString(temp);
				i++;
				break;
			case "/":
				Double temp2 = Double.parseDouble(EqOutput[cntr-1]) / Double.parseDouble(Equation[i+1]);
				EqOutput[cntr-1] = Double.toString(temp2);
				i++;
				break;
			case "%":
				Double temp3 = Double.parseDouble(EqOutput[cntr-1]) % Double.parseDouble(Equation[i+1]);
				EqOutput[cntr-1] = Double.toString(temp3);
				i++;
				break;
			default:
				// Read values without multiplication or division and save them to the second array
				EqOutput[cntr] = Equation[i];
				cntr++;
				break;
			}
		}
		return EqOutput;
	}
	
	// Perform addition and subtraction, return the finished answer
	public static Double AddSubtr(String[] Equation)
	{
		// Third pass, division and addition
		for (int j = 0; j < Equation.length; j++)
		{
			// Check to see if you are done
			if (Equation[j] == null)
			{
				// Exit the for loop
				break;
			}
			System.out.println(Equation[j]);
		}
		Double Answer = 0.0;
		
		// Third pass, division and addition
		for (int i = 0; i < Equation.length; i++)
		{
			// Check to see if you are done
			if (Equation[i] == null)
			{
				// Exit the for loop
				break;
			}
			// Save the very first number as the beginning of your answer
			if (i == 0)
			{
				Answer = Double.parseDouble(Equation[i]);
			}
			switch (Equation[i])
			{
			case "+":
				Answer += Double.parseDouble(Equation[i+1]);
				break;
			case "-":
				Answer -= Double.parseDouble(Equation[i+1]);
				break;
			}
		}
		return Answer;
	}
}