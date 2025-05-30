package Backtracking;

public class subsets {

    public static void subsetsCode(String str , int i , String newStr){
        if(i==str.length()){
            System.out.println(newStr);
            return;
        }
        char n = str.charAt(i);
        //yes
        subsetsCode(str, i+1, newStr+n);
        //no
        subsetsCode(str, i+1, newStr);
        
    
    }
    public static void main(String[] args) {
        subsetsCode("abc", 0, "");
    }
}
