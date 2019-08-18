package com.shubh.searching;

public class SquareRoot {

	long floorSqrt(long x) {
		if (x == 0 || x == 1)
			return x;
		return find(0, x, x);
	}

	long find(long s, long l, long x) {
		long ans = 0;

		if (s <= l) {
			long mid = s + (l - s) / 2;
			if (mid * mid == x)
				return mid;

			else if (x < mid * mid)
				find(s, mid - 1, x);

			else {
				ans = mid;
				find(mid + 1, l, x);

			}

		}

		return ans;

	}

	public static void main(String[] args) {
		SquareRoot root = new SquareRoot();
		root.floorSqrt(6);
		

	}

}
