package com.lushixiang.leetcode.Q560;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int count = 0;
        for(int i = 0; i<length; i++){
            int sum = 0;
            for(int j = i; j<length; j++){
                sum = sum+nums[j];
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }
}
