import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;

public class te {
    public static void main(String []args){
        System.out.println("");
        System.out.print(uniqueChar2("abc"));

    }
    /*
        Problem: Implement an algorithm to determine if a string has all unique
        characters. What if you cannot use additional structures
     */
    static boolean uniqueChar(String s1){
        char temp[] = s1.toCharArray();
        Arrays.sort(temp);
        s1 = new String(temp);
        System.out.print(s1);
        for (int i=0;i<s1.length();i++){
            try{
                if (s1.charAt(i+1)<=s1.charAt(i))
                    return false;
            }catch(IndexOutOfBoundsException e){
                System.out.print(e);
            }
        }
        return true;
    }
    static boolean uniqueChar2(String s1){
        Hashtable<Character,Boolean> table = new Hashtable<Character,Boolean>();
        for (int i=0;i<s1.length();i++){
            if (table.containsKey(s1.charAt(i))){
                return false;
            }
            table.put(s1.charAt(i),true);
        }
        return true;
    }
}
