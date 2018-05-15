package com.util.algorithm.Sort;

public class QuickSort {

    
    public static void main(String[] args) {
        int [] array = new int[]{20,1,3,14,11,9,5,4};
        
        int [] array1 = new int[]{1,2,3,4,5};
        
        quickSort(array);
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println();
        quickSort(array1);
        for(int i: array1){
            System.out.print(i + " ");
        }

    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
        
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left >=right){
            return;
        }
        int pivot = array[(left + right)/2];
        int index = partition(array,left,right,pivot);
        quickSort(array,left,index-1);
        quickSort(array,index,right);
        
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while(left<= right){
            while(array[left] < pivot){
                left++;
            }
            
            while(array[right] > pivot){
                right--;
            }
            if(left <= right){
                swap(array,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
        
    }
}
