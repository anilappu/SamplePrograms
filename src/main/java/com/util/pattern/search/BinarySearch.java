package com.util.pattern.search;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array  = new int[]{2,4,6,7,8,9,10,233};
        System.out.println("is 7 present in array" + binarySearchRecursive(7,array));
        System.out.println("is 8 present in array" + binarySearchIterative(8,array));
        
        System.out.println("is 5 present in array" + binarySearchRecursive(5,array));
        System.out.println("is 3 present in array" + binarySearchIterative(3,array));


    }

    private static boolean binarySearchIterative(int val, int[] theArray) {
        int left=0;
        int right = theArray.length -1;
        
        while(left <= right){
            int mid = left + ((right-left)/2);
            if(theArray[mid]==val){
                return true;
            }else if(theArray[mid] >val){
                right = mid-1;
            }else if(theArray[mid] <val){
                left=mid +1;
            }
        }
        return false;
    }

    private static boolean binarySearchRecursive(int i,int []theArray) {
        if(theArray.length ==0)
            return false;
        return binarySearchRecursive(theArray,i,0,theArray.length-1);
       
    }

    private static boolean binarySearchRecursive(int[] theArray, int val,int left, int right) {
        while(left <= right){
            int mid = left + ((right-left)/2);
            if(theArray[mid]==val){
                return true;
            }else if(theArray[mid] >val){
                return binarySearchRecursive(theArray,val,left,mid-1);
            }else if(theArray[mid] <val){
                return binarySearchRecursive(theArray,val,mid +1,right);
            }
            
        }
        return false;
    }

}
