package com.shubh.tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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
	
	 class QueueNode{
	        int hd;
	        Node node;
	        
	       public QueueNode(int h, Node nod){
	            
	            hd = h;
	            node = nod;
	            
	        }
	    }

	Node root;

	//Print Top View of the Binary Tree
	
	public void printTopView() {
		
		
if(root==null) return;
        
        Queue<QueueNode> q = new LinkedList<>();
        
        Map<Integer,Node> map = new HashMap<>();
        q.add(new QueueNode(0,root));
        
        while(!q.isEmpty())
        {
           QueueNode temp = q.poll();
           if(!map.containsKey(temp.hd))
           {
               System.out.print(" "+temp.node.data);
               map.put(temp.hd,temp.node);
               
           }
           
           if(temp.node.left!=null)
           q.add(new QueueNode(temp.hd-1,temp.node.left));
           
           if(temp.node.right!=null)
           q.add(new QueueNode(temp.hd+1,temp.node.right));
           
            
            
        }
		
	}
	
	BinarySearchTree() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public void printLeftView() {
		Queue<Node> q = new LinkedList<Node>();  
        q.add(root); 
       
        // null marker to represent end of current level 
        q.add(null);  
        boolean printedFirst = false;
        // Do Level order of tree using NULL markers 
        while (!q.isEmpty()) { 
           
        	Node p = q.peek(); 
            q.remove(); 
            if(!printedFirst && p!=null)
            	{System.out.print(" "+p.data);
            	printedFirst = true;
            	}
            
            if (p != null) { 
                // push left and right children of current 
                // node 
                if (p.left != null) 
                    q.add(p.left);  
                if (p.right != null) 
                    q.add(p.right); 
            }  
              
            // if queue is not empty, push NULL to mark  
            // nodes at this level are visited 
            else if (!q.isEmpty())  {
            	 q.add(null);  
            	 printedFirst = false;
            }
               
        } 
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

	public void inOrderIterative() {
		inOrderTraversalIterative(root);

	}

	private void inOrderTraversalIterative(Node root) {
		
		Stack<Node> st = new Stack<>();
		System.out.println("\nIterative InOrder Traversal!");
		
		while(true)
		{
			while(root!=null)
			{
				st.push(root);
				root = root.left;				
			}
			
			
			
			if(st.isEmpty()) break;
			
			root = st.pop();
			System.out.print(root.data+"--->");
			root = root.right;
			
		}
		

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

	 public int kthSmallest( int k) {
	        Node temp = root;
	        Stack<Node> st = new Stack<>();
	        
	        while(true)
	        {
	            if(temp!=null)
	            {
	                st.push(temp);
	                temp = temp.left;
	            }
	            
	            if(st.isEmpty())
	                break;
	            k--;
	            temp = st.pop();
	            if(k==0) return temp.data;
	            temp = temp.right;
	            
	        }
	        
	        return 0;
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
		
		System.out.println("Printing the leftView of the binaryTree");
		tree.printLeftView();
		
		System.out.println("Printing Top View of the Tree");
		tree.printTopView();
		
		System.out.println("In Order Traversal !!");
		tree.inOrder();
		System.out.println("Printing 2nd smallest element "+tree.kthSmallest(2));
		tree.inOrderIterative();
		tree.levelOrderInit();
		tree.levelOrderTraversalLevelByLevel();
		System.out.println("Zig Zag Traversal!!");
		tree.zigZagTraversal();
		System.out.println("Level Order Traversal Single Line");
		tree.levelOrderTraversalSingleLine();
		System.out.println("\n Deleting 20 ");
		tree.deleteRec(20);
		System.out.println("In Order Traversal!!");
		tree.inOrder();
		System.out.println("\n Deleting 30 ");
		tree.deleteRec(30);
		System.out.println("In Order Traversal!!");
		tree.inOrder();

	}

	public void zigZagTraversal() {
		Node tempRoot = root;
		if(tempRoot==null) return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		List<List<Integer>>  masterList = new ArrayList<>();
		s1.push(tempRoot);
		while(!s1.isEmpty() || !s2.isEmpty())
		{
			List<Integer> listS1 = new ArrayList<Integer>();
			while(!s1.isEmpty())
			{	
				Node x = s1.pop();
				listS1.add(x.data);
				System.out.print(x.data+"-->");
				if(x.right!=null)
				s2.push(x.right);
				if(x.left!=null)
				s2.push(x.left);
			}
			if(listS1.size()>0)
				masterList.add(listS1);
			
			List<Integer> listS2 = new ArrayList<Integer>();
			
			while(!s2.isEmpty())
			{	Node x = s2.pop();
			listS2.add(x.data);
				System.out.print(x.data+"-->");
				if(x.left!=null)
				s1.push(x.left);
				if(x.right!=null)
				s1.push(x.right);
			}
			if(listS2.size()>0)
				masterList.add(listS2);
		}
		
		System.out.println("Master List Content-->"+masterList);
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

	
	public void levelOrderTraversalSingleLine()
	{
		Node rootDup = root;
		if(root==null) return;
		Queue<Node> queue = new LinkedList<>();
		queue.add(rootDup);
		System.out.println("Level Order Traversal Single Line!!");
		while(!queue.isEmpty())
		{
			Node x = queue.poll();
			System.out.println(x.data);
			if(x.left!=null) queue.add(x.left);
			if(x.right!=null) queue.add(x.right);
		}
		
	}
	
public void levelOrderInit() {
	levelOrder(root);
}	
	
public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> masterList = new ArrayList<>();
        
        if(root==null) return masterList;
        
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
             
            for(int i=0;i<qu.size();i++)
            {
            	Node x = qu.remove();
                temp.add(x.data);
                if(x.left!=null)
                {  qu.add(x.left);}
                if(x.right!=null)
                { qu.add(x.right);}
            }
            
            masterList.add(temp);
            
        }
        
        return masterList;
    }
	


	public void levelOrderTraversalLevelByLevel() {

		Node tempRoot = root;
		Queue<Node> queue = new LinkedList<>();
		if (tempRoot == null)
			return;
		//List<List<Integer>> masterListd =  new ArrayList<>();;
		ArrayList<ArrayList<Node>> masterList = new ArrayList<ArrayList<Node>>();
		ArrayList<Node> rootTemp = new ArrayList<Node>();
		rootTemp.add(tempRoot);
		masterList.add(rootTemp);
		rootTemp.clear();
		queue.add(tempRoot);
		queue.add(null);
		boolean loop = true;
		int flag = 0;
		while (!queue.isEmpty()) {

			Node x = queue.poll();

			if (x == null) {
				if (flag == 0)
					break;
				queue.add(null);
				
				masterList.add(rootTemp);
				rootTemp.clear();
				flag = 0;
			}

			else {
				flag = 1;
				if (x.left != null) {
					rootTemp.add(x.left);
					queue.add(x.left);
				}

				if (x.right != null) {
					rootTemp.add(x.right);
					queue.add(x.right);
				}

			}

		}
		System.out.println("Printing ArrayList" + masterList);
	}
}
