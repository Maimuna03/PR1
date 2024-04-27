import java.util.*;

public class StackMain {

	/* Create method that checks if open brackets and closed brackets are matching.
	 * True means the brackets are matching, false means they are not.
	 */
	public static boolean checkMatchingBrackets(char openBracket, char closedBracket) {
		if (openBracket == '(' && closedBracket == ')') {
			return true;
		} else if (openBracket == '[' && closedBracket == ']') {
			return true;
		} else if (openBracket == '{' && closedBracket == '}') {
			return true;
		} else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		
		// Create new object of the class Stack
		Stack myStack = new Stack();
//		myStack.push('a');
//		myStack.push('b');
//		myStack.push('c');
//		
//
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
//		System.out.println(myStack.pop());
		
		//Create new Scanner
		Scanner userInput = new Scanner(System.in);
		
		//User information to type user input
		System.out.print("Geben Sie hier den zu überprüfenden Ausdruck ein: ");
		
		//expr = expression, variable refers to the user input
		String expr = userInput.nextLine();
		
		//Create variable to check if the brackets of the expression are right 
		boolean exprIsRight = true;
		
		/*Create loop to go through every character of the user input (expression)
		 * If an open bracket is found, it is pushed on to the stack.
		 * If an closed bracket is found, check if the stack is not empty and if it matches the latest open bracket
		 */
		for (int i = 0; i < expr.length(); i++) {
            char currentChar = expr.charAt(i);

            if (currentChar == '(' || currentChar == '[' || currentChar == '{') {
                myStack.push(currentChar);
            } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') {
                if (!myStack.stackIsEmpty() && checkMatchingBrackets(myStack.pop(), currentChar)) {
                    continue;
                } else {
                    exprIsRight = false;
                    break;
                }
            }
        }

		//Check if the brackets in the user expression are right and if the stack is empty
        if (exprIsRight && myStack.stackIsEmpty()) {
            System.out.println("Die Klammern im Ausdruck sind korrekt.");
        } else {
            System.out.println("Die Klammern im Ausdruck sind ungültig.");
        }

        //Close scanner
        userInput.close();
		
	}
}
