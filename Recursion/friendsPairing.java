package Recursion;

public class friendsPairing {

    public static int friendsPairingProblem(int n){

        if(n==0||n==1){
            return 1;
        }
        
        //choices
        int single = friendsPairingProblem(n-1);
        int paired = (n-1)*friendsPairingProblem(n-2);

        return single+paired;
    }
    public static void main(String[] args) {
        
        System.out.println(friendsPairingProblem(3));
    }
}
