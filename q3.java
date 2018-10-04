/*
Q3. ** Merge two sorted linked lists into one. (MICROSOFT INTERVIEW QUESTION)
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
	
	LinkedList mergeSorted(LinkedList l2)
	{
		System.out.println("Merging...");
		LinkedList merge = new LinkedList();
		Node ptr1 = this.head;
		Node ptr2 = l2.head;
		while(ptr1 != null && ptr2 != null)
		{
			if(ptr1.data <= ptr2.data)
			{
				merge.insertEnd(ptr1.data);
				ptr1 = ptr1.next;
			}
			else
			{
				merge.insertEnd(ptr2.data);
				ptr2 = ptr2.next;
			}
		}
		while(ptr1 != null)
		{
			merge.insertEnd(ptr1.data);
			ptr1 = ptr1.next;
		}
		while(ptr2 != null)
		{
			merge.insertEnd(ptr2.data);
			ptr2 = ptr2.next;
		}
		System.out.println("Done!\n");
		return merge;
	}
}
public class q3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LinkedList l1 = new LinkedList();
		System.out.print("\nEnter the number of elements : ");
		int n1 = sc.nextInt();
		System.out.println("Start entering the elements of Sorted Linked List :-");
		for(int i=0;i<n1;i++)
			l1.insertEnd(sc.nextInt());
		
		l1.display();
		
		LinkedList l2 = new LinkedList();
		System.out.print("\nEnter the number of elements : ");
		int n2 = sc.nextInt();
		System.out.println("Start entering the elements of Sorted Linked List :-");
		for(int i=0;i<n2;i++)
			l2.insertEnd(sc.nextInt());
		
		l2.display();
		
		LinkedList merged = l1.mergeSorted(l2);
		merged.display();
		
		sc.close();
	}
}