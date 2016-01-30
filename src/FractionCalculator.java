import java.util.*;

public class FractionCalculator 
{
	/*
	Rohan Raval
	Description: This program adds, subtracts, multiplies or divides fraction or whole numbers 
	based on user input, then simplifies and displays it.
	 */


	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String frac1, frac2, answer, finalAns;
		int operation, num1, num2, den1, den2;
				
		do
		{
			System.out.println("\nPlease choose from the following options:\n\n" + 
										"1.add\n" +
										"2.subtract\n" +
										"3.multiply\n" +
										"4.divide\n\n" + 
										"0.exit\n");
			operation = input.nextInt();
			if(operation >= 1 && operation <= 4)
			{
				frac1 = getFraction(input, "first");
				frac2 = getFraction(input, "second");
				num1 = getNumerator(frac1);
				den1 = getDenominator(frac1);
				num2 = getNumerator(frac2);
				den2 = getDenominator(frac2);
		
				if(operation == 1)
					answer = add(num1, num2, den1, den2);
				else if(operation == 2)
					answer = subtract(num1, num2, den1, den2);
				else if(operation == 3)
					answer = multiply(num1, num2, den1, den2);
				else
					answer = divide(num1, num2, den1, den2);
				
				finalAns = simplify(answer, input);
				if(finalAns.contains("/"))
				{
					System.out.println("\nWould you like to convert the answer to a decimal?" +
											"\n1. Yes" +
											"\n2. No");
					if(input.nextInt() == 1)
						finalAns = convertToDecimal(finalAns);
				}
				
				display(frac1, frac2, operation, finalAns);
			}
			else if(operation == 0)
				System.exit(0);
			else
				System.out.println("This is not a recognized operation. Please re-enter.");
		}while(repeat());
	}	
	
	
	/*_______________________________________________________________________________
	method:			getFraction
	description:	This method receives the scanner, asks for the user to input a fraction,
					stores as a string and returns it.
	pre-condition:	java.util.* should be imported as well as a scanner received.
	postcondition:	String f(the user's input) will be returned.
	_______________________________________________________________________________
	*/
	public static String getFraction(Scanner input, String x)
	{
		String f;
		System.out.println("\nPlease enter the " + x + " fraction.");
		f = input.next();	
		
		return f;
	}
		
	/*_______________________________________________________________________________
	method:			getNumerator
	description:	This method receives the user input(String f), determines whether it
						is a fraction, and parses and returns the numerator as int n.
	pre-condition:	String f (the user input) should be received.
	postcondition:	Int n(the parsed numerator of the user's input) will be returned.
	_______________________________________________________________________________
	*/
	public static int getNumerator(String f)
	{
		int n;
		if(f.contains("/"))
			n = Integer.parseInt(f.substring(0, f.indexOf("/")));
		else
			n = Integer.parseInt(f);
		return n;
	}
	
	/*_______________________________________________________________________________
	method:			getDenominator
	description:	This method receives the user input(String f), determines whether it
						is a fraction, and parses and returns the denominator as int d.
	pre-condition:	String f (the user input) should be received.
	postcondition:	Int d(the parsed denominator of the user's input) will be returned.
	_______________________________________________________________________________
	*/
	public static int getDenominator(String f)
	{
		int d;
		if(f.contains("/"))
			d = Integer.parseInt(f.substring(f.indexOf("/") + 1));
		else
			d = 1;
		return d;
	}	
	
	/*_______________________________________________________________________________
	method:			add
	description:	This method receives the numerators and denominators of both fractions
						adds them up, and returns as a string.
	pre-condition:	Ints num1, num2, den1, and den2 should be received.
	postcondition:	A string containing the sum of the user's fractions will be returned.
	_______________________________________________________________________________
	*/
	public static String add(int num1, int num2, int den1, int den2)
	{
		int sumNum, sumDen;

		sumDen = den1 * den2;
		sumNum = (num1 * den2) + (num2 * den1);
		
		return sumNum + "/" + sumDen;
	}
	
	/*_______________________________________________________________________________
	method:			subtract
	description:	This method receives the numerators and denominators of both fractions
						subtracts them, and returns as a string.
	pre-condition:	Ints num1, num2, den1, and den2 should be received.
	postcondition:	A string containing the subtracted result of the user's fractions will be returned.
	_______________________________________________________________________________
	*/
	public static String subtract(int num1, int num2, int den1, int den2)
	{
		int sumNum, sumDen;
	
		sumDen = den1 * den2;
		sumNum = (num1 * den2) - (num2 * den1);
		
		return sumNum + "/" + sumDen;
	}
	
	/*_______________________________________________________________________________
	method:			multiply
	description:	This method receives the numerators and denominators of both fractions
						multiplies them, and returns as a string.
	pre-condition:	Ints num1, num2, den1, and den2 should be received.
	postcondition:	A string containing the products of the user's fractions will be returned.
	_______________________________________________________________________________
	*/
	public static String multiply(int num1, int num2, int den1, int den2)
	{
		int productnum, productden;
		
		productden = den1 * den2;
		productnum = num1 * num2;
		
		return productnum + "/" + productden;
		
	}
	
	/*_______________________________________________________________________________
	method:			divide
	description:	This method receives the numerators and denominators of both fractions
						divides them, and returns as a string.
	pre-condition:	Ints num1, num2, den1, and den2 should be received.
	postcondition:	A string containing the quotient of the user's fractions will be returned.
	_______________________________________________________________________________
	*/
	public static String divide(int num1, int num2, int den1, int den2)
	{
		int productnum, productden;
	
		productden = den1 * num2;
		productnum = num1 * den2;
		
		return productnum + "/" + productden;
	}
	
	/*_______________________________________________________________________________
	method:			simplify
	description:	This method receives the answer as a string, parses the numerator and
						denominator, then reduces the fraction to simplest form(if possible).
						Then it returns the reduced answer as string finalAns.
	pre-condition:	String answer should be received.
	postcondition:	A string, finalAns, containing the simplified answer will be returned.
	_______________________________________________________________________________
	*/
	public static String simplify(String answer, Scanner awesome)
	{
		int numAns, denAns;
		int gcf = 1;
		String finalAns = "";
		
		numAns = Integer.parseInt(answer.substring(0, answer.indexOf("/")));
		denAns = Integer.parseInt(answer.substring(answer.indexOf("/") + 1));
		
		if(denAns == 1)
			finalAns = numAns + "";
		else if(denAns == 0)
			finalAns = "undefined";
		else if(numAns == 0)
			finalAns = "0";
		else if(numAns == denAns)
 			finalAns = "1"; 
		else if(denAns > numAns)
		{
			for (int i = Math.abs(numAns); i > 0; i--)
			{
				if (numAns % i == 0 && denAns % i == 0)
				{
					gcf = i;
					finalAns = (numAns/gcf) + "/" + (denAns/gcf);
					denAns=denAns/gcf;
					numAns=numAns/gcf;
					i = 0;
				}
				else
					finalAns = numAns + "/" + denAns;
			}
		}
		else
		{
			for (int i = Math.abs(denAns); i > 0; i--)
			{
				if (denAns % i == 0 && numAns % i == 0)
				{
					gcf = i;
					finalAns = (numAns/gcf) + "/" + (denAns/gcf);
					denAns=denAns/gcf;
					numAns=numAns/gcf;
					i = 0;
				}		
				else
					finalAns = numAns + "/" + denAns;			
			}
		}
		if(denAns == 1)
			finalAns = numAns + "";
		else if (denAns < 0)
			finalAns = (numAns * -1) + "/" + Math.abs(denAns);

		return finalAns;
	}
	
	/*_______________________________________________________________________________
	method:			convertToDecimal
	description:	This method converts the fraction finalAns to a decimal by 
						parsing and dividing the num and den of finalAns.
	pre-condition:	String finalAns must be received.
	postcondition:	String convertedAns will return the converted answer.
	_______________________________________________________________________________
	*/
	public static String convertToDecimal(String finalAns)
	{
		int numFinalAns = Integer.parseInt(finalAns.substring(0, finalAns.indexOf("/")));
		int denFinalAns = Integer.parseInt(finalAns.substring(finalAns.indexOf("/") + 1));
	
		String convertedAns = ((numFinalAns + 0.0) / denFinalAns) + "";
		return convertedAns;

	}
	
	/*_______________________________________________________________________________
	method:			display
	description:	This method receives the strings of the user's input, the operation
						performed on them, and the final answer, determines the operation sign, and diplays.
	pre-condition:	Strings frac1, frac2, finalAns, and int operation must be received.
	postcondition:	An echoed answer will be displayed.
	_______________________________________________________________________________
	*/
	public static void display(String frac1, String frac2, int operation, String finalAns)
	{
		String sign = "";	
		
		switch(operation)
		{
		case 1:	sign = "+";
					break;
		case 2:	sign = "-";
					break;
		case 3:	sign = "*";
					break;
		default:	sign = "÷";
		}
		System.out.println("\n" + frac1 + " " + sign + " " + frac2 + " = " + finalAns);
	}
		
	/*____________________________________________________________________________________________
	method:				repeat
	description:			This method prompts the user if they want to repeat the program or not. 
								It then checks whether or not the user's selection, int choice, is valid.
	pre-condition:		java.util.* is imported in order to get user input.
	postcondition:		It will return choice and repeat method according to its value.
	____________________________________________________________________________________________
	*/
	public static boolean repeat()
	{
		int choice;
		Scanner keyboard = new Scanner(System.in);

		do
		{	
			System.out.println("\nDo you wish to repeat this program? \n" + 
									"1. Yes \n" +
									"2. No");
			choice = keyboard.nextInt();
			if (choice < 1 || choice > 2)
				System.out.println(choice + " is an invalid selection.\n");								
		}while (choice < 1 || choice > 2);
		
		return choice==1;
	}
}

