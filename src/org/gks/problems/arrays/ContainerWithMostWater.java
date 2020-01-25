package org.gks.problems.arrays;

// https://www.geeksforgeeks.org/container-with-most-water/



public class ContainerWithMostWater {

	public static int maxArea(int height[], int len) {
		int l = 0;
		int r = len - 1;
		int area = 0;

		while (l < r) {
			// Calculating the max area
			int min = Math.min(height[l], height[r]);
			area = Math.max(area,  min * (r - l));

			if (height[l] < height[r])
				l += 1;
			else
				r -= 1;
		}
		return area;
	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 4, 3 };
		int b[] = { 3, 1, 2, 4, 5 };

		int len1 = 4;
		System.out.print(maxArea(a, len1) + "\n");

		int len2 = 5;
		System.out.print(maxArea(b, len2));
	}
}


