package com.util.dataStructure.Array;
//find pivot element in sorted rotated array
//O(nlogn)//time compleexity

public class PivotSortedRotatedArray {

    public static void main(String[] args) {
        int[] array = {9,10,1,4,5,6};
        int[] array1 = {1};
        int[] array2 = {10,0,1,4,5,6,10};
        
        System.out.println("Pivot element of array :" + getPivotElement(array) );
        System.out.println("Pivot element of array1 :" + getPivotElement(array1) );
        System.out.println("Pivot element of array2 :" + getPivotElement(array2));

    }

    private static int getPivotElement(int[] array) {
        if(array.length ==0){
            return -1;//denote error
        }

        if(array[0] < array[array.length-1] || array.length ==1){
            return array[0];
        }
        int left =0;
        int right = array.length-1;
        while(left<=right){
            int mid =(left+right)/2;
            if(mid < array.length-1 && array[mid]>array[mid+1]){
                return array[mid+1];
            }else if(array[left] <=array[mid]){
                left =mid +1;
            }else{
                right = mid-1;
            }
        }
        
        
        
        return 0;
    }

}
