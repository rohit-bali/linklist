/*
Q6.** Arrange elements in a linked list such that all odd elements come first and then even elements.
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
	
	LinkedList oddList()
	{
		LinkedList odd = new LinkedList();
		Node ptr = this.head;
		while(ptr != null)
		{
			if(ptr.data%2 != 0)
				odd.insertEnd(ptr.data);
			ptr = ptr.next;
		}
		return odd;
	}
	
	LinkedList evenList()
	{
		LinkedList even = new LinkedList();
		Node ptr = this.head;
		while(ptr != null)
		{
			if(ptr.data%2 == 0)
				even.insertEnd(ptr.data);
			ptr = ptr.next;
		}
		return even;
	}
	
	LinkedList mergeList(LinkedList even)
	{
		LinkedList merge = new LinkedList();
		Node ptr = this.head;
		while(ptr != null)
		{
			merge.insertEnd(ptr.data);
			ptr = ptr.next;
		}
		ptr = even.head;
		while(ptr != null)
		{
			merge.insertEnd(ptr.data);
			ptr = ptr.next;
		}
		return merge;
	}
}
public class q6
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		System.out.print("\nEnter the number of elements : ");
		int n = sc.nextInt();
		System.out.println("Start entering the elements of Linked List :-");
		for(int i=0;i<n;i++)
			ll.insertEnd(sc.nextInt());
		
		ll.display();
		
		LinkedList odd = ll.oddList();
		LinkedList even = ll.evenList();
		LinkedList merge = odd.mergeList(even);
		merge.display();
		
		System.out.println();
		sc.close();
	}
}