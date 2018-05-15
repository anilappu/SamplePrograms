package com.util.algorithm.Sort;

public class MergeSort {

    public static void main(String[] args) {
        int [] array = new int[]{20,1,3,14,11,9,5,4};
        
        int [] array1 = new int[]{1,2,3,4,5};
        
        mergeSort(array);
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println();
        mergeSort(array1);
        for(int i: array1){
            System.out.print(i + " ");
        }

    }

    private static void mergeSort(int[] array) {
        mergeSort(array,new int[array.length],0,array.length-1);
        
    }

    private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd){
            return;
        }
        int mid = (leftStart + rightEnd)/2;
        mergeSort(array,temp,leftStart,mid);
        mergeSort(array,temp,mid+1,rightEnd);
        mergeHalves(array,temp,leftStart,rightEnd);
        
    }

    private static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd)/2;
        int rightStart = leftEnd+1;
        int size= rightEnd-leftStart +1;
        int index = leftStart;
        int left = leftStart;
        int right = rightStart;
        
        while(left<=leftEnd && right <=rightEnd){
            if(array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            }else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }
        
        System.arraycopy(array, left, temp, index, leftEnd-left+1);
        System.arraycopy(array, right, temp, index, rightEnd-right+1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }

}
