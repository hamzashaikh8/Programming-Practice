import java.util.HashMap;

public class palindrome {
    //Given a string, determine if it is almost a palindrome A string is almost a palindrome if it becomes a palindrome by
    //removing 1 letter. Consider only alphanumeric characters and ignore case sensitivity.
    public static void main(String [] args){
        String str = "Tact coa";
        System.out.print(permutationPalindrome(str));


    }
    //Optimal Solution
    //Time Complexity: O(n)
    static boolean AlmostPalindrome(String s){
        s=s.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").toLowerCase();
        int p1=0,p2=s.length()-1;
        while (p1<p2){
            if (s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            } else{
                return (subPalindrome(s,p1+1,p2) || subPalindrome(s,p1,p2-1));
            }
        }
        return true;
    }
    //subPalindrome function to lower time complexity of the outer while loop as all elements will only be viewed once
    static boolean subPalindrome(String s,int left, int right){
        while (left<right){
            if (s.charAt(left) == s.charAt(right)){
                left++;
                right++;
            }else{
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(String s){
        s= s.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").toLowerCase();
        int p1=0,p2=s.length()-1;
        while (p1<p2){
            if (s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            }
            else
                return false;
        }
        return true;
    }

    //Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    //A palindrome is a word of phrase that is the same forwards and backwards. A permutation is a rearrangement of letters
    //The palindrome does not need to be limited to just dictionary words.
    static boolean permutationPalindrome(String s){
        //Here we have two possibilities, either the length of the string is odd or even.
        // In which case there can only be one odd char for it to be a permutation of a palindrome, each other char must be present even amount of times
        s= s.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "").toLowerCase();
        int [] table = new int[Character.getNumericValue('z')- Character.getNumericValue('a')+1];
        int c;
        int oddcount=0;
        for (int i=0;i<s.length();i++){
            c = Character.getNumericValue(s.charAt(i)) - Character.getNumericValue('a');
            table[c]++;
            if (table[c]%2==0)
                oddcount--;
            else oddcount++;
        }
        return oddcount<=1;
    }
}
