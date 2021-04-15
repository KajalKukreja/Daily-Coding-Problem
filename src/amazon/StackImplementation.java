package amazon;

public class StackImplementation {

	static class Stack {
		int[] stack = new int[100000];
		int top = -1;
		int max = 0;
		
		void push(int data) {
			stack[++top] = data;
			max = Math.max(max, data);
			System.out.println("Pushed : " + data);
		}
		
		int pop() throws Exception {
			if (top == -1) {
				throw new Exception("Stack is empty!");
			}
			return stack[top--];
		}
		
		int max() throws Exception {
			if (top == -1) {
				throw new Exception("Stack is empty!");
			}
			return max;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(40);
		stack.push(30);
		System.out.println("Max : " + stack.max());
		System.out.println("Popped : " + stack.pop());
	}
}
