
public class Stack_number_two {
	public Message[] stack;
	public int top;
	public int sizeofmessage;

	/**
	 * 
	 * @param sizeofMessage, zero is not a size for stack
	 * @postcondition sizeofMessage >= 0 
	 */
	public Stack_number_two(int sizeofMessage) {
		assert sizeofmessage >= 0: "the size can not be negative";
		this.sizeofmessage = sizeofMessage;
		this.top = 0;
		stack = new Message[sizeofMessage];
	}

	/**
	 * 
	 * @return Non-Negative Integer
	 * @postcondition size() >= 0
	 */
	public int size() {
		assert (top) >= 0 : "Postcondition failed, size is negative?";
		return sizeofmessage;
	}

	/**
	 * 
	 * @param message the message that would be pushed
	 * @postcondition message != null
	 */

	public void push(Message message) {
		assert message != null : "post codition, a null message can not be pushed";
		if (top == stack.length) {
			stack = Double_The_stack();
		}
		top++;
		stack[top] = message;
	}

	/**
	 * 
	 * @return Doubles the length of the stack.
	 * @precondition size() != 0
	 * @postcondition double_Stack.length >= 2
	 */
	public Message[] Double_The_stack() {
		assert size() != 0 : "Precondition 'Size() != 0' failed, can not double an array with length 0";

		Message[] double_Stack = new Message[stack.length * 2];

		for (int i = 0; i < stack.length; i++) {
			double_Stack[i] = stack[i];
		}
		assert double_Stack.length >= 2 : "Postcondition failed";
		return double_Stack;
	}

	
	/**
	 * Pops the item on the top of the stack and returns it.
	 * 
	 * @precondition size() != 0
	 * @precondition stack[top] != null
	 */
	public Message pop() {
		assert size() != 0 : "Precondition 'size() != 0' failed, can't remove from empty stack";
		Message temp = stack[top];
		stack[top] = null;
		top--;
		assert stack[top] != null : "Postcondition failed, element is null";
		return temp;

	}

	/**
	 * 
	 * @param data
	 * @param n
	 * @postcondition n !=0
	 */
	public void push_more_element(Message[] data, int n) {
		assert n !=0 : "the nummber of message is zero";
		if (top == stack.length - 1) {
			stack = Double_The_stack();
		} else {
			for (int i = 0; i < n; i++) {
				
				push(data[i]);
			}

		}

	}
	
	/**
	 * 
	 * @param n
	 * @precondition n !=0
	 */
	public void pop_more_element(int n) {
		assert n != 0 : "Precondition 'n != 0' failed, can't remove from empty stack";
		if (top == -1) {
			System.out.println("Empty stack");
		}

		for (int i = 0; i < n; i++) {
			pop();
		}
	}

	/**
	 * @precondition stack[top] != null
	 */
	public void show_top() {
		assert stack[top] == null : "Checking for an empty stack";

		System.out.println("\nThe top of the stack is:" + stack[top]);

		for (int i = 0; i < stack.length; i++) {
			if (stack[i] != null) {
				System.out.println("All elements in stack : " + "[" + i + "]" + " = " + stack[i]);
			}
		}

	}

	public static void main(String[] args) {
		Stack_number_two s = new Stack_number_two(10);
		Message m1 = new Message("One");
		Message m2 = new Message("two");
		Message m3 = new Message("three");
		Message m4 = new Message("four");
		System.out.println("Pushing messages one by one");
		s.push(m1);
		s.push(m2);
		s.push(m3);
		s.push(m4);
		s.show_top();
		System.out.println("\nPoping one by one");
		System.out.println("The poped element: " + s.pop());
		System.out.println("The poped element: " + s.pop());
		System.out.println("The poped element: " + s.pop());
		s.show_top();
		
		System.out.println("Pushing an array");
		
		Message mm1 = new Message("message one");
		Message mm2 = new Message("message two");
		Message mm3 = new Message("message three");
		
		Message [] message = {mm1 , mm2, mm3};
		
		s.push_more_element(message, 2);
		s.show_top();
		System.out.println("Pop more elements");
		s.pop_more_element(2);
		s.show_top();
	}

}
