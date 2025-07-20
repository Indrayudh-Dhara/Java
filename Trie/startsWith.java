package Trie;

public class startsWith {
   static class Node{
        Node[] children = new Node[26]; // array of 26 (made for every node) which stores node address in corresponding indexed wrt to the chars 
        boolean eow = false ; //end of word flag
        Node(){
            for(int i = 0 ; i < children.length ; i++){
                children[i]=null;
            }
        }
    }

    public static Node root = new Node();

    //curr - NODE
    //root - NODE
    //children - array in that Node containing data(reference of its children node) for its children(next level)
    //eow - flag in that node

    //function to insert a single word in a trie (level wise insertion for every char of a word )
    public static void insert(String word){
        Node curr = root;
        for(int level=  0 ; level<word.length() ; level++){
            if(curr.children[word.charAt(level)-'a']==null){
                curr.children[word.charAt(level)-'a']=new Node();//storing a node address in the index which represents the curr character (not the character itself)
            }
            curr=curr.children[word.charAt(level)-'a'];//updating current for the level wise traversal
        }
        //after all letters of the word is inserted , mark word is complete
        curr.eow = true;
    }

    public static boolean search(String word){ ///O(L)
        Node curr = root;
        for(int level = 0 ; level<word.length() ; level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }

    public static boolean code(String prefix){
        Node curr = root;
        for(int i = 0  ;i<prefix.length() ; i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx] == null ){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        String words[] = { "apple" , "app" , "mango" , "man" , "women"};
        for(String word : words){
            insert(word);
        }
        System.out.println(code("app"));

    }
}
