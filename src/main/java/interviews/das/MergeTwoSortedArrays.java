package interviews.das;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int m1[]={1,2,3};
        int n1[]={2,3,4};

        int m2[]={1};
        int n2[]={};
        int m=1;
        int n=0;
        int r[]=getMergedArray(m2,m,n2,n);
        for(int i: r){
            System.out.println(i);
        }
    }

    private static int[] getMergedArray(int[] m1, int m, int[] n1, int n) {
        int r[] = new int[m+n];
        int i=0;
        int j=0;
        boolean leftDone=false;
        boolean rightDone=false;
        if(m==0){
            return n1;
        }
        if(n==0){
            return m1;
        }
        while(i<m && j<n) {
            if (m1[i] < n1[j]) {
                r[i + j] = m1[i];
                i++;
                if (i == m) {
                    leftDone = true;
                }
            } else {
                r[i + j] = n1[j];
                j++;
                if (j == n) {
                    rightDone = true;
                }
            }
            if(leftDone){
                while(j<n){
                    r[i+j]=n1[j];
                    j++;
                }
            }
            if(rightDone){
                while(i<m){
                    r[i+j]=m1[i];
                    i++;
                }
            }
        }
        return r;
    }
}
