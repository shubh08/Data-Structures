package com.shubh.tree;

public class BinarySearchTree {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int key) {
			this.data = key;
			this.right = null;
			this.left = null;
		}

	}

	Node root;

	BinarySearchTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	private Node insertRec(Node root, int key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key <= root.data) {
			root.left = insertRec(root.left, key);
		}

		else
			root.right = insertRec(root.right, key);

		return root;
	}

	// Traversals

	public void preOrder() {
		preOrderTraversal(root);

	}

	private void preOrderTraversal(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + "-->");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);

	}

	public void inOrder() {
		inOrderTraversal(root);

	}

	private void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data + "-->");
		inOrderTraversal(root.right);

	}

	public void postOrder() {
		postOrderTraversal(root);

	}

	private void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data + "-->");
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		System.out.println("In Order Traversal!!");
		tree.inOrder();
		System.out.println("\n Deleting 20 ");
		tree.deleteRec(20);
		System.out.println("In Order Traversal!!");
		tree.inOrder();
		System.out.println("\n Deleting 30 ");
		tree.deleteRec(30);
		System.out.println("In Order Traversal!!");
		tree.inOrder();

	}

	private void deleteRec(int key) {

		root = deleteRecord(root, key);

	}

	private Node deleteRecord(Node root, int key) {

		if (root == null)
			return null;
		else if (key < root.data)
			root.left = deleteRecord(root.left, key);
		else if (key > root.data)
			root.right = deleteRecord(root.right, key);
		else {
			// node to be deleted found. It has either one or zero children
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;

			// node to be deleted has 2 children

			root.data = findInorderSuccessor(root.right);

			root.right = deleteRecord(root.right, key);

		}
		return root;
	}

	private int findInorderSuccessor(Node node) {
		int returnKey = node.data;
		node = node.left;
		while (node != null) {
			returnKey = node.data;
			node = node.left;

		}
		return returnKey;
	}

}
