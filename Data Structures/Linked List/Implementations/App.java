package com.shubh.linkedList;

public class App {
public static void main(String[] args) {
	//Operations For Single Linked List
/*	LinkedList linkedList = new LinkedList();
	linkedList.add(5);
	linkedList.add(4);
	linkedList.add(3);
	linkedList.add(2);
	linkedList.add(1);
	linkedList.traversePrint();
	linkedList.remove(4);
	linkedList.traversePrint();*/
	
	//Operations for Doubly Linked List
	DoubleLinkedList list = new DoubleLinkedList();
	list.addElement(1);
	list.addElement(2);
	list.addElement(3);
	list.addElement(4);
	list.addElement(5);
	list.addElement(6);
	list.traverse();
	list.addNodeAtPosition( 0, 10);
	list.traverse();
	
}
}
