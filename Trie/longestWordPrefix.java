package Trie;


public class longestWordPrefix {
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
    //children - array in that Node containing data for its children(next level)
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

    public static void longest(String[] words){
        for(String word : words){
            insert(word);
        }
        String longest ="";
        
        for(String word : words){
            boolean exists = true;
            for(int i = 1 ; i<=word.length() ; i++){
                if(!search(word.substring(0, i))){
                    exists=false;
                };
            }
            if(exists){
                if(longest.length()<word.length()){
                    longest=word;
                }else if(longest.length()==word.length() && word.compareTo(longest)<0){
                    longest=word;
                }
            }
           
        }
        System.out.println(longest);
    }
    public static String ans = "";

    public static void longestV2(Node root , StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i = 0 ;i<26 ; i++){
            if(root.children[i] != null && root.children[i].eow==true){
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>ans.length()){
                    ans = temp.toString();
                }
                longestV2(root.children[i] , temp);
                //backtrack
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "a" , "banana" , "app" , "appl" , "ap" , "apply" , "apple"};
       

      longestV2(root, new StringBuilder(""));
      System.out.println(ans);
    }
}

