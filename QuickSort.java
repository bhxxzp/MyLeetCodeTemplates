package template;

import java.util.*;

public class QuickSort {
	/*
     * @param A: an integer array
     * @return: 
     */
    public void sortIntegers(int[] nums) {
    	if (nums == null || nums.length == 0) return;
    	
    	quickSort(nums, 0, nums.length - 1);
    }
    
    private void quickSort(int[] nums, int start, int end) {
    	if (start >= end) return;
    	
    	int left = start;
    	int right = end;
    	int pivot = nums[start + (end - start) / 2];
    	while (left <= right) {
    		while (left <= right && nums[left] < pivot) {
    			left++;
    		}
    		while (left <= right && nums[right] > pivot) {
    			right--;
    		}
    		if (left <= right) {
    			int temp = nums[left];
    			nums[left] = nums[right];
    			nums[right] = temp;
    			left++;
    			right--;
    		}
    	}
    	
    	quickSort(nums, start, right);
    	quickSort(nums, left, end);
    }
    
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
		int[] A = {1, 3, 5, 6, 4, 2};
		QuickSort sol = new QuickSort();
		sol.sortIntegers(A);
		System.out.println(Arrays.toString(A));
	}
}
