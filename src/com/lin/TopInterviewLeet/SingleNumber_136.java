package com.lin.TopInterviewLeet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and
without using extra memory?



Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1


Constraints:

1 <= nums.length <= 3 * 104
-3 * 104 <= nums[i] <= 3 * 104
Each element in the array appears twice except for one element which appears only once.

 */
public class SingleNumber_136 {

    public static void main(String[] args){
        int[] nums={2,2,3,4,3,4,5,6,5};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums){
//       Map<Integer, Integer> map= new HashMap<>();
//       int singleNumber=0;
//       for(int i: nums){
//           map.put(i, map.getOrDefault(i,0)+1);
//       }
//       for(int i=0;i<nums.length;i++){
//           if(map.get(nums[i])==1){
//               singleNumber=  nums[i];
//           }
//       }
//       return singleNumber;
        Arrays.sort(nums);
        int i=0;
        int end=nums.length-1;
        int singleNumber=0;
        if(nums[end]!=nums[end-1]){
            singleNumber=nums[end];
        }
        while(i<(end-1)){
            if(nums[i+1]!=nums[i]){
                singleNumber=nums[i];
            }
            i=i+2;
        }

        return singleNumber;
    }
}
