package template;

import java.util.Arrays;

public class MergeSort {
	public void sortIntegers(int[] nums) {
		if (nums == null || nums.length == 0) return;
		
		int[] temp = new int[nums.length];
		mergeSort(nums, 0, nums.length - 1, temp);
		
	}
	
	private void mergeSort(int[] nums, int start, int end, int[] temp) {
		if (start >= end) return;
		
		int mid = start + (end - start) / 2;
		mergeSort(nums, start, mid, temp);
		mergeSort(nums, mid + 1, end, temp);
		merge(nums, start, end, temp);
	}
	
	private void merge(int[] nums, int start, int end, int[] temp) {
		int mid = start + (end - start) / 2;
		int leftIndex = start;
		int rightIndex = mid + 1;
		int index = start;
		
		while (leftIndex <= mid && rightIndex <= end) {
			if (nums[leftIndex] < nums[rightIndex]) {
				temp[index++] = nums[leftIndex++];
			} else {
				temp[index++] = nums[rightIndex++];
			}
		}
		
		while (leftIndex <= mid) {
			temp[index++] = nums[leftIndex++];
		}
		while (rightIndex <= end) {
			temp[index++] = nums[rightIndex++];
		}
		
		for (int i = start; i <= end; i++) {
			nums[i] = temp[i];
		}
	}
	
	public static void main(String[] args) {
		MergeSort sol = new MergeSort();
		int[] nums = {3, 2, 1, 5, 4, 1};
		sol.sortIntegers(nums);
		System.out.println(Arrays.toString(nums));
	}
}
