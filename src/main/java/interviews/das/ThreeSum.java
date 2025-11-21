package interviews.das;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i< nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            int m=i+1;
            int l=nums.length-1;
            int target = -nums[i];
            while(m<l){
                int sum= nums[m]+nums[l];
                if(sum==target){
                    result.add(Arrays.asList(nums[i],nums[m],nums[l]));
                    while(m<l && nums[m]==nums[m+1] ) m++;
                    while(m<l && nums[l]==nums[l-1]) l--;
                    m++;
                    l--;
                }else if (sum< target){
                    m++;
                }else {
                    l--;
                }

            }
        }

        return result;
    }
    public static void main(String[] args) {

        int nums[] = {-1,0,1,2,-1,-4};
        List<List<Integer>> result= threeSum(nums);
        System.out.println(result);

    }
}
