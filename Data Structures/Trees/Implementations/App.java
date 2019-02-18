package com.shubh.bst;

public class App {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(10);
		bst.insert(5);
		bst.insert(15);
		bst.insert(3);
		bst.insert(7);
		
		System.out.println("The min element is "+bst.getMin());

		System.out.println("The max element is "+bst.getMax());
		bst.traverse();
		bst.delete(10);
		bst.traverse();
	}
	

	
	
}
