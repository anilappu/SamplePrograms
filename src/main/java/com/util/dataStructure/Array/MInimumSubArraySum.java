package com.util.dataStructure.Array;

public class MInimumSubArraySum {

    public static void main(String[] args) {
        int[] array = {2,3,1,2,4,3,7};
         int k = 7;
        printMinSubArrayWithSum(array, k);

    }

    private static void printMinSubArrayWithSum(int[] array, int k) {
        int sumStart =0;
        int sumEnd =0;
        int j=0;
        int sum=0;
        int lengthSubArry =0;
        
        for(int i=0;i<array.length;i++){
           while(sum<k && j<array.length){
               sum = sum +array[j];
               j++;
           }
           if(sum==k){
               if(sumStart==0 && sumEnd ==0){
                   sumStart=i;
                   sumEnd=j;
                   lengthSubArry = j-i +1;
               }else if(j-i +1 < lengthSubArry){
                   sumStart=i;
                   sumEnd=j;
                   lengthSubArry = j-i +1;
               }
               sum =sum -array[i];
           }else{
               sum =sum -array[i];
               if(sum==k){
                   if(sumStart==0 && sumEnd ==0){
                       sumStart=i;
                       sumEnd=j;
                       lengthSubArry = j-i +1;
                   }else if(j-i +1 < lengthSubArry){
                       sumStart=i;
                       sumEnd=j;
                       lengthSubArry = j-i +1;
                   }
                   
               }
           }
        }
        
        System.out.println("Print minumal sum sub array");
        
        for(int l= sumStart;l<sumEnd;l++){
            System.out.print( array[l] + "");
        }
        
        
    }

}
