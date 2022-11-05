//*******************************************************************
// Name: Eric Lin
// Course: CS114-011
// Assignment: Homework 3 - Stacks
// Due Date: 10-10-2022
// Brief: This program implements a post fix calculator through
// two functions: evalSimpleExp and evalExp.
//*******************************************************************

package lists114;
import lists114.stack.AStack;

public class PostfixCalc {
	
    // Function to evaluate a given postfix expression,
	// if the expression cannot be evaluated, return null.
	// Simple expressions:"25*" is evaluated to 10
    public Integer evalSimpleExp(String exp)
    {
    	// empty exp
        if (exp == null || exp.length() == 2)
        {
            return null;
        }
    	 // create an empty stack
        AStack<Integer> s = new AStack<Integer>(exp.length());
        
        int temp = 0;
        int a, b = 0;

        // traverse the given expression
        for (char c: exp.toCharArray())
        {
        	if(Character.isDigit(c))
            {
                s.push(Character.getNumericValue(c));
            }
            else if(c == '+' && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b + a;
                s.push(temp);
            }
            else if(c == '-' && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b - a;
                s.push(temp);
            }
            else if(c == '*' && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b * a;
                s.push(temp);
            }
            else if(c == '/' && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b / a;
                s.push(temp);
            }
        }
 
        // At this point, the stack contains the final expression result
        if (s.length() == 1) 
        	return s.pop();
        else
        	return null;
    }
    
    // Function to evaluate a given postfix expression, 
   	// if the expression cannot be evaluated, return null.
    // Advance version: "45 3 + 12 /" evaluates to 4 
    public Integer evalExp(String exp)
    {
    	// empty exp
        if (exp == null || exp.length() == 0)
        {
            return null;
        }
        // create an empty stack
        AStack<Integer> s = new AStack<Integer>(exp.length());

        int temp = 0;
        int a = 0;
        int b = 0;

        String tokens[] = exp.split(" ");

        for(String i : tokens)
        {
            if(tryInteger(i) != null)
            {
                s.push(tryInteger(i));
            }
            else if(i.equals("+") && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b + a;
                s.push(temp);
            }
            else if(i.equals("-") && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b - a;
                s.push(temp);
            }
            else if(i.equals("*") && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b * a;
                s.push(temp);
            }
            else if(i.equals("/") && s.length() >= 2)
            {
                a = s.pop();
                b = s.pop();
                temp = b / a;
                s.push(temp);
            }
        }

        // At this point, the stack contains the final expression result

        if (s.length() == 1) 
        	return s.pop();
        else
        	return null;
    }
    
    // tryInteger takes an Input string and returns it as an integer. 
    // If this is not possible, returns null.
    // In example "546" is 546 and "-54" is -54.
    public Integer tryInteger(String str){
        if (str != null && str.matches("-?[0-9]+")) 
        	return Integer.valueOf(str);
        else return null;
    }

}
