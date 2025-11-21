package interviews.das;

import java.util.stream.Stream;

public class Temperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        //  int i=0;
        int res[] = new int[temperatures.length];
       /* while(i<temperatures.length){
            int j=i+1;
            while(j<temperatures.length){
                if(temperatures[j]>temperatures[i]){
                    res[i]=j-i;
                    break;
                }
                j++;
            }
            i++;
        }*/
        int j=0, n= temperatures.length;
        for(int i=0;i<n-1;i++){
            if(temperatures[i+1]>temperatures[i]){
                res[j]=1;
                j++;
            }else{
                int k = 1;
                while((i+k)< n && temperatures[i+k]<temperatures[i]){
                    k++;
                }
                if((i+k)< n && temperatures[i+k] > temperatures[i]){
                    res[j]=k;
                }else{
                    res[j]=0;
                }

                j++;
            }
        }
        for(int a:res){
            System.out.print(a);
        }
        return res;
    }
    public static void main(String args[]){
        int[] arr = {73,74,75,71,69,72,76,73};
        Temperature.dailyTemperatures(arr);
    }
}
