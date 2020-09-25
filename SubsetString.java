package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Leetcode 78
// Leetcode 90
public class SubsetString {
	/**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * Recursion
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        
        if (nums == null) {
            return results;
        }
        
        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }
        
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results);
        return results;
    }
    
    
    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private void helper(ArrayList<Integer> subset,
                        int[] nums,
                        int startIndex,
                        List<List<Integer>> results) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        results.add(new ArrayList<Integer>(subset));
        
        // 变化一般在循环中做变化
        for (int i = startIndex; i < nums.length; i++) {
        	if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }
        
        // 3. 递归的出口
        // return;
    }
    
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     * No Recursion
     */
    public List<List<Integer>> subsetsNoRecursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        Arrays.sort(nums);
        
        // 1 << n is 2^n
        // each subset equals to an binary integer between 0 .. 2^n - 1
        // 0 -> 000 -> []
        // 1 -> 001 -> [1]
        // 2 -> 010 -> [2]
        // ..
        // 7 -> 111 -> [1,2,3]
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<Integer>();
            for (int j = 0; j < n; j++) {
                // check whether the jth digit in i's binary representation is 1
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }
	
    public static void main(String[] args) {
    	SubsetString sol = new SubsetString();
    	int[] nums = {1, 2, 2};
    	System.out.println(sol.subsets(nums));
	}
    
}
