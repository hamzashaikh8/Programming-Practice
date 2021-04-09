package com.company;

public class rainwater {
    /* Problem: Given an array of integers representing an elevation map
    where the width of each bar is 1, return how much rainwater can be trapped.
     */
    /*
    Constraints:
    Do the left and right sides of the graph count as walls? No
    Will there be negative integers? No
    */
    public static void main(String [] args){
        int [] arr = {0,1,0,2,1,0,3,1,0,1,2};
        int num = rainwater2(arr);
        System.out.println(num);

    }
    //Non optimal solution
    //Time complexity O(n^2)
    public static int rainwater(int [] arr){
        int leftp,blocks,add,rightp,maxleft,maxright;
        leftp=blocks=add=rightp=0;
        for (int i=0;i<arr.length;i++){
             leftp=i;//current water will be Math.min(maxleft,maxright) - crntheight
             rightp=i;
             maxleft=maxright=0;
             while (leftp>=0){ //while all the water has the potential to not all drip out
                 maxleft=Math.max(maxleft,arr[leftp]);
                 leftp--;
             }
             while (rightp<arr.length){
                 maxright=Math.max(maxright,arr[rightp]);
                 rightp++;
             }
             System.out.println("************");
             System.out.println("maxleft: "+maxleft);
             System.out.println("maxright: "+maxright);
             System.out.println("i: "+i);
             System.out.println("arr[i]: "+arr[i]);
             add=Math.min(maxleft,maxright) - arr[i];
             if (add>=0)
                 blocks+=add;
        }
        return blocks;
    }
    //Optimal Solution
    //Time Complexity O(n)
    public static int rainwater2(int [] arr){
        int blocks,pl,pr,maxleft,maxright,crntwater;
        blocks=pl=crntwater=maxleft=maxright=0; //initialize left pointer to 0
        pr = arr.length-1; //right pointer to the right
        //now we are going to loop over the array and calculate the current water using the left pointer
        while (pl!=pr){
            if (arr[pl]<arr[pr]) { //we will calculate from the left and see if the water is leaking there or can it form a container
                         //a container can only be formed if there is a wall higher than the current value to the left of the pointer otherwise it will leak
                if (arr[pl]>maxleft){ //current height is bigger than maxleft, then there is no way water can be trapped on top _=..
                    maxleft=arr[pl];
                    pl++;
                }
                else if (arr[pl]<=maxleft){ //if crntheight is less than there is a possibility that there is water trapped =_......
                    crntwater = maxleft-arr[pl];
                    blocks+=crntwater;
                    pl++;
                }
            }
            else if (arr[pl]>= arr[pr]){ //we will calculate from the right and see if the water is leaking there or can it form a container
                if (arr[pr]>maxright){ //no way to form a container =_
                    maxright=arr[pr];
                    pr--;
                } else if (arr[pr]<=maxright){ //water could be trapped _=
                    crntwater = maxright - arr[pr];
                    blocks+=crntwater;
                    pr--;
                }
            }
        }
        return blocks;

    }
}
