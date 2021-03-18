package com.lin.TopInterviewLeet;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they
 add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

    public static void main(String[] args){
      int[] nums={2,7,11,23,10000000}; int target= 10000002;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target){
        if( nums.length<2|| nums.length>Math.pow(10,3)|| target<Math.pow(10,-9)||target>Math.pow(10,8)){
            return new int[] {};
        }

        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>Math.pow(10,9)||nums[i]<Math.pow(10,-9)){
                return new int[] {};
            }
            map.put(nums[i],i);
        }
        for(int i=0;i<map.size();i++){
            int comp=target-nums[i];
            if(map.containsKey(comp)&&map.get(comp)!=i){
                return new int[]{ i, map.get(comp)};
            }
        }

        return new int[] {};
    }
}
