package interviews.das;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 */
public class TrapingWater {

    public static void main(String[] args) {
        int n[]={4,2,0,3,2,5};
        System.out.println(trappedWater(n));
    }

    private static int trappedWater(int[] n) {
        int left=0;
        int right=n.length-1;
        int leftMax=0;
        int rightMax=0;
        int water=0;
            while(left<right){
                if(n[left]<n[right]){
                    if(n[left]>=leftMax){
                        leftMax=n[left];
                    }else{
                        water+=leftMax-n[left];
                    }
                    left++;
                }else{
                    if(n[right]>=rightMax){
                        rightMax=n[right];
                    }else{
                        water+= rightMax-n[right];
                    }
                    right--;
                }
            }
        return water;
    }
}
