package com.shubh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSubsets {

	public static void main(String[] args) {
		FindAllSubsets subsets = new FindAllSubsets();
		int arr []  = {1,4,6};
		subsets.findSubset(arr);
	}

	private void findSubset(int[] arr) {
		
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> sub = new ArrayList<Integer>();
		Arrays.sort(arr);
		findAll(arr,res,sub,0);
		
		System.out.println("Result is"+res);
	}

	private void findAll(int[] arr, List<List<Integer>> res, List<Integer> sub, int index) {
	
		res.add(new ArrayList<Integer>(sub));
	
		for(int i=index;i<arr.length;i++)
		{
		sub.add(arr[i]);
		findAll(arr, res, sub, index+1);
		sub.remove(sub.size()-1);
		}
		
	}
	
}
