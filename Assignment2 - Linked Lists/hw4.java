//*******************************************************************
// Name: Eric Lin
// Course: CS114-011
// Assignment: Homework 4 - Stacks, Queues, and Linked Lists
// Due Date: 10-16-2022
// Brief: This program implements 3 functions to manipulate linked
// lists: findInList(), reverseList(), and insertedSort().
//*******************************************************************

package integerLists114;
import integerLists114.list.IntegerLList;

public class hw4 {

	public static void main(String[] args) {
		IntegerLList l = new IntegerLList(); 
		l.append(0);
		l.append(10);
		l.append(20);
		l.append(30);
		l.append(40);
		l.append(50);
		l.append(60);
		l.append(70);
		l.append(80);
		l.append(90);
		l.printList();
		
		// should return 2
		System.out.println("index of 20: " + findInList(l,20));
		// should return -1
		System.out.println("index of 100: " + findInList(l,100));
		
		IntegerLList sortedList =  insertSorted(new Integer[] {9, 24, 15, 23, 4, 5, 1});
		sortedList.printList();
		
		IntegerLList reversedList = reverseList(sortedList);
		reversedList.printList();
	}
	
	/**return the index of key in list L, (starting ant index 0) if not found return -1 */
	public static int findInList(IntegerLList l, Integer key)
	{ 
		int idx = -1;

		while(l.getValue() != null)
		{
			if(l.getValue() == key)
			{
				idx = l.currPos();
				break;
			}

			l.next();
		}

		return idx;
	}
	
	public static IntegerLList reverseList(IntegerLList L) {
		IntegerLList reversedList = new IntegerLList();

		L.moveToStart();
		while(L.getValue() != null)
		{
			reversedList.insert(L.getValue());

			L.next();
		}

		return reversedList;				
	}

	/** insert into list  */
	public static IntegerLList insertSorted(Integer[] inputArray) {
			IntegerLList sortedList = new IntegerLList();

			for(Integer i : inputArray)
			{
				sortedList.append(i);

				/* Alternate Method:
				   sortedList.insert(i);
				   sortedList.moveToEnd(); */
			}

			return sortedList;
	}	
}