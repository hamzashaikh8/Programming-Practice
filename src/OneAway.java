public class OneAway {
    public static void main(String [] args){
        String s="pale";
        String t="pake";
        System.out.println(isOneAway(s,t));

    }

    /*
    Problem: There are three types of edits that can be performed on strings, insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if they are
    one edit (or zero edits) away
    EXAMPLE
    pale, ple -> true
    pales. pale -> true
    pale. bale -> true
    pale. bake -> false
     */

    static boolean isOneAway(String s, String t){
        if (s.length() == t.length())
            return OneEditReplace(s,t);
        else if (s.length() + 1 == t.length())
            return OneEditInsert(s,t);
        else if (s.length() - 1 == t.length())
            return OneEditInsert(t, s);
        return false;
    }

    static boolean OneEditReplace(String s,String t){
        boolean found=false;
        //check if there is only one char that changes
        //assume same length because of replace
        for (int i=0;i<s.length();i++){
            if (!(s.charAt(i) == t.charAt(i))) {
                if (found)
                    return false;
                found =true;
            }
        }
        return true;
    }

    static boolean OneEditInsert(String s, String t){
        int p1=0;
        int p2=0;
        boolean found=false;
        while (p1<s.length() && p2< t.length()){
            if (s.charAt(p1) != t.charAt(p2)){
                if (found)
                    return false;
                found = true;
                p2++;
            }else{
                p1++;
                p2++;
            }
        }
        return true;
    }

}
