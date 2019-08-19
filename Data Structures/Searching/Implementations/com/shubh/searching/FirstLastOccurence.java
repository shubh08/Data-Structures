package com.shubh.searching;

public class FirstLastOccurence {

	public int findFirstOccurence(int arr[], int s, int l, int x)
	{ int result = -1;
		while(s<=l)
		{
			int mid = s + (l-s)/2;
			
			if(arr[mid]==x)
			{
				l = mid-1;
				result = mid;
				
			}
			else if(x<arr[mid])
				l = mid-1;
			else
				s = mid+1;
			
		}
		
		
		return result;
		
		
	}
	
	public int findLastOccurence(int arr [], int s , int l , int x)
	{
		int result = -1;
		while(s<=l)
		{
			int mid = s + (l-s)/2;
			
			if(arr[mid]==x)
			{
				s = mid+1;
				result = mid;
				
			}
			else if(x<arr[mid])
				l = mid-1;
			else
				s = mid+1;
			
		}
		
		
		return result;
		
		
		
	}
	
	public static void main(String[] args) {
		
		FirstLastOccurence fl = new FirstLastOccurence();
		int arr [] = {9,10,11,11,11,11,19,20,25};
		int result [] = new int [2];
		result[0] = fl.findFirstOccurence(arr,0,arr.length-1,11);
		result [1] = fl.findLastOccurence(arr,0,arr.length-1,11);
		System.out.println("Result is -->"+result[0]+result[1]);
		

	}

}
