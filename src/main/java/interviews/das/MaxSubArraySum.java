package interviews.das;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int n[]={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(getMaxSubArraySum(n));
//
    }

    private static int getMaxSubArraySum(int[] n) {
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n.length;i++){
            sum+=n[i];
            maxSum=Math.max(maxSum,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }
}
