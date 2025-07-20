package Trie;

public class wordBreak {
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

    public static boolean wordBreakCode(String key){ //only key as we are searching in a trie not in the word array
        if(key.length()==0){ //case when all the substring isin the first half(left) and word break is calling for an empty one 
            return true;
        }
        
        for(int i = 1  ; i<=key.length() ; i++){
            if(search(key.substring(0,i)) && wordBreakCode(key.substring(i))){
                return true;
            }
        }
        return false;
       
    }

    //DRY RUN 
//     📩 CALL: wordBreakCode("ilikesamsung")
//   🔍 Try prefix: "i"
//   ✅ Found "i" → Recurse on "likesamsung"
  
//   📩 CALL: wordBreakCode("likesamsung")
//     🔍 Try prefix: "l" ❌ not in Trie (skip)
//     🔍 Try prefix: "li" ❌ skip
//     🔍 Try prefix: "lik" ❌ skip
//     🔍 Try prefix: "like"
//     ✅ Found "like" → Recurse on "samsung"
    
//     📩 CALL: wordBreakCode("samsung")
//       🔍 Try prefix: "s" ❌
//       🔍 Try prefix: "sa" ❌
//       🔍 Try prefix: "sam"
//       ✅ Found "sam" → Recurse on "sung"

//       📩 CALL: wordBreakCode("sung")
//         🔍 Try prefix: "s" ❌
//         🔍 Try prefix: "su" ❌
//         🔍 Try prefix: "sun" ❌
//         🔍 Try prefix: "sung" ❌
//         ❌ No valid split for "sung" → return false
//       ↩️ RETURN: false to "samsung"

//       🔍 Try prefix: "sams" ❌
//       🔍 Try prefix: "samsu" ❌
//       🔍 Try prefix: "samsun" ❌
//       🔍 Try prefix: "samsung"
//       ✅ Found "samsung" → Recurse on ""

//       📩 CALL: wordBreakCode("")
//         ✅ Empty key → return true
//       ✅ "samsung" can be segmented → return true
//     ✅ "likesamsung" can be segmented → return true
//   ✅ "ilikesamsung" can be segmented → return true

    public static void main(String[] args) {
        String words[] = { "i" , "like" , "sam" , "samsung" , "mobile" , "ice"};
        for(String word : words){
            insert(word);
        }

        System.out.println(wordBreakCode("ilikesamsung"));
        
    }
}
