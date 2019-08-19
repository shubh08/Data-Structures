package com.shubh.searching;

public class PowerOfX {

	public float powerCalculator(float x, int y)
	{
		if(y==0) 
			return 1;
		float temp = powerCalculator(x,y/2);
		
		if((y%2)!=0)
		{
			if(y<0) return temp*temp/x;
			return x*temp*temp;
			
		}
		else 
			return temp*temp;
		
	}
	
	public static void main(String[] args) {
		PowerOfX of = new PowerOfX();
		float x = of.powerCalculator(2,-2);
		System.out.println("Answer is ->"+x);

	}

}
