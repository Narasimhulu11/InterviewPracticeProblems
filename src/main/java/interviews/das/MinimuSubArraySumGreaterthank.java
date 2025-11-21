package interviews.das;

public class MinimuSubArraySumGreaterthank {

    public static void main(String[] args) {
        int n[]={1,1,2,3,3,3,3,3,3,4};
        System.out.println(getMinimumsubarraylength(n));
    }

    private static int getMinimumsubarraylength(int[] n) {
        int i=0;
        int sum=0;
        int min= Integer.MAX_VALUE;
        int target=10;
        for(int j=0;j<n.length;j++){
            sum+=n[j];
            while(sum>=target){
                min=Math.min(min,j-i+1);
                sum-=n[i];
                i++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
