package com.util.dataStructure.Array;

/* find a peak element in un sorted array
 * peak element - element is greater than both of its neightbors*/



public class ArrayPeakElement {

    public static void main(String[] args) {
       int[] array1 =  {10,4,5,8,2,80,21};
       int[] array2 =  {10,4,50,8,2,80,21};
       int[] array3 =  {90,42,25,58,22,80,321};
       
       System.out.println("Peal Elemnt of Array 1 is " + getPeakElement(array1));
       System.out.println("Peal Elemnt of Array 2 is " + getPeakElement(array2));

       System.out.println("Peal Elemnt of Array 3 is " + getPeakElement(array3));

       
       
       
    }

    //use binary search to find peak element
    private static int getPeakElement(int[] array) {
       int start =0;
       int end = array.length;
       
       while(start <=end){
           int mid = start + end /2;
           if(isPeakElement(array,mid)){
               return array[mid];
           }else{
               end = mid -1;
           }
       }
        return -1;
    }
    
    private static boolean isPeakElement(int[] array, int index){
        if(index ==0 ){
            return array[index] > array[index+1]; 
        }else if(index == array.length -1){
            return array[index] > array[index-1]; 
        }else{
            return (array[index] > array[index-1] && array[index] > array[index+1]);
        }
    }

}
