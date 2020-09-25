package template;

import java.util.Arrays;

// Leetcode 190, 189
public class RotateArray {
	public static void rotate(int[] nums, int k) {
		if (nums.length == 0 || nums == null) return;
		
		k = nums.length - k % nums.length;
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}
	
	public static void reverse(int[] nums, int start, int end) {
		for (int i = start, j = end; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
		return;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}
	
}
