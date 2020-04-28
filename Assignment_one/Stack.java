
public class Stack {

	public int[] stack;
	public int top;

	public Stack(int size) {
		stack = new int[size];
		top = -1;
	}

	public Stack() {
		stack = new int[5];
		top = -1;
	}

	public void push(int data) {
		if (top == stack.length - 1) {
			int[] newArray = new int[stack.length * 2 + 1];
			for (int i = 0; i < stack.length; i++) {
				newArray[i] = stack[i];
			}
			stack = newArray;
		}
		top++;
		stack[top] = data;
	}

	public int pop() {
		if (top == -1) {
			System.out.println("The stack is empty");
			return 0;		
			}
		int data = stack[top];
		stack[top] = 0;
		top--;
		return data;

	}

	public int show_top() {
		return stack[top];
	}

	public void push_more_element(int[] data) {

		if (top == stack.length + data.length) {
			int[] newArray = new int[(stack.length + data.length) * 2];
			for (int i = 0; i < stack.length; i++) {
				newArray[i] = stack[i];
			}
			stack = newArray;
		}

		for (int i = 0; i < data.length; i++) {
			push(data[i]);
		}

	}

	public int[] pop_more_element(int n) {
		if (top == -1) {
			System.out.println("Empty stack");
			return null;
		}
		else {
			int[] data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = pop();
			}
			return data;
		}
	}
	
	
	public void print() {
		
		System.out.println("The top of the stack is:" + stack[top]);
		for(int i = 0; i<stack.length; i++) {
			if(stack[i] !=0) {
			System.out.println( "Elements in index" +"["+i+"]" +" = "+ stack[i]);
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Stack s = new Stack();
		System.out.println("\n------------ Pushed one by one -------------");
		s.push(1);
		s.push(2);
		s.push(3);
		s.print();
		
		System.out.println("\n------------ Pushed an array ----------------");
		s.push_more_element(new int[]{4,5,6,7,8,9,10});
		s.print();
		
		System.out.println("\n------------ Pop one by one -----------------");
		System.out.println("poped " + s.pop());
		System.out.println("poped " + s.pop());
		System.out.println("poped " + s.pop());
		System.out.println("poped " + s.pop());
		
		s.print();
		
		System.out.println("\n-------- Poped multi elements at once -------");
		s.pop_more_element(5);
		s.print();


	}
	
	
}
