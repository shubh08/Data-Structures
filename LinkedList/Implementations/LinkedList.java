package com.shubh.linkedList;

public class LinkedList {

	Node root;
	
	public void add(int data){
		
		Node dataToAdd = new Node(data);
		
		if(root==null)
		{
			root = dataToAdd;
		}
		
		else
			insertAtBegining(dataToAdd);
		
		
	}

	private void insertAtBegining(Node dataToAdd) {
		dataToAdd.next = root;
		root = dataToAdd;
		
	}
	
	public void traversePrint(){
		
		Node temp = root;
		
		while(temp != null)
		{
			System.out.print(temp.data+"-->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
}
