import java.util.*;
public class validparentheses {
    public static void main(String []args){
        makeValid("a(bc(d)");
    }

    /*
        Problem: Given a string containing only parentheses, determine if it is valid.
        The string is valid if all parentheses close.
     */
    static boolean isValid(String s){
        HashMap<String, String> parens = new HashMap<>();
        parens.put("(",")");
        parens.put("{","}");
        parens.put("[","]");
        if (s.length()==1)
            return true;
        Stack<String> stack = new Stack<String>();
        for (int i=0;i<s.length();i++){
            if (parens.values().contains(Character.toString(s.charAt(i)))){
                try{
                    String l = stack.pop();
                    if (!parens.get(l).equals(Character.toString(s.charAt(i)))){
                        System.out.print("does not equal");
                        return false;
                    }
                }catch(EmptyStackException e){System.out.print("empty stack"); return false;}
            }else{
                stack.push(Character.toString(s.charAt(i)));
            }
        }
        return true;
    }
    /*
        Problem: Given a string only containing round brackets '(' and ')' and lowercase characters,
        remove the least amount of brackets so the string is valid.
        A string is considered valid if it is empty or if there are brackets, they all close.
        **********
        Constaints:
        1. What do we return from our algorithm? Return a valid String
        2. Will there ever be spaces in a string? No
        3. Is a string containing only lowercase characters valid? Yes
     */
    static String makeValid(String s){
        Stack<Integer> stack = new Stack<Integer>(); //this stack will hold the indexes of parentheses
        LinkedList<String> word = new LinkedList<>(Arrays.asList(s.split("")));
        for (int i=0;i<word.size();i++){
            if (word.get(i).equals("(")) {
                stack.push(i);
            }
            else if (word.get(i).equals(")")){
                if (stack.size()>0){
                    stack.pop();
                }else {
                    word.remove(i);
                    i--;
                }
            }
        }
        while(!stack.isEmpty()){
            int x = stack.pop();
            word.remove(x);
        }

        String ans="";
        for (int i=0;i<word.size();i++){
            ans=ans+word.get(i);
        }
        System.out.print("\n"+ans);
        return ans;
    }
}
