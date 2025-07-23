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
    public static int substring = 1 ;
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int i = 0 ; i<word.length() ; i++){
            int idx = word.charAt(i)-'a';
            if(curr.children[idx]== null){
                curr.children[idx]=new Node();
                //either this or we can make another function just to calculate count
                substring++;
            }
            curr = curr.children[idx];
        }
         
        curr.eow = true;
    }
    
    public static int countNodes(Node root){
        if(root==null){
            return 0;
        }
        
        int count=0;
        for(int i = 0 ; i<26 ; i++){
            if(root.children[i]!=null){
                count+=countNodes(root.children[i]);
            }
        }
        return count+1; //including itself
    }
    

     public static void countUniqueSubstrings(String str) {
        for (int i = 0; i <str.length(); i++) {
            insert(str.substring(i)); // Insert all suffixes
        }
        int count = countNodes(root);
        System.out.println(count);
    }


   
    public static void main(String[] args) {
        String str = "ababa";
        countUniqueSubstrings(str);
            

    }
}
