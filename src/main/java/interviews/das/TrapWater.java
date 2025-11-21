package interviews.das;
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
 */
public class TrapWater {

    public static void main(String[] args) {

        int height[]={1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxTrapArea(height));
        int height1[]={1,1};
        System.out.println(getMaxTrapArea(height1));
        int height2[]={1,8,20,21,5,4,8,3,20};
        System.out.println(getMaxTrapArea(height2));

    }

    private static int getMaxTrapArea(int[] height) {

        if(null==height && height.length==0){
            return 0;
        }
        int area=0;
        int i=0;
        int j=height.length-1;
        while (i<j){
            int k=j-i;
            if(height[i]<height[j]){
                area= Math.max(area,k*height[i]);
                i++;
            }else{
                area= Math.max(area,k*height[j]);
                j--;
            }
        }

        return area;
    }
}
