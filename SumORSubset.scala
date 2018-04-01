import java.util.Arrays
object SumORSubset extends App{
    val INT_SIZE = 32
    def getBit(n: Int, k: Int): Int = {
         val bit = if ((n & (1<<k)) !=0)  1 else 0
         bit
     }
    def bitWiseOR(arr: Array[Int]):Int ={
        val bitFreq = new Array [Int] (INT_SIZE)
        val n = arr.length
        var result = 0.0
        for(i <- 0 until n){
            for(k <-INT_SIZE -1 to 0 by -1){
                bitFreq(k) += getBit(arr(i), k)
            }
        }
         for(i <- 0 until INT_SIZE){
           for(count <- bitFreq(i) until 0 by -1){
                result+= Math.pow(2,i)*Math.pow(2,n-count)
            }
         }
         result.toInt

    }
    val arr:Array[Int] = Array(1 , 2 ,3)
    //println(Arrays.toString(arr));
    println(bitWiseOR(arr))
}
