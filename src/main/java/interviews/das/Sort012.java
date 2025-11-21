package interviews.das;

public class Sort012 {

    public static void main(String[] args) {
        int nums[]={1,2,0,2,1,0};

        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<high){
            if(nums[mid]==0){
               if(nums[low]!=0){
                   int temp=nums[low];
                   nums[low]=nums[mid];
                   nums[mid]=temp;
               }
                low++;
                mid++;
            }else if (nums[mid]==1){
                mid++;
            }else{
                if(nums[high]!=2){
                    int temp=nums[high];
                    nums[high]=nums[mid];
                    nums[mid]=temp;
                }
                high--;
            }
        }
        for(int n:nums){
            System.out.println(n);
        }
    }

}
