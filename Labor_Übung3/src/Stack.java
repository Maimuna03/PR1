
/*
 * This program checks the correctness of the brackets in an given 
 * expression by using a stack to track open brackets and ensure 
 * that they are closed correctly.
 * 
 */
public class Stack {
	
	//The variable stackPtr represents Stack Pointer. It keeps track of the current state of the stack
	public int stackPtr = 0;
	private char stack[];
	
	//Constructor initializing the stack with a fixed size
	public Stack() {		
		stack = new char[1000];
	}
	
	//Create method to add an character to the stack
	public void push(char x) {
		//Check if the stack pointer is within bounds before adding the character
		if (stackPtr < stack.length) {
			stack[stackPtr++]=x;
		} else {
			System.out.println("Der Stapel ist bereits voll ! ");
		}
	}
	
	//Crate method to remove and return the top character of the stack
	public char pop() {
		//Check if the stack is not empty before removing an character
		if (stackPtr > 0) {
			return stack[--stackPtr];
		} else {
			System.out.println("Der Stapel ist bereits leer !");
			return 0;
		}
	}

	//Create method to check if the stack is empty
	public boolean stackIsEmpty() {
		if (stackPtr == 0) {
			return true;
		} else {
			return false;
		}
	}
	
}

