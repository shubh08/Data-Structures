package com.shubh.linkedList;

public class App {
public static void main(String[] args) {
	LinkedList linkedList = new LinkedList();
	linkedList.add(5);
	linkedList.add(4);
	linkedList.add(3);
	linkedList.add(2);
	linkedList.add(1);
	linkedList.traversePrint();
	linkedList.remove(4);
	linkedList.traversePrint();
}
}
