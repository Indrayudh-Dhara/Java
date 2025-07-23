package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class anagram {

    public static void groupAnagram(String[] words){
        HashMap<String , List<String>> hp = new HashMap<>();

         for(String word : words){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String keys = new String(chars);//if we dont make this and directly pass it using toString is stores the reference variable not the actual string 
            if(hp.containsKey(keys)){
                List<String> list =hp.get(keys);
                list.add(word);
                hp.put(keys, list);
            }else{
                 List<String> list = new ArrayList<>();
                 list.add(word);
                hp.put(keys, list );
            }        
        }

        List<List<String>> anagrams = new ArrayList<>();
        Set<String> set = hp.keySet();
        for(String s : set){
            anagrams.add(hp.get(s));
        }

        System.out.println(anagrams);
    }
    public static void main(String[] args) {
        String words[] = { "eat" , "tea" , "tan" , "ate" , "nat" , "bar"};
       
        groupAnagram(words);
    }
}
