package integerLists114.queue;

/** Array-based queue implementation */
public class AQueue implements QueueADT<Integer> {
	private static final int defaultSize = 10;
	private int maxSize; // Maximum size of queue
	private int front; // Index of front element
	private int rear; // Index of rear element
	private Integer[] listArray; // Array holding queue elements
	/** Constructors */
	public AQueue() { 
		this(defaultSize); 
	}
	
	@SuppressWarnings("unchecked")
	public AQueue(int size) {
		maxSize = size+1; // One extra space is allocated
		rear = 0; front = 1;
		listArray = new Integer[maxSize]; // Create listArray
	}
	/** Reinitialize */
	public void clear(){ 
		rear = 0; front = 1; 
	}
	
	/** Put "it" in queue */
	public void enqueue(Integer it) {
		assert ((rear+2) % maxSize) != front : "Queue is full";
		rear = (rear+1) % maxSize; // Circular increment
		listArray[rear] = it;
	}
	/** Remove and return front value */
	public Integer dequeue() {
		assert length() != 0 : "Queue is empty";
		Integer it = listArray[front];
		front = (front+1) % maxSize; // Circular increment
		return it;
	}
	/** @return Front value */
	public Integer frontValue() {
		assert length() != 0 : "Queue is empty";
		return listArray[front];
	}
	/** @return Queue size */
	public int length()
	{ return ((rear+maxSize) - front + 1) % maxSize; } 
	
	public void printQueue(){
		for(int i=front ; i!=(rear+1)%maxSize; i=(i+1)%maxSize)
		{
		   System.out.print(listArray[i] + " ");
		}
		System.out.println();
	}

}


