package com.shubh.searching;

public class BinarySearch {
	
	static void binarySearch(int arr[], int l, int r, int x) {
		
		if(r>=l) {
			
			int mid = l+(r-l)/2;
			if(arr[mid]==x)
			{
				System.out.println("Element Found!");
			}
			
			else if (x>arr[mid])
				binarySearch(arr, l+1, r, x);
			else
				binarySearch(arr, l, r-1, x);
		}
		
		else
			System.out.println("Element not found !");
	}

	public static void main(String[] args) {
		
		int arr [] = {10,2,6,19,80};
		
		binarySearch(arr,0,arr.length-1,19);
		
		
		

	}

}
