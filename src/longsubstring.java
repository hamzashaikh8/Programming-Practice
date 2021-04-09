import java.util.*;
public class longsubstring {

    public static void main(String[] args){
    String test = " ";
    System.out.println(longstring2(test));
    }
    //Given a string, find the length of the longest substring without repeating characters
    /* Constraints:
    Is the substring contiguous (no breaks in between them)? Yes
    Does case sensitivity matter? No
     */

    //Non optimal solution
    public static int longsub(String s){
        int longest,pntr,pntr2;
        longest=pntr=pntr2=0;
        ArrayList<String> list = new ArrayList<String>();

        while (pntr<s.length()) {
            if (list.contains(Character.toString(s.charAt(pntr)))){
                pntr=pntr2+1;
                pntr2=pntr;
                list.removeAll(list); //reinitialize list
            }
            else{
                list.add(Character.toString(s.charAt(pntr)));
                pntr++;
            }
            longest=Math.max(longest,list.size());
        }
        return longest;
    }

    static ArrayList<String> StringtoList(String s){
        ArrayList<String> lst = new ArrayList<String>();
        for (int i=0;i<s.length();i++){
            lst.add(Character.toString(s.charAt(i)));
        }
        return lst;
    }

    //Optimal Solution
    static int longstring2(String s){
        int longest=0,lpntr=0,prevl=0;
        Hashtable<String,Integer> htable = new Hashtable<String, Integer>();
        for (int i=0;i<s.length();i++){
            if (!htable.containsKey(Character.toString(s.charAt(i)))){
                htable.put(Character.toString(s.charAt(i)),i);
            }
            else{
                prevl = htable.get(Character.toString(s.charAt(i)));
                htable.replace(Character.toString(s.charAt(i)),i);
            }
            if (prevl >= lpntr){
                lpntr = prevl + 1;
            }
            longest = Math.max(longest, i - lpntr+1);
        }
        return longest;
    }

}
