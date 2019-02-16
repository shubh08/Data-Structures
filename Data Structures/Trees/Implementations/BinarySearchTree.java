package com.shubh.bst;

public class BinarySearchTree {

	private Node rootNode;

	public void insert(int data) {

		if (rootNode == null) {
			rootNode = new Node(data);
		} else
			insertNode(data, rootNode);

	}
	
	public void traverse()
	{
		if(rootNode!=null)
		{
			inOrderTraversal(rootNode);
		}
	}

	private void inOrderTraversal(Node node) {

		if(node.getLeftChild()!=null)
			inOrderTraversal(node.getLeftChild());
		System.out.print(node.getData()+"-->");
		if(node.getRightChild()!=null)
			inOrderTraversal(node.getRightChild());
		
	}

	public int getMin() {
		if (rootNode == null)
			return -1;
		else
			return getMinNode(rootNode);

	}

	public int getMax() {
		if (rootNode == null)
			return -1;
		else
			return getMaxNode(rootNode);

	}

	private int getMinNode(Node node) {
		if (node.getLeftChild() != null)
			return getMinNode(node.getLeftChild());

		return node.getData();
	}

	private int getMaxNode(Node node) {
		if (node.getRightChild() != null)
			return getMaxNode(node.getRightChild());

		return node.getData();
	}

	public void insertNode(int newData, Node Node)

	{
		if (newData < Node.getData()) {
			if (Node.getLeftChild() != null)
				insertNode(newData, Node.getLeftChild());
			else {
				Node newNode = new Node(newData);
				Node.setLeftChild(newNode);

			}
		} else {
			if (Node.getRightChild() != null)
				insertNode(newData, Node.getRightChild());
			else {
				Node newNode = new Node(newData);
				Node.setRightChild(newNode);

			}
		}
	}

}
