package com.shubh.searching;

public class TerarySearch {
	
	public static void ternarySearch(int arr[], int l, int r, int x )
	{
		while(l<=r)
		{
			int mid1 = l + (r-l)/3;
			int mid2 = r - (r-l)/3;
			
			if(x == mid1 || x == mid2) {
				System.out.println("Element Found!");
				return;
			}
			else if(x<mid1)
			{
				ternarySearch(arr, l, mid1-1, x);
			}
			else if(x>mid1 && x<mid2)
			{
				ternarySearch(arr, mid1+1, mid2-1, x);
			}
			else {
				ternarySearch(arr, mid2+1, r, x);
			}
		}
		
	}

	public static void main(String[] args) {
		
		int arr [] = {10,23,89,123,76,34,90,190};
		
		ternarySearch(arr, 0, arr.length -1, 90);

	}

}
