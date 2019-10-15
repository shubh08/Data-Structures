package com.shubh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	
	    
	    public List<List<Integer>> threeSum(int[] nums) {
	       
	        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
	        Arrays.sort(nums);
	      //  List<Integer> comp = null;
	        for(int i=0;i<nums.length-2;i++)
	        {
	           int comp = 0-nums[i];
	            
	            if(i==0||nums[i]>nums[i-1])
	            {
	                int s =  i+1;
	                int e  = nums.length-1;
	                
	                while(s<e)
	                {
	                    if(nums[s]+nums[e]==comp)
	                    {
	                        res.add(Arrays.asList(nums[i],nums[s],nums[e]));
	                        while(s<e && nums[s]==nums[s+1]) s++;
	                        while(s<e && nums[e-1]==nums[e]) e--;
	                        s++;
	                        e--;
	                    }
	                    
	                   else if(nums[s]+nums[e]<comp){
	                      s++;
	                   }                
	                      
	                    else 
	                    	 e--;
	                       }
	            }
	        
	        
	           
	        }
	    return res;
	    }
	    
	    public static void main(String[] args) {
	    	ThreeSum sum = new ThreeSum();
	    	int arr [] = {1,-1,-1,0};
	    	sum.threeSum(arr);
		}
	 
}
