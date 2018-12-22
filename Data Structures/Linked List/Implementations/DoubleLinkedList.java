package com.shubh.linkedList;

public class DoubleLinkedList {

	DoubleLinkedListNode root;
	
	public void addElement(int data)
	{
		if (root == null)
		{
			DoubleLinkedListNode node = new DoubleLinkedListNode(data);
			root = node;
		}
		else{
			insertNodeAtEnd(root, data);
		}
		
	}

	private void insertNodeAtEnd(DoubleLinkedListNode node, int data) {
		if(node.next==null)
		{
			DoubleLinkedListNode nodeElement = new DoubleLinkedListNode(data);
			node.next = nodeElement;
			nodeElement.prev = node;
		}
		else
			insertNodeAtEnd(node.next, data);
		
	}
	
	public void traverse()
	{
		DoubleLinkedListNode   node = null ;
		DoubleLinkedListNode headRef = root;
		while (headRef!=null)
		{
			System.out.print(headRef.data+"-->");
			if(headRef.next == null)
			node = headRef;
			headRef = headRef.next;
			
		}
	System.out.print("null \n");
	traverseListReverse(node);
	
	}

	// Traversing the List in reverse
	private void traverseListReverse(DoubleLinkedListNode node) {
		DoubleLinkedListNode headRef = node;
		System.out.println("Traversing the List in Reverse: \n");
		while (headRef!=null)
		{
			System.out.print(headRef.data+"-->");
			headRef = headRef.prev;
			
		}
	System.out.print("null");
		
	}
	
	void addNodeAtPosition(int pos, int data)
	{
		DoubleLinkedListNode head_ref = root;
	    if (head_ref == null)
	    return;
	    DoubleLinkedListNode head = head_ref;
	    DoubleLinkedListNode element = new DoubleLinkedListNode(data);
		int indexPosition = 0;
		while(head != null)
		{
		    if(indexPosition==pos)
		    {
		        if(head.next != null)
		        {   
		            element.next = head.next;
		            head.next.prev = element;
		        }
		        head.next = element;
		        element.prev = head;
		        break;
		    }
		    else
		    {indexPosition++;
		    
		    head = head.next;    
		    }
		}
		
	}
	
	
}
