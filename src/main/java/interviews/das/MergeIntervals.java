package interviews.das;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int [][]intervals = {{1,3},{2,6},{8,10},{15,18}};
        merge(intervals);
        mergeIntervals(intervals);

    }

    private static void mergeIntervals(int[][] intervals) {
        List<List<Integer>> integerss= new ArrayList<>();
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->Integer.compare(a[0],b[0]));

        int i=0;
        for(int j=1;j< intervals.length;j++){
            if(intervals[i][1]>=intervals[j][0]){
                intervals[i][1]=Math.max(intervals[i][1],intervals[j][1]);
            }else{
                i++;
                intervals[i]=intervals[j];
            }
        }
        int [][]result=new int[i+1][2];
        for(int k=0;k<=i;k++){
            result[k][0]=intervals[k][0];
            result[k][1]=intervals[k][1];
        }
        return result;
    }
}
