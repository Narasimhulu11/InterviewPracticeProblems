package interviews.das;

public class MoveZeroes {

    public static void main(String[] args) {
        int nums[]={0,1,0,3,12};
        getMoveZeroes(nums);
    }

    private static void getMoveZeroes(int[] nums) {

        int i=0;
        int j=i+1;

        while(i<nums.length && j<nums.length){

            if(nums[i]==0 && nums[j]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
                i++;
            }else {
                j++;
            }

        }

        for(int n:nums){
            System.out.println(n);
        }
    }
}
