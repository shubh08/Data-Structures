package com.shubh.linkedList;

public class LinkedList {

	Node root;

	// Adding Element at the beginning
	public void add(int data) {

		Node dataToAdd = new Node(data);

		if (root == null) {
			root = dataToAdd;
		}

		else
			insertAtBegining(dataToAdd);

	}

	private void insertAtBegining(Node dataToAdd) {
		dataToAdd.next = root;
		root = dataToAdd;

	}

	// Traversing the List
	public void traversePrint() {

		Node temp = root;

		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("null");
	}

	// Adding Element at the End
	public void addAtEnd(int data, Node current) {
		if (current.next != null)
			addAtEnd(data, current.next);
		else {
			Node newNode = new Node(data);
			current.next = newNode;
		}
	}

	// Removing element
	public void remove (int data)
	{
	
		
	}
	
	
}
