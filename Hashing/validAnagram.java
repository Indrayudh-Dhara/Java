package Hashing;

import java.util.HashMap;


public class validAnagram {


    public static boolean code(String s , String t){
    
        HashMap<Character , Integer> chars = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i = 0 ; i<s.length() ; i++){
            if(chars.containsKey(s.charAt(i))){
                chars.put(s.charAt(i), chars.get(s.charAt(i))+1);

            }else{
                chars.put(s.charAt(i), 1);
            }
        }
        //all the frequencies are now added 
        for(int i = 0 ; i<t.length() ; i++){
            if(chars.get(t.charAt(i))==null){
                return false;
            }
            chars.put(t.charAt(i), chars.get(t.charAt(i))-1);
            if(chars.get(t.charAt(i))==0){
                chars.remove(t.charAt(i));
            }
        }
        return chars.isEmpty();
    }
    public static void main(String[] args) {
        String s = "keen";
        String t = "klee";

        System.out.println(code(s, t));
    
    }
}
