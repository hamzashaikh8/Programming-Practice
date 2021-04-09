import java.util.Arrays;
import java.util.Scanner;

public class play {
    public static void main(String[] args){
        System.out.print(maxtime("23:5?"));

    }
    /*
        Problem: You are given a string that represents time in the format hh:mm. Some of the digits are blank (represented by ?).
        Fill in ? such that the time represented by this string is the maximum possible.
        Maximum time: 23:59, minimum time: 00:00. You can assume that input string is always valid.
     */
    static String maxtime(String s){
        String ans="";
        char [] time = s.toCharArray();
        if (time[0] == '?'){
            time[0] = (time[1] <= '3' || time[1] == '?')? '2':'1';
        }
        if (time[1] == '?'){
            time[1] = (time[0]< '2' || time[0] == '?')? '9':'3';
        }
        if (time[3] == '?'){
            time[3] = '5';
        }
        if (time[4] == '?'){
            time[4] = '9';
        }
        for (int i=0;i<time.length;i++)
            ans = ans +time[i];
        return ans;
    }
}
