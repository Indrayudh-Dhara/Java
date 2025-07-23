package Trie;

import java.util.ArrayList;

public class prefix {
      static class Node{
        Node[] children = new Node[26]; // array of 26 (made for every node) which stores node address in corresponding indexed wrt to the chars 
        boolean eow = false ; //end of word flag
        int freq;
        Node(){
            for(int i = 0 ; i < children.length ; i++){
                children[i]=null;
            }
            this.freq=1;
        }
    }

    public static Node root = new Node();

    //curr - NODE
    //root - NODE
    //children - array in that Node containing data for its children(next level)
    //eow - flag in that node

    //function to insert a single word in a trie (level wise insertion for every char of a word )
    public static void insert(String word){
        Node curr = root;
        for(int level=  0 ; level<word.length() ; level++){
            if(curr.children[word.charAt(level)-'a']==null){
                curr.children[word.charAt(level)-'a']=new Node();//storing a node address in the index which represents the curr character (not the character itself)
            }else{
                curr.children[word.charAt(level)-'a'].freq++;
            }
            
            curr=curr.children[word.charAt(level)-'a'];//updating current and going to the node we just entered for the level wise traversal
       
        }
        //after all letters of the word is inserted , mark word is complete
        curr.eow = true;
    }

    public static void prefixCode(String words[]){
        ArrayList<StringBuilder> prefixList = new ArrayList<>();
        for(String word : words){
            Node curr = root;
           
            StringBuilder prefix = new StringBuilder();
            for(int i = 0 ; i<word.length() ; i++){
                int idx = word.charAt(i)-'a';
                prefix.append(word.charAt(i));
                curr = curr.children[idx];
                if(curr.freq==1){
                    break;
                }
            }
            prefixList.add(prefix);
        }
        System.out.println(prefixList);
    }

    public static void prefixRecursive(Node root  , String ans ){
        
        if(root == null){
            return;
        }

        if(root.freq == 1){
            System.out.println(ans);
            return;
        }

        
        for(int i = 0 ; i<root.children.length ; i++){
            if(root.children[i]!=null){
                prefixRecursive(root.children[i], ans+(char)(i+'a'));
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "zebra" , "dog" , "duck" , "dove"};
        for(String word : words){
            insert(word);
        }
        root.freq = -1; //for the recusive function to not stop at root all the time
        prefixRecursive(root, "");
        prefixCode(words);
    }
}
