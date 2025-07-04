import java.util.Stack;

public class simplifyPath {

    //my first thoughtful approach
    public static void code(String path){
        Stack<String> s = new Stack<>();
        String curr = "";
        for(int i = 1; i<path.length() ; i++){
            curr ="";
            while(path.charAt(i)!='/'){
                curr+=path.charAt(i);
                i++;
            }
            if(!curr.equals(".")&&!curr.equals("..")){ //dont use != use !.equals for strings
                s.push(curr);
            } if(curr.equals("..")){
                s.pop();
            }
        }

        //now stack has the exact simplified path 
        //building the simplified string
       StringBuilder newStr = new StringBuilder("");
        while(!s.isEmpty()){
           newStr.insert(0, s.pop());
        }
        //printing the simplified string
        System.out.println(newStr);
    }

    //my better approach using some help
    public static void codeV2(String str){
        Stack<String> s = new Stack<>();
        String[] paths = str.split("/"); //splits and stores the string between "/"s
        for(int i = 0 ; i<paths.length ; i++){
            if(paths[i].equals("") || paths[i].equals(".")){
                continue;
            }else if(paths[i].equals("..")){
                s.pop();
            }else{
                s.push(paths[i]);
            }
        }

        StringBuilder newStr = new StringBuilder("");
       for(int i = 0 ; i<s.size() ; i++){
        newStr.append("/").append(s.get(i)); //yes as stack extends vector everything has an index and we can ACCESS the elements through index (not lifo)
       }

       //for cases where the stack is completely empty ( a lot of cases can be there) we need to return something which is the root
       if(s.isEmpty()){
        newStr.append("/");
       }
        //printing the simplified string
        System.out.println(newStr);

    }
    public static void main(String[] args) {
        String str = "/a/./b/../../c/";
        codeV2(str);
        
    }
}
