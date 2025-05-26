package Recursion;

public class binaryStrings {

    public static void binaryStringsPrint(int n , String str, int lastplace){
        if(n==0){
            System.out.println(str);
            return;
            
        }
        //choices
        //zero
       
        binaryStringsPrint(n-1, str+"0" , 0);
        
        //one
        if(lastplace==0){
        binaryStringsPrint(n-1, str+"1" , 1);
        }
       
    }

    public static void main(String[] args) {
        binaryStringsPrint(8, "" , 0);
    }
    
}
