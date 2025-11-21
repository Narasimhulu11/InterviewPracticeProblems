package interviews.das;

public class ArraySumTarget {
    public static void main(String args[]) {
        int n[]={1,2,3,4,6,8};
        int target=8;
        int r[]=getSumIndices(n,target);
        getSumIndices2(n,target);
        System.out.println(r[0] +" "+r[1]);
    }

    private static void getSumIndices2(int[] n, int target) {
        int i=0;
        int j=n.length-1;
        while (i<j){
            int sum=n[i]+n[j];
            if(target == sum){
                System.out.println(i+" "+j);
                break;
            }else if(sum<target){
                i++;
            }else{
                j--;
            }
        }

    }

    private static int[] getSumIndices(int[] n, int target) {
        int i=0;
        int j=1;
        int r[]= new int[2];
        while(j< n.length && i<n.length){
            if(target-n[i]==n[j]){
               r[0]=i;
               r[1]=j;
               break;
            }
            if(j==n.length-1 && i<n.length){
                i++;
                j=i+1;
            }else{
                j++;
            }
        }
        return r;
    }
}
