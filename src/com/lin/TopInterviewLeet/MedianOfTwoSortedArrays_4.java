package com.lin.TopInterviewLeet;
/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
Example 3:

Input: nums1 = [0,0], nums2 = [0,0]
Output: 0.00000
Example 4:

Input: nums1 = [], nums2 = [1]
Output: 1.00000
Example 5:

Input: nums1 = [2], nums2 = []
Output: 2.00000


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianOfTwoSortedArrays_4 {

    public static void main(String[] args){

        int[] nums1 = {1,3,8,34,50};
        int[] nums2 = {2,4,19,60,70};
        System.out.println(median(nums1, nums2));
    }

    public static double median(int[] arr1, int[] arr2){

        double median=0;

        if(arr1.length<0||arr1.length>100||arr2.length<0||arr2.length>100|| arr1.length+arr2.length<1||arr1.length+arr2.length>200) {
            return median;
        }

        Queue<Integer> priorityQue= new PriorityQueue<>();
        for(int i: arr1){
            if(i<Math.pow(10,-6)||i>Math.pow(10,6)){
                return  median;
            }
            priorityQue.add(i);
        }
        for(int i: arr2){
            if(i<Math.pow(10,-6)||i>Math.pow(10,6)){
                return  median;
            }
            priorityQue.add(i);
        }

        int [] arr3=new int[arr1.length+arr2.length];
        for(int i=0;i<arr3.length;i++){
            arr3[i]=priorityQue.poll();
        }
        System.out.println(Arrays.toString(arr3));

       int length=arr3.length;
       if(length%2!=0){
           median= (double) arr3[length/2];
       }
       else {
           median= ( (double) arr3[length/2-1]+ (double) arr3[length/2])/2;
       }

        return median;
    }

}
