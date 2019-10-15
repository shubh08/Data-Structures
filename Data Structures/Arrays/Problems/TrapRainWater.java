package com.shubh.array;

public class TrapRainWater {

	 public int trap(int[] height) {
	        if(height==null||height.length==1) return 0;
	        int area = 0;
	        for(int i=0;i<height.length;i++)
	        {
	            int localSum = 0;
	            boolean highFound = false;
	            for(int j=i+1;j<height.length;j++)
	            {
	        
	                if(height[j]>=height[i])
	                {
	                    area+=localSum;
	                    i=j-1;
	                    break;
	                }
	                
	                else{
	                    localSum+= height[i]-height[j];
	                }
	                
	            }
	            
	        }
	        return area;
	    }
	
	public static void main(String[] args) {
		
		TrapRainWater rainWater = new TrapRainWater();
		int height [] = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(rainWater.trap(height));
	}

}
