import java.util.*;
public class SumORSubset{
    static final int INTSIZE =32;
    static int getBit(int n, int k){
        return (n & (1<<k)) != 0 ? 1 : 0;
    }
    static int bitWiseOR(  int [] arr ){
        int result = 0;
        int n = arr.length;
        Vector<Integer> bitFreq = new Vector<Integer>(INTSIZE);
        for(int i = 0;i<INTSIZE;i++){
            bitFreq.add(0);
        } 
        
        for(int i = 0   ;i<n;i++){
            for (int k = INTSIZE-1; k>=0; k--){
                bitFreq.set(k,bitFreq.get(k)+getBit(arr[i],k));
            }
            
         }
    for (int i=0; i < INTSIZE; ++i){
        int count = bitFreq.get(i);
        while(count>0){
            result+= Math.pow(2,i)*Math.pow(2,n-count--);
        }
    }
    return result;
    }

public static void main(String args[]){
    int [] arr = { 1, 2, 3};
    System.out.println(bitWiseOR(arr));
    }
}