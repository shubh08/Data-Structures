package com.shubh.bst;

public class BinarySearchTree {

	private Node rootNode;

	public void insert(int data) {

		if (rootNode == null) {
			rootNode = new Node(data);
		} else
			insertNode(data, rootNode);

	}

	public void traverse() {
		if (rootNode != null) {
			inOrderTraversal(rootNode);
			preOrderTraversal(rootNode);
			postOrderTraversal(rootNode);
		}
	}

	private void postOrderTraversal(Node node) {
		if (node.getLeftChild() != null)
			postOrderTraversal(node.getLeftChild());
		if (node.getRightChild() != null)
			postOrderTraversal(node.getRightChild());
		System.out.print(node.getData() + "-->");
	}

	private void preOrderTraversal(Node node) {

		System.out.print(node.getData() + "-->");
		if (node.getLeftChild() != null)
			preOrderTraversal(node.getLeftChild());

		if (node.getRightChild() != null)
			preOrderTraversal(node.getRightChild());
	}

	// InOrder Traversal
	private void inOrderTraversal(Node node) {

		if (node.getLeftChild() != null)
			inOrderTraversal(node.getLeftChild());
		System.out.print(node.getData() + "-->");
		if (node.getRightChild() != null)
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

	public void delete(int data) {

		if (rootNode != null)
			rootNode = deleteNode(rootNode, data);
	}

	private Node deleteNode(Node node, int data) {
		if (node == null)
			return node;

		if (data < node.getData())
			node.setLeftChild(deleteNode(node.getLeftChild(), data));
		else if (data > node.getData())
			node.setRightChild(deleteNode(node.getRightChild(), data));
		else {
			// We found the node to be removed
			if (node.getLeftChild() == null && node.getRightChild() == null) {
				System.out.println("Removing a leaf node!!");
				return null;
			}

			if (node.getLeftChild() == null) {
				System.out.println("Removing the right child!!");
				Node tempNode = node.getRightChild();
				node = null;
				return tempNode;
			} else if (node.getRightChild() == null) {
				System.out.println("Removing the left child!!");
				Node tempNode = node.getLeftChild();
				node = null;
				return tempNode;
			}

			System.out.println("Removing item with two children!!");
			Node tempNode = getPredecessor(node.getLeftChild());
			node.setData(tempNode.getData());
			node.setLeftChild(deleteNode(node.getLeftChild(), tempNode.getData()));
		}
		return node;
	}

	private Node getPredecessor(Node node) {
		// TODO Auto-generated method stub

		if (node.getRightChild() != null)
			return getPredecessor(node.getRightChild());
		return node;
	}

}
