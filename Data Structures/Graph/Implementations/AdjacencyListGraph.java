package com.shubh.graph;

import java.util.ArrayList;

public class AdjacencyListGraph {

	static class Graph{
		
		int n;
		ArrayList<Integer> adjaList [];
		
		public Graph(int noOfVertices){
			
			this.n = noOfVertices;
			this.adjaList = new ArrayList[n];
		// Create a list for each vertex so that adjacent nodes can be stored
			for(int i=0; i<n;i++)
			{
				adjaList[i] = new ArrayList<>();
			}
		}
		
		
		
	}
	public void addEdge(Graph g, int source, int destination) 
	{
		g.adjaList[source].add(destination);

		g.adjaList[destination].add(source);
		
		
	}
	
	
	 // A utility function to print the adjacency list  
    // representation of graph 
    static void printGraph(Graph graph) 
    {        
        for(int v = 0; v < graph.n; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adjaList[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    } 
	
	public static void main(String[] args) {
		 // create the graph given in above figure 
		AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph();
		int V = 5; 
        Graph graph = new Graph(V); 
        adjacencyListGraph.addEdge(graph, 0, 1); 
        adjacencyListGraph.addEdge(graph, 0, 4); 
        adjacencyListGraph.addEdge(graph, 1, 2); 
        adjacencyListGraph.addEdge(graph, 1, 3); 
        adjacencyListGraph.addEdge(graph, 1, 4); 
        adjacencyListGraph.addEdge(graph, 2, 3); 
        adjacencyListGraph.addEdge(graph, 3, 4); 
       
        // print the adjacency list representation of  
        // the above graph 
        printGraph(graph); 
		
	}

}
