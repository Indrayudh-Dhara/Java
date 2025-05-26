package Recursion;

public class powerCalculation {  

    //x^n

    public static int power(int x , int n){
        //base case
        if(n==0){
            return 1;
        }
        

        return x*power(x, n-1);
        
    }

    //optimized => n=rootn*rootn   

    public static int optimizedPower(int x , int n){
        if(n==0){
            return 1;
        }

        int halfpower = optimizedPower(x, n/2);
        int halfpowerSq = halfpower*halfpower;

        if(n%2!=0){
            return x*halfpowerSq;
        }
        return halfpowerSq;
    }

    public static void main(String[] args) {
        System.out.println(optimizedPower(2, 10));
    }
}
