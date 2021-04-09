import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.Arrays;
public class typedoutstring {
    /*Problem: Given two strings S and T, return if they equal
    when both are typed out. Any '#' that appears in the string counts as a backspace
     */
    //Step 1:Constraint: What happens when 2 #'s appear beside each other? Delete the two values before the first #
    //What happens to # when there is no character to remove? Nothing
    //Are two empty strings equal to each other? yes
    //Does case sensitivity matter? Yes
    //Step 2: Write down test cases
    public static void main(String[] args){
        String h = "ab#c";
        String t = "Ae#c";
        System.out.println(compstring2(h,t));


    }
    //Non optimal Solution
    //Time Complexity O(n)
    //Space Complexity O(s+t)
    public static boolean compstring(String s,String t){
        Stack <String> stk1 = buildStack(s);
        Stack <String> stk2 = buildStack(t);
        boolean flag=true;
        //compare stacks
        // Check if size of both stacks are same
        if (stk1.size() != stk2.size())
        {
            flag = false;
            return flag;
        }

        // Until the stacks are not empty
        // compare top of both stacks
        while (stk1.empty() == false)
        {
            // If the top elements of both stacks
            // are same
            System.out.println("here2");

            if (stk1.peek().equals(stk2.peek()))
            {
                // Pop top of both stacks
                stk1.pop();
                stk2.pop();
            }
            else
            {
                // Otherwise, set flag to false
                flag = false;
                break;
            }
        }
        return flag;
    }

    static Stack<String> buildStack(String s){
        Stack<String> stk = new Stack<String>();
        for (int i=0; i<s.length();i++){
            if (s.charAt(i) == '#')
                try{
                    stk.pop();
                }catch (EmptyStackException e){
                    System.out.println("stack is empty");
                }
            else
                stk.push(Character.toString(s.charAt(i)));
        }
        return stk;
    }
    //optimal solution --> reduce space complexity
    //we will use the two pointer technique from the right to left as when you encounter # you need to backspace which removes from left to right
    //Goal: compare two strings, we do not necessarily need to to modify the strings themselves through data structures
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    static boolean compstring2(String s, String t){
        int p1,p2,count1,count2;
        count1=count2=0;
        p1=s.length()-1;
        p2=t.length()-1;
        while (p1>=0 || p2>=0){
            System.out.println("**********");
            System.out.println("p1: "+p1);
            System.out.println("p2: "+p2);
            System.out.println("char at p1: "+s.charAt(p1));
            System.out.println("char at p2: "+t.charAt(p2));
            if (s.charAt(p1) == '#') {
                count1=2;
                while (count1>0){
                    p1--;
                    count1--;
                    if(s.charAt(p1) == '#')
                        count1+=2;
                }
            }
            else if (t.charAt(p2) == '#') {
                count2=2;
                while (count2>0){
                    p2--;
                    count2--;
                    if(t.charAt(p2) == '#')
                        count2+=2;
                }
            }
            else {
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                } else {
                    p1--;
                    p2--;
                }

            }
        }
        return true;
    }

}
