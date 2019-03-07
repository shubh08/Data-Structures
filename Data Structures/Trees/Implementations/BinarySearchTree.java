package com.shubh.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	private Node rootNode;

	int maxlevel = 0;

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

	public void leftView() {
		if (rootNode != null) {
			printLeftView(rootNode, 1);
		}

	}

	private void printLeftView(Node node, int level) {

		if (node == null)
			return;
		if (level > maxlevel) {
			System.out.println(node.getData() + " ");
			maxlevel = level;
		}

		printLeftView(node.getLeftChild(), level + 1);
		printLeftView(node.getRightChild(), level + 1);

	}

	private Node getPredecessor(Node node) {
		// TODO Auto-generated method stub

		if (node.getRightChild() != null)
			return getPredecessor(node.getRightChild());
		return node;
	}

	public void levelOrder() {

		if (rootNode != null)
			printLevelOrderTraversal(rootNode);
	}

	private void printLevelOrderTraversal(Node node) {

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.getData() + " ");
			if (tempNode.getLeftChild() != null)
				queue.add(tempNode.getLeftChild());
			if (tempNode.getRightChild() != null)
				queue.add(tempNode.getRightChild());

		}

	}

	public void printVerticalOrder() {

		if (rootNode != null)
			printVerticalOrderNodes(rootNode);

	}

	private List<List<Integer>> printVerticalOrderNodes(Node node) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = new ArrayList<>();
		int min_level = 0, max_level = 0;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		// java.util.List<Integer> level = new ArrayList<>();
		Queue<Integer> level = new LinkedList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		level.add(0);
		while (!queue.isEmpty()) {
			Node nodeRemoved = queue.poll();
			int levelRetrieved = level.poll();
			min_level = Math.min(min_level, levelRetrieved);
			max_level = Math.max(max_level, levelRetrieved);

			if (map.containsKey(levelRetrieved)) {
				map.get(levelRetrieved).add(nodeRemoved.getData());
			} else {
				ArrayList<Integer> arrayList = new ArrayList<>();
				arrayList.add(nodeRemoved.getData());
				map.put(levelRetrieved, arrayList);
			}
			if (nodeRemoved.getLeftChild() != null) {
				queue.add(nodeRemoved.getLeftChild());
				level.add(levelRetrieved - 1);
			}

			if (nodeRemoved.getRightChild() != null) {
				queue.add(nodeRemoved.getRightChild());
				level.add(levelRetrieved + 1);
			}

		}

		for (int i = min_level; i <= max_level; i++) {
			if (map.containsKey(i)) {
				result.add(map.get(i));
			}
		}

		return result;

	}

	public void printSprialOrder(){
		
		
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(rootNode);
		boolean doIteration = true;
		while(doIteration){
			while(!s1.isEmpty())
			{
				Node tempNode= s1.pop();
				System.out.print(tempNode.getData()+" ");
				if(tempNode.getRightChild()!=null)
					s2.push(tempNode.getRightChild());
				if(tempNode.getLeftChild()!=null)
					s2.push(tempNode.getLeftChild());
			}
			doIteration = false;
			while(!s2.isEmpty())
			{
				Node tempNode= s2.pop();
				System.out.print(tempNode.getData()+" ");
				if(tempNode.getLeftChild()!=null)
					{s1.push(tempNode.getLeftChild());
					doIteration=true;}
				if(tempNode.getRightChild()!=null)
					{s1.push(tempNode.getRightChild());
					doIteration = true;}
								
			}
		}
		
		
		
	}
	
}
