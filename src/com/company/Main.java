package com.company;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	/* Problem: You are given an array of positive integers where
	each integer represents the height of a vertical line on a chart.
	Find two lines which together with the x-axis forms a container that
	would hold the greatest amount of water. Return the area of water it
	would hold
    */
        /*
           Questions:
           1. Do the lines in between given area affect the calculated area? No
           2. Are there duplicate values? Maybe
           3. Does the y axis affect the area? No
         */
        HashMap<Integer,ArrayList<Integer>> temp = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        int []arr = {2,3,4,5,18,17,6};
        System.out.println(container3(arr));

    }

    //non optimal solution
    //Time Complexity O(n^2)
    public static Integer container(int [] arr){
        HashMap<Integer, ArrayList<Integer>> temp = new HashMap<Integer,ArrayList<Integer>>();
        ArrayList<Integer> adder = new ArrayList<Integer>();
        Integer area,length,width,farea;
        farea=0;
        area=0;
        for (int i=0;i<arr.length;i++)
        {
            ArrayList<Integer> keyareas = new ArrayList<Integer>();
            for (int j=0; j<arr.length; j++){
                width = Math.abs(j-i);
                //smallest side will be the length
                length = Math.min(arr[i],arr[j]);
                area = width*length;
                System.out.println("*****************");
                System.out.println("i: "+ i +" arr[i]: "+arr[i] + " j: "+j+" arr[j]: "+arr[j]);
                System.out.println("width: "+width);
                System.out.println("length: "+ length);
                System.out.println("area: "+area);
                keyareas.add(area);
                //Now I got all the areas of i
                System.out.println(keyareas);
                if (j==arr.length-1){
                    temp.put(arr[i],keyareas);
                }
            }
            System.out.println(temp);
        }
        //Now that all the areas are stored in the hashmap, we will loop through them
        ArrayList<Integer> iareas = new ArrayList<Integer>();
        for (int k=0;k<temp.size();k++){
            iareas = temp.get(arr[k]);
            for (int z=0;z<iareas.size();z++){
                adder.add(iareas.get(z));
            }
        }
        System.out.println("all areas: "+ adder); //all areas are added here
        //Now we need to return the area and print out the two lines
       farea = Collections.max(adder);
        System.out.println("farea: "+farea);
        return farea;
    }

    //so much simpler
    //Time Complexity O(n^2)
    public static Integer container2(int [] arr){
        Integer maxarea=0;
        Integer width,length,area;
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length;j++){
                width=Math.abs(j-i);
                length=Math.min(arr[i],arr[j]);
                area=width*length;
                maxarea=Math.max(maxarea,area);
            }
        }
        System.out.println(maxarea);
        return maxarea;
    }
    //Optimal Solution
    //Time Complexity O(n)
    public static Integer container3(int [] arr){
        //we will use the two pointer technique, to find the area between two elements we need to find the min(a,b) and width
        //the height of the largest element does not matter
        Integer maxarea,length,width,pntr,area;
        maxarea=length=width=pntr=area=0;
        pntr = arr.length-1;
        int i=0;
        while (i<pntr){
            length = Math.min(arr[i],arr[pntr]);
            width = Math.abs(i-pntr);
            area = length*width;
            maxarea = Math.max(maxarea,area);
            if (i<=pntr)
                i++;
            else
                pntr--;
        }
        return maxarea;
    }
}
