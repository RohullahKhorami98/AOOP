import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackTest {
	Stack stack;
	
	@Test
	void testPushPop() {
		Stack stack = new Stack();
		assertNotEquals(null,stack);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.push(7);
				
		assertEquals(7,stack.pop());
		assertEquals(6,stack.pop());
		assertEquals(5,stack.pop());
		assertEquals(4,stack.pop());
		assertEquals(3,stack.pop());
		assertEquals(2,stack.pop());
		assertEquals(1,stack.pop());

		//check if stack is empty
		assertEquals(0,stack.pop());
	}
	
	@Test
	void testMultiplePushPop() {
		Stack stack = new Stack();
		
		int[] d = new int[] {1,2,3};
		stack.push_more_element(d);
		
		d = new int[] {4,5,6,7,8,9,10};	
		stack.push_more_element(d);

		assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0},stack.stack);
		
		int[] o = stack.pop_more_element(4);
		assertArrayEquals(new int[] {10, 9, 8, 7}, o);

		o = stack.pop_more_element(6);
		assertArrayEquals(new int[] {6, 5 ,4 , 3, 2, 1}, o);
		
		assertEquals(null,stack.pop_more_element(1));
	}
}

