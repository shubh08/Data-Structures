package com.shubh.array;

import java.util.ArrayList;
import java.util.List;

public class PrintSpiral2D {


    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0;
        int lmx = matrix.length;
        int r = 0;
        int rmx = matrix[0].length;
        int dir = 0;
        List<Integer> res = new ArrayList<>();
        while(l<lmx && r<rmx)
        {
            if(dir==0)
            {
                for(int i=r;i<rmx;i++)
                {
                    res.add(matrix[l][i]);
                }
                
                l++;
                dir=1;
            }
            
            else if(dir==1)
            {
                for(int i=l;i<lmx;i++)
                {
                    res.add(matrix[i][rmx-1]);
                }
                rmx--;
                dir=2;
            }
            
            else if(dir==2)
            {
                for(int i = rmx-1;i>=r;i--)
                {
                    res.add(matrix[lmx-1][i]);
                }
                lmx--;
                dir=3;
            }
            
             else if(dir==3)
            {
                for(int i =lmx-1 ;i>=l;i--)
                {
                    res.add(matrix[i][r]);
                }
                r++;
                dir=0;
            }
            
        }
        
        return res;
    }
	public static void main(String[] args) {
		
		int arr[][]= { { 1, 2, 3, 4 },
				{  5, 6, 7, 8 },
				{ 9, 10, 11, 12 }};
		PrintSpiral2D  ps = new PrintSpiral2D();
		System.out.println("Print the order:"+ps.spiralOrder(arr));

	}

}
