package com.util.dataStructure.Array;

import java.util.Stack;

/*
 * Given an array of integers(positive or negative), print the next greater element of all elements 
 * in the array. If there is no greater element then print null.
Next greater element of an array element array[i], is an integer array[j], such that
1. array[i] is less than array[j]
2. i is less than j
3. j - i is minimum
i.e. array[j] is the first element on the right of array[i] which is greater than array[i].
 */

public class NextGreatElementArray {

    public static void main(String[] args) {
        int[] array =  {90,42,10,5,200,90,190};
        nextGreaterElement(array);
    }

    private static void nextGreaterElement(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        if(array.length==0 || array == null){
            System.out.println("empty Array");
            return;
        }
        stack.push(array[0]);
        for(int i=1;i<array.length;i++){
            while(!stack.isEmpty() && stack.peek() < array[i]){
                System.out.println("next great element of "+ stack.pop() + " is " + array[i]);
            }
            stack.push(array[i]);
        }
        
        while(!stack.isEmpty()){
            System.out.println("next great element of "+ stack.pop() + " is " +null);
        }
        
    }

}
