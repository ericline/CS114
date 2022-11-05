package integerLists114.stack;

/** Array-based stack implementation */
public class AStack implements StackADT<Integer> {
	private static final int defaultSize = 10;
	private int maxSize; // Maximum size of stack
	private int top; // Index for top Object
	private Integer[] listArray; // Array holding stack
	
	/** Constructors */
	public AStack() { this(defaultSize); }

	public AStack(int size) {
		maxSize = size;
		top = 0;
		listArray = new Integer[size]; // Create listArray
	}
	
	/** Reinitialize stack */
	public void clear() { 
		top = 0;
	}
	
	/** Push "it" onto stack */
	public void push(Integer it) {
		assert top != maxSize : "Stack is full";
		listArray[top++] = it;
	}
	
	/** Remove and top element */
	public Integer pop() {
		assert top != 0 : "Stack is empty";
		return listArray[--top];
	}
	
	/** @return Top element */
	public Integer topValue() {
		assert top != 0 : "Stack is empty";
		return listArray[top-1];
	}
	
	/** @return Stack size */
	public int length() { 
		return top; 
	}
}
