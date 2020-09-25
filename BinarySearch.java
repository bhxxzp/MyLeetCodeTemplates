package template;

import java.util.*;

// Leetcode 33, 278, 702, 704, 162
public class BinarySearch {
	// 二分法
	// 有相等就for 循环，或者start++, end--
	// First Position
	// 最后出结果的时候 先start
	public static int firstBinarySearch(int[] nums, int target) {
		// 判空
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			// 因为 (start + end) / 2 有超过int上线的可能
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				end = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else if (nums[mid] > target) {
				end = mid;
			}
		}
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;	
	}
	
	// Last Position
	// 最后出结果的时候 先end
	public static int lastBinarySearch(int[] nums, int target) {
		// 判空
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1;
		while (start + 1< end) {
			// 因为 (start + end) / 2 有超过int上线的可能
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				start = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else if (nums[mid] > target) {
				end = mid;
			}
		}
		if (nums[end] == target) {
			return end;
		}
		if (nums[start] == target) {
			return start;
		}
		return -1;	
	}
	
	// Leetcode 278
	public int firstBadVersion(int n) {
        // if (n == 0) return 0;
        int mid = 0;
        int start = 1;
        int end = n - 1;
//        while(start + 1 < end) {
//            mid = start + (end - start) / 2;
//            if (isBadVersion(mid)) {
//                end = mid;
//            } else {
//                start = mid;
//            }
//        }
//        if (isBadVersion(start)) return start;
//        if (isBadVersion(end)) return end;
        return n;
    }
	
	// Peak
	// Leetcode 162
	public int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums == null) return -1;

        int start = 0, end = nums.length - 1, mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else if (nums[mid] > nums[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 2};
//		System.out.println(firstBinarySearch(nums, 2));
		System.out.println(lastBinarySearch(nums, 2));
	}
}
