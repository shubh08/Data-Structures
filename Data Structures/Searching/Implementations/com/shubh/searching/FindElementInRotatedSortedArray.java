package com.shubh.searching;

public class FindElementInRotatedSortedArray {

	public int search(int[] nums, int target) {
	    if(nums.length==0) return -1;
	    if(nums.length == 1)
	    {
	        if(nums[0]== target)
	             return 0;
	        else
	            return -1;
	    }
	        // Find Pivot Element
	    int pivot = findPivot(nums,0,nums.length-1);
	    
	    if(pivot == 0) return binarySearch(nums,0,nums.length-1,target);
	     
	    if(nums[pivot]<=target && target <= nums[nums.length-1]) 
	        return binarySearch(nums,pivot,nums.length-1,target);
	        
	        else
	            return binarySearch(nums,0,pivot-1,target);
	    
	        
	    }
	    
	    public int binarySearch(int nums[], int s , int e, int x)
	    {
	        int result = -1;
	        
	        while(s<=e)
	        {
	            int mid = s + (e-s)/2;
	            if(nums[mid]==x)
	            {
	                result = mid;
	                break;
	            }
	            else if(x<nums[mid])
	                    e = mid - 1;
	        
	            else
	                s = mid + 1;
	                }
	        
	        return result;
	    }
	    
	    public int findPivot(int [] nums, int s, int e)
	    {
	        int pivot = 0;
	        if(nums[0]<=nums[nums.length-1]) return 0;
	        while(s<=e)
	        {
	            
	            int mid = s + (e-s)/2;
	            
	            if(nums[mid]>nums[mid+1])
	            {pivot= mid+1;
	             break;
	            }
	            else if(nums[s]>nums[mid])
	                e = mid - 1;
	            else
	                s = mid +1;
	            
	            
	        }
	        return pivot;
	    }
	
	public static void main(String[] args) {
		
		FindElementInRotatedSortedArray array = new FindElementInRotatedSortedArray();
		int arr [] = {3,1};
		
		System.out.println("Answer is -->"+ array.search(arr,1));
	}

}
