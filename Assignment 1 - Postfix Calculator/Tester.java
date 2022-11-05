package lists114;

public class Tester {
	public static void main(String[] args) {
		
		System.out.println("Homework 3 - Stacks");
		
	
		// Test cases for simple Postfix expressions
		PostfixCalc c = new PostfixCalc();
	
		String[] simpletestCases = new String[]
				{"23*5+",
						"17-2/13+*", 
						"922/", 
						"5*",
						"10+",
						"45/",
						"345*-",
						"67-",
						"64+53-/",
						"9"};
		
		for (String str: simpletestCases) {
		
			System.out.print(str + " is ");
			System.out.println(c.evalSimpleExp(str));
		}
		System.out.println();
		
		// Test cases for advanced Postfix expressions
		String[] advtestCases = new String[]
				{"*", 
					"8",
					"45 3 + 12 /", 
					"2 10 * 8 2 / / ",
					"1 2 +",
					"10 20 /",
					"2 10 * 8 2 / /",
					"6 3 4 + * 5 +",
					"4 10 - -2 / 1 6 - *",
					"-2 6 * 3 /",
					"9",};
		
		for (String str: advtestCases) {
		
			System.out.print(str + " is ");
			System.out.println(c.evalExp(str));
		}
	}
	
}