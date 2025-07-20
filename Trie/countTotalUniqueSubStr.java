package Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class countTotalUniqueSubStr {

    static class Node{
        Node children[] = new Node[26];
        int freq=0 ;
        boolean eow ;
        public Node(){
            this.freq=1;
            for(int i = 0 ; i<children.length ; i++){
                children[i]= null;
            }
        }
    }
    public static int substring = 0 ;
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i = 0 ; i<word.length() ; i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]== null){

                curr.children[idx]=new Node();
                substring++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    ;
    

    public static void substring(String str){
        
        
        for(int i =  0 ;i<str.length() ; i++){
            insert(str.substring( i));
            
        }
       
    }
    public static void main(String[] args) {
        String str = "ababa";
        substring(str);
        System.out.println(substring);
        HashMap<Integer ,Integer> hp = new HashMap<>();
        

    }
}
