/*
**Q4.Check if a linked list is a palindrome.
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
	
	private LinkedList reverseList()
	{
		LinkedList reverse = new LinkedList();
		Node ptr1 = this.head;
		while(ptr1 != null)
		{
			reverse.insertEnd(ptr1.data);
			ptr1 = ptr1.next;
		}
		
		Node cur = reverse.head;
		Node prev = null;
		Node ptr = null;
		while(cur != null)
		{
			ptr = cur.next;
			cur.next = prev;
			prev = cur;
			cur = ptr;
		}
		reverse.head = prev;
		return reverse;
	}
	
	boolean checkPalindrome()
	{
		LinkedList reverse = reverseList();
		Node ptr1 = this.head;
		Node ptr2 = reverse.head;
		while(ptr1 != null && ptr2 != null)
		{
			if(ptr1.data != ptr2.data)
				return false;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		return true;
	}
}
public class q4
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
		
		if(ll.checkPalindrome())
			System.out.println("LinkedList is a Palindrome.");
		else
			System.out.println("LinkedList is not a Palindrome.");
		
		System.out.println();
		sc.close();
	}
}