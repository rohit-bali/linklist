/*
Q2. Eliminate duplicates from a sorted linked list.
*/

import java.util.Scanner;

class LinkedList
{
	Node head;
	
	void insertEnd(int data)
	{
		Node temp = new Node(data);
		if(head == null)
			head = temp;
		else
		{
			Node ptr = head;
			while(ptr.next != null)
				ptr = ptr.next;
			ptr.next = temp;
		}
	}
	
	void display()
	{
		System.out.println("The Linked List:-");
		Node ptr = head;
		while(ptr != null)
		{
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println('\n');
	}
	
	void removeDuplicatesInSorted()
	{
		Node ptr = head;
		while(ptr != null && ptr.next != null)
		{
			if(ptr.data == ptr.next.data)
			{
				ptr.next = ptr.next.next;
			}
			else
				ptr = ptr.next;
		}
	}
}
public class q2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		System.out.print("\nEnter the number of elements : ");
		int n = sc.nextInt();
		System.out.println("Start entering the elements for Sorted Linked List :-");
		for(int i=0;i<n;i++)
			ll.insertEnd(sc.nextInt());
		
		ll.display();
		
		ll.removeDuplicatesInSorted();
		System.out.println("Duplicates removed!");
		ll.display();
		
		sc.close();
	}
}