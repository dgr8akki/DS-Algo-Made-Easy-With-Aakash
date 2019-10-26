package Leetcode;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        int sumOfFirstNNaturalNumber = (n * (n - 1)) / 2;
        int currentSum = 0;
        for(int num: nums)
            currentSum += num;
        return sumOfFirstNNaturalNumber - currentSum;
    }
}