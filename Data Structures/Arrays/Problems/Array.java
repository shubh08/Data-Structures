package com.shubh.array;

public class Array {

	public static void main(String[] args) {
		int arr[] = {4,20,2,1,56};
		Array a = new Array();
		a.reverseArray(arr);
		System.out.println("Rotated array is"+a.rotate(arr, 2));
	}
	
	  public  int [] rotate (int[] nums, int k) {
		     
	        if(k==0) return null;
	        int length = nums.length;
	                reverse(nums,0,nums.length-1);
	                reverse(nums,0,k-1);
	                reverse(nums,k,nums.length-1);
	                
	            
	        return nums;
	    }
	    
	    public void reverse(int nums[], int start, int end)
	    {
	        while(start<end)
	        {
	            int temp = nums[end];
	            nums[end] = nums[start];
	            nums[start] = temp;
	            
	        }
	        
	    }

	private void reverseArray(int arr[]) {
		int j = arr.length-1;
		int i =0;
		//if(arr.length%2==0)
		while(i<arr.length&&j>=0)
		{
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
			
		}
		
		System.out.println("Reverse array is as below:");
		for(int num:arr)
		{
			System.out.print(num+"\t");
		}
	}

}
