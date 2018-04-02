import java.util.*;
public class SumORSubset{
    static final int BIT_SIZE =32;
    static int getBit(int n, int k){
        return (n & (1<<k)) != 0 ? 1 : 0;
    }
    static int bitWiseOR(  int [] arr ){
        int result = 0;
        int n = arr.length;
        Vector<Integer> bitFreq = new Vector<Integer>(BIT_SIZE);
        for(int i = 0;i<BIT_SIZE;i++){
            bitFreq.add(0);
        } 
        
        for(int i = 0;i<n;i++){
            for (int k = BIT_SIZE-1; k>=0; k--){
                bitFreq.set(k,bitFreq.get(k)+getBit(arr[i],k));
            }
            
         }
        for (int i=0; i < BIT_SIZE; ++i){
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
