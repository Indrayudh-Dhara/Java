import java.util.*;
public class Strings{
    //palindrome check function
    public static boolean checkPalindrome(String str){
        String checkStr="";
        for(int i=0 ; i<=str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void checkLowerCase(String str){
        int count=0;
       for(int i = 0 ; i<str.length();i++){
        if(Character.toLowerCase(str.charAt(i))==str.charAt(i)){
            count++;
        }
       }
       System.out.println(count);
    }
    public static void checkAnagram(StringBuilder first,StringBuilder second){
        int count=0;
        if(first.length()==second.length()){
            for(int i = 0;i<first.length();i++){
                for(int j = 0 ; j<second.length();j++){
                    if(first.charAt(i)==second.charAt(j)){
                        count++;
                        second.deleteCharAt(j);
                    }
                }
            }
            if(count==first.length()){
                System.out.println("yes it is an anagram");
            }else{
                System.out.println("it is not an anagram");
            }
        }else{
            System.out.println("it is not an anagram");
        }
        
    }

    public static void checkAnagram2(){
        
    }
    //
    public static void main(String[] args) {
        StringBuilder first = new StringBuilder("raceer");
        StringBuilder second = new StringBuilder("caree");
                // String strNew = "hi , i am indrayudh";
        // for(int i = 0 ; i<strNew.length();i++){
        //     if(i==0 || strNew.charAt(i-1)==' '){
        //         Character.toUpperCase(strNew.charAt(i));
        //     }
        // }
        // System.out.println(strNew);
        // checkLowerCase(str);
        checkAnagram(first, second);
        
    }
}