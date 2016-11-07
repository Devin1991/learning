/**
 * Created by wang on 2016/11/7.
 */
public class Prime {
    public static void main(String[] args){
        for(int i=2;i<1000;i++ ){
            if(2>Math.sqrt(i)){
                System.out.print(i + "\t");
            }else {
                if(isPrime(i)){
                    System.out.print(i + "\t");
                }
            }
        }
    }

    private static boolean isPrime(int num) {
        Boolean flag = false;
        for(int i=2;i<Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }else
                flag = true;
        }
        return flag;
    }
}
