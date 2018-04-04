const BIT_SIZE: usize = 32;
fn get_bit(n:i32, k:usize) -> i32{
    if n & (1<<k) !=0{
        return 1
    }
    return 0
}
fn bit_wise_or(arr: &[i32]) -> i32{
    let mut bit_freq = [0; BIT_SIZE]; //Array of BIT_SIZE element
    let n = arr.len();
    let mut result = 0; 
    for i in 0..n {
        for k in (0usize .. BIT_SIZE).rev(){
            bit_freq[k] += get_bit(arr[i], k);
        }
    }
    for j in (0usize .. BIT_SIZE).rev(){
        while bit_freq[j] > 0 {
            result += (1 << j) * (1 << (n as i32- bit_freq[j]));
            bit_freq[j]-=1;
        }
     }
     result
}

fn main() {
    let arr: [i32; 3] = [1, 5, 6];
    println!("array: {:?}", arr);
    println!("{}", bit_wise_or(&arr));
}
