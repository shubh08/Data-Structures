package com.shubh.search;

public class BinarySearch {

	
	
	public int binarySearch(int arry [], int beg, int end, int x)
	{
		
		
		if(end>beg){
			int mid = beg+(end-beg)/2;
			if(arry[mid]==x)
				return mid;
			else if(x<arry[mid])
			{
				return binarySearch(arry, beg, mid-1, x);
			}
			
			else {
				return binarySearch(arry,mid+1,end,x);
			}
		}
		
		return -1;
			
		
		
		
	}
	
	public int iterativeBinarySearch(int arr [], int l, int r, int x){
		
		while(r>l)
		{
			int mid = l + (r-1)/2;
			if(arr[mid] == x)
				return mid;
			else if(x>arr[mid])
				l = mid +1;
			else if( x < arr[mid])
				r = mid -1;
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arr [] = {1,12,13,19,28,50,100,106};
		
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.binarySearch(arr, 0, 7, 100));
		System.out.println(binarySearch.iterativeBinarySearch(arr, 0, 7, 100));
		

	}

}
